package com.example.data.local

data class DailyHealthEntity(
    val dayIndex: Int,
    val waterGlasses: Int = 0,
    val irbesartanTaken: Boolean = false,
    val bisoprololTaken: Boolean = false,
    val workoutDone: Boolean = false
)
