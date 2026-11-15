package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.AppTab
import com.example.data.ClinicalCatalog
import com.example.data.DayPlan
import com.example.data.Meal
import com.example.data.MealSlot
import com.example.data.ShopCategory
import com.example.data.ShoppingCatalog
import com.example.data.ShoppingItem
import com.example.data.local.DailyHealthEntity
import com.example.data.local.PlanRepository
import java.util.Calendar
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private data class FilterState(
    val activeTab: AppTab = AppTab.PLAN,
    val selectedDayIndex: Int = computeTodayIndex(),
    val todayIndex: Int = computeTodayIndex(),
    val showAllWeekTogether: Boolean = false,
    val selectedSlot: MealSlot = MealSlot.ALL,
    val mealSearchQuery: String = "",
    val shopCategory: ShopCategory = ShopCategory.ALL,
    val shopSearchQuery: String = "",
    val hideCheckedShopItems: Boolean = false,
    val activeModalMealId: String? = null
)

private data class PersistedDataBundle(
    val mealIds: Set<String>,
    val shopIds: Set<String>,
    val healthMap: Map<Int, DailyHealthEntity>,
    val ingKeys: Set<String>,
    val currentWeightKg: Float,
    val customBiomarkers: Map<String, String>
)

data class PlanUiState(
    val activeTab: AppTab = AppTab.PLAN,
    val selectedDayIndex: Int = 0,
    val todayIndex: Int = 0,
    val showAllWeekTogether: Boolean = false,
    val selectedSlot: MealSlot = MealSlot.ALL,
    val mealSearchQuery: String = "",
    val shopCategory: ShopCategory = ShopCategory.ALL,
    val shopSearchQuery: String = "",
    val hideCheckedShopItems: Boolean = false,
    val activeModalMeal: Meal? = null,
    val completedMealIds: Set<String> = emptySet(),
    val checkedShoppingIds: Set<String> = emptySet(),
    val dailyHealthByDay: Map<Int, DailyHealthEntity> = emptyMap(),
    val checkedIngredientKeys: Set<String> = emptySet(),
    val currentWeightKg: Float = 123.0f,
    val customBiomarkers: Map<String, String> = emptyMap(),
    val days: List<DayPlan> = ClinicalCatalog.days,
    val shoppingItems: List<ShoppingItem> = ShoppingCatalog.items
) {
    val selectedDay: DayPlan
        get() = days.getOrElse(selectedDayIndex) { days.first() }

    val selectedDayHealth: DailyHealthEntity
        get() = dailyHealthByDay[selectedDayIndex] ?: DailyHealthEntity(dayIndex = selectedDayIndex)

    val completedMealsCount: Int
        get() = completedMealIds.size

    // Fitia-style consumed macros for the currently selected day
    private val selectedDayCompletedMeals: List<Meal>
        get() = selectedDay.meals.filter { completedMealIds.contains(it.id) }

    val selectedDayConsumedKcal: Int
        get() = selectedDayCompletedMeals.sumOf { it.macros.kcal }

    val selectedDayConsumedProt: Int
        get() = selectedDayCompletedMeals.sumOf { it.macros.prot }

    val selectedDayConsumedCarb: Int
        get() = selectedDayCompletedMeals.sumOf { it.macros.carb }

    val selectedDayConsumedFat: Int
        get() = selectedDayCompletedMeals.sumOf { it.macros.fat }

    val selectedDayConsumedFiber: Int
        get() = selectedDayCompletedMeals.sumOf { it.macros.fiber }

    val checkedShopCount: Int
        get() = shoppingItems.count { checkedShoppingIds.contains(it.id) }

    val checkedShopSoles: Double
        get() = shoppingItems.filter { checkedShoppingIds.contains(it.id) }.sumOf { it.priceSoles }

    val pendingShopSoles: Double
        get() = (ShoppingCatalog.totalBudgetSoles - checkedShopSoles).coerceAtLeast(0.0)
}

private fun computeTodayIndex(): Int {
    return when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> 0
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 2
        Calendar.THURSDAY -> 3
        Calendar.FRIDAY -> 4
        Calendar.SATURDAY -> 5
        Calendar.SUNDAY -> 6
        else -> 0
    }
}

class PlanViewModel(private val repository: PlanRepository) : ViewModel() {

    private val filters = MutableStateFlow(FilterState())

    private val _snackbarEvents = MutableSharedFlow<String>(extraBufferCapacity = 1)
    val snackbarEvents: SharedFlow<String> = _snackbarEvents.asSharedFlow()

    private val persistedBundleFlow = combine(
        combine(
            repository.completedMealIds,
            repository.checkedShoppingIds,
            repository.dailyHealthMap
        ) { mealIds, shopIds, healthMap ->
            Triple(mealIds, shopIds, healthMap)
        },
        combine(
            repository.checkedIngredientKeys,
            repository.currentWeightKg,
            repository.customBiomarkers
        ) { ingKeys, weightKg, biomarkers ->
            Triple(ingKeys, weightKg, biomarkers)
        }
    ) { firstTriple, secondTriple ->
        PersistedDataBundle(
            mealIds = firstTriple.first,
            shopIds = firstTriple.second,
            healthMap = firstTriple.third,
            ingKeys = secondTriple.first,
            currentWeightKg = secondTriple.second,
            customBiomarkers = secondTriple.third
        )
    }

    val uiState: StateFlow<PlanUiState> = combine(
        filters,
        persistedBundleFlow
    ) { f, persisted ->
        val modalMeal = f.activeModalMealId?.let { id ->
            ClinicalCatalog.allMealsFlat.find { it.id == id }
        }
        PlanUiState(
            activeTab = f.activeTab,
            selectedDayIndex = f.selectedDayIndex,
            todayIndex = f.todayIndex,
            showAllWeekTogether = f.showAllWeekTogether,
            selectedSlot = f.selectedSlot,
            mealSearchQuery = f.mealSearchQuery,
            shopCategory = f.shopCategory,
            shopSearchQuery = f.shopSearchQuery,
            hideCheckedShopItems = f.hideCheckedShopItems,
            activeModalMeal = modalMeal,
            completedMealIds = persisted.mealIds,
            checkedShoppingIds = persisted.shopIds,
            dailyHealthByDay = persisted.healthMap,
            checkedIngredientKeys = persisted.ingKeys,
            currentWeightKg = persisted.currentWeightKg,
            customBiomarkers = persisted.customBiomarkers
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PlanUiState(
            selectedDayIndex = computeTodayIndex(),
            todayIndex = computeTodayIndex()
        )
    )

    fun selectTab(tab: AppTab) {
        filters.update { it.copy(activeTab = tab) }
    }

    fun selectDay(dayIndex: Int) {
        filters.update {
            it.copy(
                selectedDayIndex = dayIndex.coerceIn(0, 6),
                showAllWeekTogether = false
            )
        }
    }

    fun toggleShowAllWeek() {
        filters.update { it.copy(showAllWeekTogether = !it.showAllWeekTogether) }
    }

    fun setSlotFilter(slot: MealSlot) {
        filters.update { it.copy(selectedSlot = slot) }
    }

    fun setMealSearchQuery(query: String) {
        filters.update { it.copy(mealSearchQuery = query) }
    }

    fun setShopCategory(category: ShopCategory) {
        filters.update { it.copy(shopCategory = category) }
    }

    fun setShopSearchQuery(query: String) {
        filters.update { it.copy(shopSearchQuery = query) }
    }

    fun toggleHideCheckedShopItems() {
        filters.update { it.copy(hideCheckedShopItems = !it.hideCheckedShopItems) }
    }

    fun openRecipe(mealId: String) {
        filters.update { it.copy(activeModalMealId = mealId) }
    }

    fun closeRecipe() {
        filters.update { it.copy(activeModalMealId = null) }
    }

    fun navigateModalMeal(direction: Int) {
        val currentId = filters.value.activeModalMealId ?: return
        val allMeals = ClinicalCatalog.allMealsFlat
        val idx = allMeals.indexOfFirst { it.id == currentId }
        if (idx == -1) return
        val nextIdx = (idx + direction + allMeals.size) % allMeals.size
        filters.update { it.copy(activeModalMealId = allMeals[nextIdx].id) }
    }

    fun toggleMealCompleted(mealId: String) {
        val currentlyDone = uiState.value.completedMealIds.contains(mealId)
        viewModelScope.launch {
            repository.setMealCompleted(mealId, !currentlyDone)
        }
    }

    fun toggleIngredientChecked(mealId: String, index: Int) {
        val key = "${mealId}_$index"
        val currentlyChecked = uiState.value.checkedIngredientKeys.contains(key)
        viewModelScope.launch {
            repository.setIngredientChecked(key, !currentlyChecked)
        }
    }

    fun toggleShoppingItem(itemId: String) {
        val currentlyChecked = uiState.value.checkedShoppingIds.contains(itemId)
        viewModelScope.launch {
            repository.setShoppingChecked(itemId, !currentlyChecked)
        }
    }

    fun toggleShoppingCategoryAll(category: ShopCategory) {
        val targetItems = ShoppingCatalog.items.filter { item ->
            when (category) {
                ShopCategory.ALL -> true
                ShopCategory.SEMANAL_FRESCOS -> item.isWeeklyReplenishment
                else -> item.category == category
            }
        }
        val checked = uiState.value.checkedShoppingIds
        val allChecked = targetItems.isNotEmpty() && targetItems.all { checked.contains(it.id) }
        viewModelScope.launch {
            repository.setShoppingItemsChecked(targetItems.map { it.id }, !allChecked)
            _snackbarEvents.tryEmit(
                if (!allChecked) "Sección marcada en tu carrito Agora" else "Sección desmarcada"
            )
        }
    }

    fun clearAllShoppingChecks() {
        viewModelScope.launch {
            repository.clearShoppingChecks()
            _snackbarEvents.tryEmit("Lista de compras Agora desmarcada")
        }
    }

    fun incrementWater(dayIndex: Int) {
        val current = uiState.value.dailyHealthByDay[dayIndex]?.waterGlasses ?: 0
        val next = if (current >= 13) 0 else current + 1
        viewModelScope.launch {
            repository.updateWaterGlasses(dayIndex, next)
        }
    }

    fun adjustWater(dayIndex: Int, delta: Int) {
        val current = uiState.value.dailyHealthByDay[dayIndex]?.waterGlasses ?: 0
        val next = (current + delta).coerceIn(0, 13)
        viewModelScope.launch {
            repository.updateWaterGlasses(dayIndex, next)
        }
    }

    fun setWaterGlasses(dayIndex: Int, targetCount: Int) {
        val current = uiState.value.dailyHealthByDay[dayIndex]?.waterGlasses ?: 0
        val next = if (current == targetCount) (targetCount - 1).coerceAtLeast(0) else targetCount
        viewModelScope.launch {
            repository.updateWaterGlasses(dayIndex, next)
        }
    }

    fun toggleIrbesartan(dayIndex: Int) {
        viewModelScope.launch {
            val taken = repository.toggleIrbesartan(dayIndex)
            _snackbarEvents.tryEmit(
                if (taken) "Irbesartán 150 mg (08:00 AM) registrado" else "Irbesartán 150 mg pendiente"
            )
        }
    }

    fun toggleBisoprolol(dayIndex: Int) {
        viewModelScope.launch {
            val taken = repository.toggleBisoprolol(dayIndex)
            _snackbarEvents.tryEmit(
                if (taken) "Bisoprolol 2.5 mg (14:00 PM) registrado" else "Bisoprolol 2.5 mg pendiente"
            )
        }
    }

    fun toggleWorkout(dayIndex: Int) {
        viewModelScope.launch {
            val done = repository.toggleWorkout(dayIndex)
            _snackbarEvents.tryEmit(
                if (done) "Entreno 2x2 m (11:00–13:00) completado" else "Entreno marcado como pendiente"
            )
        }
    }

    fun updateWeight(newWeightKg: Float) {
        viewModelScope.launch {
            repository.updateCurrentWeight(newWeightKg)
            _snackbarEvents.tryEmit("Peso actualizado a ${String.format(java.util.Locale.US, "%.1f", newWeightKg)} kg")
        }
    }

    fun updateBiomarker(markerId: String, newValue: String) {
        viewModelScope.launch {
            repository.updateBiomarker(markerId, newValue)
            _snackbarEvents.tryEmit("Marcador clínico actualizado")
        }
    }

    fun resetWeeklyProgress() {
        viewModelScope.launch {
            repository.resetWeeklyProgress()
            _snackbarEvents.tryEmit("Progreso semanal de comidas, agua y medicación reiniciado")
        }
    }

    fun notifyMessage(msg: String) {
        _snackbarEvents.tryEmit(msg)
    }

    companion object {
        fun provideFactory(repository: PlanRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return PlanViewModel(repository) as T
                }
            }
    }
}
