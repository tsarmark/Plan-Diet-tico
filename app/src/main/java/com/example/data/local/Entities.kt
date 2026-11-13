package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_checks")
data class MealCheckEntity(
    @PrimaryKey val mealId: String,
    val isCompleted: Boolean
)

@Entity(tableName = "shopping_checks")
data class ShoppingCheckEntity(
    @PrimaryKey val itemId: String,
    val isChecked: Boolean
)

@Entity(tableName = "daily_health")
data class DailyHealthEntity(
    @PrimaryKey val dayIndex: Int,
    val waterGlasses: Int = 0,
    val irbesartanTaken: Boolean = false,
    val bisoprololTaken: Boolean = false,
    val workoutDone: Boolean = false
)

@Entity(tableName = "ingredient_checks")
data class IngredientCheckEntity(
    @PrimaryKey val ingredientKey: String,
    val isChecked: Boolean
)
