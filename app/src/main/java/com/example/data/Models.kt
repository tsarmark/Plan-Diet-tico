package com.example.data

enum class AppTab {
    PLAN,
    SHOP,
    HEALTH
}

enum class MealSlot(val id: String, val chipLabel: String) {
    ALL("all", "Todas (5)"),
    DESAYUNO("desayuno", "08:00 Desayuno"),
    MEDIA_MANANA("media_manana", "10:30 Pre-entreno"),
    ALMUERZO("almuerzo", "14:00 Almuerzo"),
    MEDIA_TARDE("media_tarde", "16:30 Media Tarde"),
    CENA("cena", "19:00 Cena")
}

data class Macros(
    val kcal: Int,
    val prot: Int,
    val carb: Int,
    val fat: Int,
    val fiber: Int
)

data class Meal(
    val id: String,
    val dayIndex: Int,
    val dayName: String,
    val optionLabel: String,
    val slot: MealSlot,
    val time: String,
    val slotLabel: String,
    val medAlert: String?,
    val title: String,
    val shortDesc: String,
    val macros: Macros,
    val ingredients: List<String>,
    val steps: List<String>,
    val clinicalNote: String
)

data class DayPlan(
    val dayIndex: Int,
    val dayName: String,
    val shortName: String,
    val optionLabel: String,
    val focusTag: String,
    val meals: List<Meal>
) {
    val totalKcal: Int get() = meals.sumOf { it.macros.kcal }
    val totalProt: Int get() = meals.sumOf { it.macros.prot }
    val totalCarb: Int get() = meals.sumOf { it.macros.carb }
    val totalFat: Int get() = meals.sumOf { it.macros.fat }
    val totalFiber: Int get() = meals.sumOf { it.macros.fiber }
}

enum class ShopCategory(val code: String, val chipTitle: String, val sectionHeader: String) {
    ALL("all", "Todos (37)", "Todos los Insumos"),
    CARNES_LACTEOS("1", "Carnes y Lácteos (9)", "1. Carnes, Pescados, Huevos y Lácteos"),
    ABARROTES_PAN("2", "Queso, Pan y Abarrotes (10)", "2. Queso, Jamón, Panes y Abarrotes"),
    FRUTAS("3", "Frutas (5)", "3. Frutas Exactas"),
    VERDURAS_TUBERCULOS("4", "Verduras y Tubérculos (13)", "4. Tubérculos y Verduras Individuales")
}

data class ShoppingItem(
    val id: String,
    val orderNumber: Int,
    val category: ShopCategory,
    val name: String,
    val quantity: String,
    val priceSoles: Double,
    val unitPriceRef: String?,
    val usageNote: String
)

enum class BiomarkerTone {
    AMBER,
    ROSE,
    SKY,
    EMERALD
}

data class BiomarkerTarget(
    val label: String,
    val valueText: String,
    val subUnit: String,
    val targetText: String,
    val tone: BiomarkerTone
)

data class ClinicalGoldenRule(
    val title: String,
    val detail: String
)
