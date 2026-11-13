package com.example.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlanRepository(private val dao: PlanDao) {

    val completedMealIds: Flow<Set<String>> = dao.observeCompletedMeals()
        .map { list -> list.filter { it.isCompleted }.map { it.mealId }.toSet() }

    val checkedShoppingIds: Flow<Set<String>> = dao.observeCheckedShoppingItems()
        .map { list -> list.filter { it.isChecked }.map { it.itemId }.toSet() }

    val dailyHealthMap: Flow<Map<Int, DailyHealthEntity>> = dao.observeDailyHealth()
        .map { list -> list.associateBy { it.dayIndex } }

    val checkedIngredientKeys: Flow<Set<String>> = dao.observeCheckedIngredients()
        .map { list -> list.filter { it.isChecked }.map { it.ingredientKey }.toSet() }

    suspend fun setMealCompleted(mealId: String, isCompleted: Boolean) {
        dao.upsertMealCheck(MealCheckEntity(mealId = mealId, isCompleted = isCompleted))
    }

    suspend fun setShoppingChecked(itemId: String, isChecked: Boolean) {
        dao.upsertShoppingCheck(ShoppingCheckEntity(itemId = itemId, isChecked = isChecked))
    }

    suspend fun setShoppingItemsChecked(itemIds: List<String>, isChecked: Boolean) {
        dao.upsertShoppingChecks(itemIds.map { ShoppingCheckEntity(itemId = it, isChecked = isChecked) })
    }

    suspend fun clearShoppingChecks() {
        dao.clearAllShoppingChecks()
    }

    suspend fun setIngredientChecked(key: String, isChecked: Boolean) {
        dao.upsertIngredientCheck(IngredientCheckEntity(ingredientKey = key, isChecked = isChecked))
    }

    suspend fun updateWaterGlasses(dayIndex: Int, glasses: Int) {
        val current = dao.getDailyHealthOnce(dayIndex) ?: DailyHealthEntity(dayIndex = dayIndex)
        dao.upsertDailyHealth(current.copy(waterGlasses = glasses.coerceIn(0, 13)))
    }

    suspend fun toggleIrbesartan(dayIndex: Int): Boolean {
        val current = dao.getDailyHealthOnce(dayIndex) ?: DailyHealthEntity(dayIndex = dayIndex)
        val next = !current.irbesartanTaken
        dao.upsertDailyHealth(current.copy(irbesartanTaken = next))
        return next
    }

    suspend fun toggleBisoprolol(dayIndex: Int): Boolean {
        val current = dao.getDailyHealthOnce(dayIndex) ?: DailyHealthEntity(dayIndex = dayIndex)
        val next = !current.bisoprololTaken
        dao.upsertDailyHealth(current.copy(bisoprololTaken = next))
        return next
    }

    suspend fun toggleWorkout(dayIndex: Int): Boolean {
        val current = dao.getDailyHealthOnce(dayIndex) ?: DailyHealthEntity(dayIndex = dayIndex)
        val next = !current.workoutDone
        dao.upsertDailyHealth(current.copy(workoutDone = next))
        return next
    }

    suspend fun resetWeeklyProgress() {
        dao.clearAllMealChecks()
        dao.clearAllDailyHealth()
        dao.clearAllIngredientChecks()
    }
}
