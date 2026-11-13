package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CalendarViewWeek
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.DayPlan
import com.example.data.Meal
import com.example.data.MealSlot
import com.example.ui.PlanUiState
import com.example.ui.theme.Amber100
import com.example.ui.theme.Amber700
import com.example.ui.theme.Emerald100
import com.example.ui.theme.Emerald50
import com.example.ui.theme.Emerald600
import com.example.ui.theme.Emerald700
import com.example.ui.theme.Emerald900
import com.example.ui.theme.Indigo100
import com.example.ui.theme.Indigo600
import com.example.ui.theme.Indigo700
import com.example.ui.theme.Purple100
import com.example.ui.theme.Purple700
import com.example.ui.theme.Sky100
import com.example.ui.theme.Sky50
import com.example.ui.theme.Sky600
import com.example.ui.theme.Sky700
import java.util.Locale

@Composable
fun PlanScreen(
    uiState: PlanUiState,
    onSelectDay: (Int) -> Unit,
    onToggleShowAllWeek: () -> Unit,
    onSelectSlot: (MealSlot) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onToggleMealCompleted: (String) -> Unit,
    onOpenRecipe: (String) -> Unit,
    onToggleIrbesartan: (Int) -> Unit,
    onToggleBisoprolol: (Int) -> Unit,
    onToggleWorkout: (Int) -> Unit,
    onIncrementWater: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val query = uiState.mealSearchQuery.trim().lowercase(Locale.getDefault())
    val daysToDisplay = if (uiState.showAllWeekTogether || query.isNotEmpty()) {
        uiState.days
    } else {
        listOf(uiState.selectedDay)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 700.dp)
                .testTag("plan_meals_list"),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "day_selector_card") {
                DaySelectorCard(
                    days = uiState.days,
                    selectedDayIndex = uiState.selectedDayIndex,
                    todayIndex = uiState.todayIndex,
                    showAllWeekTogether = uiState.showAllWeekTogether,
                    completedMealIds = uiState.completedMealIds,
                    onSelectDay = onSelectDay,
                    onToggleShowAllWeek = onToggleShowAllWeek
                )
            }

            item(key = "daily_quick_strip") {
                DailyQuickSummaryCard(
                    day = uiState.selectedDay,
                    waterGlasses = uiState.selectedDayHealth.waterGlasses,
                    irbesartanTaken = uiState.selectedDayHealth.irbesartanTaken,
                    bisoprololTaken = uiState.selectedDayHealth.bisoprololTaken,
                    workoutDone = uiState.selectedDayHealth.workoutDone,
                    onToggleIrbesartan = { onToggleIrbesartan(uiState.selectedDayIndex) },
                    onToggleBisoprolol = { onToggleBisoprolol(uiState.selectedDayIndex) },
                    onToggleWorkout = { onToggleWorkout(uiState.selectedDayIndex) },
                    onIncrementWater = { onIncrementWater(uiState.selectedDayIndex) }
                )
            }

            item(key = "search_and_slots") {
                SearchAndSlotsSection(
                    query = uiState.mealSearchQuery,
                    selectedSlot = uiState.selectedSlot,
                    onQueryChange = onSearchQueryChange,
                    onSelectSlot = onSelectSlot
                )
            }

            var renderedAnyMeal = false
            daysToDisplay.forEach { day ->
                val filteredMeals = day.meals.filter { meal ->
                    val slotOk = uiState.selectedSlot == MealSlot.ALL || meal.slot == uiState.selectedSlot
                    val queryOk = query.isEmpty() ||
                        meal.title.lowercase(Locale.getDefault()).contains(query) ||
                        meal.shortDesc.lowercase(Locale.getDefault()).contains(query) ||
                        meal.ingredients.any { it.lowercase(Locale.getDefault()).contains(query) }
                    slotOk && queryOk
                }

                if (filteredMeals.isNotEmpty()) {
                    renderedAnyMeal = true
                    if (uiState.showAllWeekTogether || query.isNotEmpty()) {
                        item(key = "header_day_${day.dayIndex}") {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp, start = 4.dp, end = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${day.dayName.uppercase()} • OPCIÓN ${day.dayIndex + 1}",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Text(
                                    text = day.focusTag,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }

                    items(items = filteredMeals, key = { it.id }) { meal ->
                        MealItemCard(
                            meal = meal,
                            isCompleted = uiState.completedMealIds.contains(meal.id),
                            onOpenRecipe = { onOpenRecipe(meal.id) },
                            onToggleCompleted = { onToggleMealCompleted(meal.id) }
                        )
                    }
                }
            }

            if (!renderedAnyMeal) {
                item(key = "empty_meals_state") {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = "No se encontraron comidas con ese filtro.",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DaySelectorCard(
    days: List<DayPlan>,
    selectedDayIndex: Int,
    todayIndex: Int,
    showAllWeekTogether: Boolean,
    completedMealIds: Set<String>,
    onSelectDay: (Int) -> Unit,
    onToggleShowAllWeek: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SELECCIONA EL DÍA (OPCIONES 1 A 7)",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(
                    onClick = onToggleShowAllWeek,
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.testTag("toggle_all_week_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarViewWeek,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (showAllWeekTogether) "Ver día actual" else "Ver 7 días",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                days.forEachIndexed { idx, day ->
                    val isSelected = !showAllWeekTogether && idx == selectedDayIndex
                    val doneCount = day.meals.count { completedMealIds.contains(it.id) }
                    val isToday = idx == todayIndex

                    val bgColor by animateColorAsState(
                        targetValue = if (isSelected) Emerald700 else MaterialTheme.colorScheme.surfaceVariant,
                        label = "dayPillBg"
                    )
                    val contentColor = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .minimumInteractiveComponentSize()
                            .clip(RoundedCornerShape(14.dp))
                            .background(bgColor)
                            .border(
                                width = 1.dp,
                                color = if (isSelected) Emerald900 else if (isToday) Emerald600 else MaterialTheme.colorScheme.outline,
                                shape = RoundedCornerShape(14.dp)
                            )
                            .clickable { onSelectDay(idx) }
                            .padding(vertical = 8.dp, horizontal = 2.dp)
                            .testTag("day_pill_$idx"),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = if (isToday) "HOY" else "OP ${idx + 1}",
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isSelected) Emerald100 else if (isToday) Emerald700 else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = day.shortName,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.ExtraBold,
                            color = contentColor
                        )
                        Text(
                            text = "$doneCount/5",
                            style = MaterialTheme.typography.labelSmall,
                            color = when {
                                isSelected -> Emerald100
                                doneCount == 5 -> Emerald600
                                else -> MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DailyQuickSummaryCard(
    day: DayPlan,
    waterGlasses: Int,
    irbesartanTaken: Boolean,
    bisoprololTaken: Boolean,
    workoutDone: Boolean,
    onToggleIrbesartan: () -> Unit,
    onToggleBisoprolol: () -> Unit,
    onToggleWorkout: () -> Unit,
    onIncrementWater: () -> Unit
) {
    val liters = String.format(Locale.US, "%.2f", waterGlasses * 0.25)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = day.optionLabel.uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "${day.dayName} — ${day.focusTag}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = "${day.totalKcal} kcal • ${day.totalProt}g P • ${day.totalFiber}g Fibra",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                QuickCheckChip(
                    timeLabel = "08:00 AM",
                    title = "Irbesartán",
                    checked = irbesartanTaken,
                    accentBg = Sky50,
                    accentTint = Sky700,
                    icon = Icons.Filled.Medication,
                    onClick = onToggleIrbesartan,
                    testTag = "quick_med_irb",
                    modifier = Modifier.weight(1f)
                )

                QuickCheckChip(
                    timeLabel = "11:00 AM",
                    title = "Entreno 2x2",
                    checked = workoutDone,
                    accentBg = Emerald50,
                    accentTint = Emerald700,
                    icon = Icons.Filled.FitnessCenter,
                    onClick = onToggleWorkout,
                    testTag = "quick_workout",
                    modifier = Modifier.weight(1f)
                )

                QuickCheckChip(
                    timeLabel = "14:00 PM",
                    title = "Bisoprolol",
                    checked = bisoprololTaken,
                    accentBg = Indigo100.copy(alpha = 0.45f),
                    accentTint = Indigo700,
                    icon = Icons.Filled.Medication,
                    onClick = onToggleBisoprolol,
                    testTag = "quick_med_bis",
                    modifier = Modifier.weight(1f)
                )
            }

            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Sky50,
                border = BorderStroke(1.dp, Sky600.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.WaterDrop,
                            contentDescription = null,
                            tint = Sky600,
                            modifier = Modifier.size(18.dp)
                        )
                        Column {
                            Text(
                                text = "Hidratación Renal: $liters L / 3.25 L",
                                style = MaterialTheme.typography.labelMedium,
                                color = Sky700
                            )
                            Text(
                                text = "$waterGlasses de 13 vasos (250 ml c/u)",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF334155)
                            )
                        }
                    }

                    Surface(
                        onClick = onIncrementWater,
                        shape = RoundedCornerShape(12.dp),
                        color = Sky600,
                        contentColor = Color.White,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("quick_water_plus_btn")
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+1 Vaso",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun QuickCheckChip(
    timeLabel: String,
    title: String,
    checked: Boolean,
    accentBg: Color,
    accentTint: Color,
    icon: ImageVector,
    onClick: () -> Unit,
    testTag: String,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = if (checked) Emerald50 else accentBg,
        border = BorderStroke(
            1.dp,
            if (checked) Emerald600 else accentTint.copy(alpha = 0.28f)
        ),
        modifier = modifier
            .minimumInteractiveComponentSize()
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = if (checked) Icons.Filled.CheckCircle else icon,
                contentDescription = null,
                tint = if (checked) Emerald600 else accentTint,
                modifier = Modifier.size(16.dp)
            )
            Column {
                Text(
                    text = timeLabel,
                    style = MaterialTheme.typography.labelSmall,
                    color = if (checked) Emerald700 else accentTint,
                    maxLines = 1
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF0F172A),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun SearchAndSlotsSection(
    query: String,
    selectedSlot: MealSlot,
    onQueryChange: (String) -> Unit,
    onSelectSlot: (MealSlot) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("meal_search_input"),
            placeholder = {
                Text(
                    text = stringResource(R.string.search_meals_hint),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { onQueryChange("") }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.clear_search_cd),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(18.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            MealSlot.entries.forEach { slot ->
                val isSelected = selectedSlot == slot
                FilterChip(
                    selected = isSelected,
                    onClick = { onSelectSlot(slot) },
                    label = {
                        Text(
                            text = slot.chipLabel,
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.onBackground,
                        selectedLabelColor = MaterialTheme.colorScheme.background,
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier.testTag("slot_chip_${slot.id}")
                )
            }
        }
    }
}

private data class SlotVisuals(
    val pillBg: Color,
    val pillText: Color,
    val accentStrip: Color,
    val icon: ImageVector
)

private fun visualsForSlot(slot: MealSlot): SlotVisuals = when (slot) {
    MealSlot.DESAYUNO -> SlotVisuals(Amber100, Amber700, Amber700, Icons.Filled.WbSunny)
    MealSlot.MEDIA_MANANA -> SlotVisuals(Emerald100, Emerald900, Emerald600, Icons.Filled.Bolt)
    MealSlot.ALMUERZO -> SlotVisuals(Sky100, Sky700, Sky600, Icons.Filled.Restaurant)
    MealSlot.MEDIA_TARDE -> SlotVisuals(Purple100, Purple700, Purple700, Icons.Filled.LocalCafe)
    MealSlot.CENA -> SlotVisuals(Indigo100, Indigo700, Indigo600, Icons.Filled.NightsStay)
    MealSlot.ALL -> SlotVisuals(Emerald100, Emerald900, Emerald600, Icons.Filled.Restaurant)
}

@Composable
private fun MealItemCard(
    meal: Meal,
    isCompleted: Boolean,
    onOpenRecipe: () -> Unit,
    onToggleCompleted: () -> Unit
) {
    val visuals = visualsForSlot(meal.slot)

    Card(
        onClick = onOpenRecipe,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("meal_card_${meal.id}"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.22f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(165.dp)
                    .background(visuals.accentStrip)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(visuals.pillBg)
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = visuals.icon,
                            contentDescription = null,
                            tint = visuals.pillText,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "${meal.time} • ${meal.slotLabel}",
                            style = MaterialTheme.typography.labelMedium,
                            color = visuals.pillText
                        )
                    }

                    IconButton(
                        onClick = onToggleCompleted,
                        modifier = Modifier
                            .size(48.dp)
                            .testTag("check_meal_${meal.id}")
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isCompleted) Emerald600 else MaterialTheme.colorScheme.surfaceVariant
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (isCompleted) Emerald600 else MaterialTheme.colorScheme.outline,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = if (isCompleted) "Desmarcar comida" else "Marcar comida completada",
                                tint = if (isCompleted) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                Text(
                    text = meal.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface,
                    textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None
                )

                Text(
                    text = meal.shortDesc,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                if (meal.medAlert != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Sky50)
                            .border(1.dp, Sky600.copy(alpha = 0.25f), RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.NotificationsActive,
                            contentDescription = null,
                            tint = Sky700,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = meal.medAlert,
                            style = MaterialTheme.typography.labelSmall,
                            color = Sky700,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${meal.macros.kcal} kcal • ${meal.macros.prot}g Prot • ${meal.macros.carb}g C • ${meal.macros.fiber}g Fibra",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Ver Receta",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}
