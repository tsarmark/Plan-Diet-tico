package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanDao {
    @Query("SELECT * FROM meal_checks WHERE isCompleted = 1")
    fun observeCompletedMeals(): Flow<List<MealCheckEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMealCheck(entity: MealCheckEntity)

    @Query("DELETE FROM meal_checks")
    suspend fun clearAllMealChecks()

    @Query("SELECT * FROM shopping_checks WHERE isChecked = 1")
    fun observeCheckedShoppingItems(): Flow<List<ShoppingCheckEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertShoppingCheck(entity: ShoppingCheckEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertShoppingChecks(entities: List<ShoppingCheckEntity>)

    @Query("DELETE FROM shopping_checks")
    suspend fun clearAllShoppingChecks()

    @Query("SELECT * FROM daily_health")
    fun observeDailyHealth(): Flow<List<DailyHealthEntity>>

    @Query("SELECT * FROM daily_health WHERE dayIndex = :dayIndex LIMIT 1")
    suspend fun getDailyHealthOnce(dayIndex: Int): DailyHealthEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDailyHealth(entity: DailyHealthEntity)

    @Query("DELETE FROM daily_health")
    suspend fun clearAllDailyHealth()

    @Query("SELECT * FROM ingredient_checks WHERE isChecked = 1")
    fun observeCheckedIngredients(): Flow<List<IngredientCheckEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertIngredientCheck(entity: IngredientCheckEntity)

    @Query("DELETE FROM ingredient_checks")
    suspend fun clearAllIngredientChecks()
}
