package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.planDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "plan_dietetico_isabel_rios"
)

class PlanRepository(private val context: Context) {

    private object Keys {
        val COMPLETED_MEALS = stringSetPreferencesKey("completed_meals")
        val CHECKED_SHOPPING = stringSetPreferencesKey("checked_shopping")
        val CHECKED_INGREDIENTS = stringSetPreferencesKey("checked_ingredients")

        fun waterKey(dayIndex: Int) = intPreferencesKey("day_${dayIndex}_water")
        fun irbKey(dayIndex: Int) = booleanPreferencesKey("day_${dayIndex}_irb")
        fun bisKey(dayIndex: Int) = booleanPreferencesKey("day_${dayIndex}_bis")
        fun workoutKey(dayIndex: Int) = booleanPreferencesKey("day_${dayIndex}_workout")
    }

    private val dataStore: DataStore<Preferences>
        get() = context.applicationContext.planDataStore

    val completedMealIds: Flow<Set<String>> = dataStore.data
        .map { prefs -> prefs[Keys.COMPLETED_MEALS] ?: emptySet() }

    val checkedShoppingIds: Flow<Set<String>> = dataStore.data
        .map { prefs -> prefs[Keys.CHECKED_SHOPPING] ?: emptySet() }

    val checkedIngredientKeys: Flow<Set<String>> = dataStore.data
        .map { prefs -> prefs[Keys.CHECKED_INGREDIENTS] ?: emptySet() }

    val dailyHealthMap: Flow<Map<Int, DailyHealthEntity>> = dataStore.data
        .map { prefs ->
            (0..6).associateWith { dayIndex ->
                DailyHealthEntity(
                    dayIndex = dayIndex,
                    waterGlasses = prefs[Keys.waterKey(dayIndex)] ?: 0,
                    irbesartanTaken = prefs[Keys.irbKey(dayIndex)] ?: false,
                    bisoprololTaken = prefs[Keys.bisKey(dayIndex)] ?: false,
                    workoutDone = prefs[Keys.workoutKey(dayIndex)] ?: false
                )
            }
        }

    suspend fun setMealCompleted(mealId: String, isCompleted: Boolean) {
        dataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_MEALS]?.toMutableSet() ?: mutableSetOf()
            if (isCompleted) current.add(mealId) else current.remove(mealId)
            prefs[Keys.COMPLETED_MEALS] = current
        }
    }

    suspend fun setShoppingChecked(itemId: String, isChecked: Boolean) {
        dataStore.edit { prefs ->
            val current = prefs[Keys.CHECKED_SHOPPING]?.toMutableSet() ?: mutableSetOf()
            if (isChecked) current.add(itemId) else current.remove(itemId)
            prefs[Keys.CHECKED_SHOPPING] = current
        }
    }

    suspend fun setShoppingItemsChecked(itemIds: List<String>, isChecked: Boolean) {
        dataStore.edit { prefs ->
            val current = prefs[Keys.CHECKED_SHOPPING]?.toMutableSet() ?: mutableSetOf()
            if (isChecked) current.addAll(itemIds) else current.removeAll(itemIds.toSet())
            prefs[Keys.CHECKED_SHOPPING] = current
        }
    }

    suspend fun clearShoppingChecks() {
        dataStore.edit { prefs ->
            prefs.remove(Keys.CHECKED_SHOPPING)
        }
    }

    suspend fun setIngredientChecked(key: String, isChecked: Boolean) {
        dataStore.edit { prefs ->
            val current = prefs[Keys.CHECKED_INGREDIENTS]?.toMutableSet() ?: mutableSetOf()
            if (isChecked) current.add(key) else current.remove(key)
            prefs[Keys.CHECKED_INGREDIENTS] = current
        }
    }

    suspend fun updateWaterGlasses(dayIndex: Int, glasses: Int) {
        dataStore.edit { prefs ->
            prefs[Keys.waterKey(dayIndex)] = glasses.coerceIn(0, 13)
        }
    }

    suspend fun toggleIrbesartan(dayIndex: Int): Boolean {
        val current = dataStore.data.first()[Keys.irbKey(dayIndex)] ?: false
        val next = !current
        dataStore.edit { prefs ->
            prefs[Keys.irbKey(dayIndex)] = next
        }
        return next
    }

    suspend fun toggleBisoprolol(dayIndex: Int): Boolean {
        val current = dataStore.data.first()[Keys.bisKey(dayIndex)] ?: false
        val next = !current
        dataStore.edit { prefs ->
            prefs[Keys.bisKey(dayIndex)] = next
        }
        return next
    }

    suspend fun toggleWorkout(dayIndex: Int): Boolean {
        val current = dataStore.data.first()[Keys.workoutKey(dayIndex)] ?: false
        val next = !current
        dataStore.edit { prefs ->
            prefs[Keys.workoutKey(dayIndex)] = next
        }
        return next
    }

    suspend fun resetWeeklyProgress() {
        dataStore.edit { prefs ->
            prefs.remove(Keys.COMPLETED_MEALS)
            prefs.remove(Keys.CHECKED_INGREDIENTS)
            (0..6).forEach { dayIndex ->
                prefs.remove(Keys.waterKey(dayIndex))
                prefs.remove(Keys.irbKey(dayIndex))
                prefs.remove(Keys.bisKey(dayIndex))
                prefs.remove(Keys.workoutKey(dayIndex))
            }
        }
    }
}
