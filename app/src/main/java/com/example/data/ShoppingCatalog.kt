package com.example.data

import java.util.Locale

object ShoppingCatalog {
    val items: List<ShoppingItem> = listOf(
        // 1. Carnes, Pescados, Huevos y Lácteos (9 ítems)
        ShoppingItem(
            id = "sh_01",
            orderNumber = 1,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Pechuga Entera de Pollo Fresca Plaza Vea",
            quantity = "1.1 kg",
            priceSoles = 14.85,
            unitPriceRef = "S/ 13.50/kg",
            usageNote = "Para Opciones 1, 2, 5 y 6"
        ),
        ShoppingItem(
            id = "sh_02",
            orderNumber = 2,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Filete de Atún en Agua Bell's Lata 140 g",
            quantity = "6 latas individuales",
            priceSoles = 23.40,
            unitPriceRef = "S/ 3.90 c/u",
            usageNote = "Enjuagar sodio antes de usar"
        ),
        ShoppingItem(
            id = "sh_03",
            orderNumber = 3,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Pavita en Trozos o Rodaja San Fernando",
            quantity = "250 g / 0.25 kg",
            priceSoles = 4.23,
            unitPriceRef = "S/ 16.90/kg",
            usageNote = "Almuerzo Martes (Opción 2)"
        ),
        ShoppingItem(
            id = "sh_04",
            orderNumber = 4,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Filete de Basa o Tilapia Blanca Bell's",
            quantity = "1 bolsa x 1 kg",
            priceSoles = 14.50,
            unitPriceRef = null,
            usageNote = "Almuerzo Miércoles (Opción 3, rinde 5 semanas)"
        ),
        ShoppingItem(
            id = "sh_05",
            orderNumber = 5,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Hígado de Res Fresco Plaza Vea",
            quantity = "200 g / 0.20 kg",
            priceSoles = 2.78,
            unitPriceRef = "S/ 13.90/kg",
            usageNote = "Almuerzo Jueves (Opción 4)"
        ),
        ShoppingItem(
            id = "sh_06",
            orderNumber = 6,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Lomo de Cerdo Sin Piel Magro Ternez",
            quantity = "250 g / 0.25 kg",
            priceSoles = 4.98,
            unitPriceRef = "S/ 19.90/kg",
            usageNote = "Almuerzo Domingo (Opción 7)"
        ),
        ShoppingItem(
            id = "sh_07",
            orderNumber = 7,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Huevos Pardos Bell's",
            quantity = "1 bandeja x 30 unidades",
            priceSoles = 15.80,
            unitPriceRef = null,
            usageNote = "Desayunos Opciones 1, 3 y 6 (rinde 4 semanas)"
        ),
        ShoppingItem(
            id = "sh_08",
            orderNumber = 8,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Leche Evaporada Light Bell's Lata 410 g",
            quantity = "2 latas",
            priceSoles = 8.00,
            unitPriceRef = "S/ 4.00 c/u",
            usageNote = "Desayunos Opciones 1, 2, 4, 5 y 7"
        ),
        ShoppingItem(
            id = "sh_09",
            orderNumber = 9,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Yogurt Gloria Slim Triple Zero 0% Grasa y Azúcar",
            quantity = "1 botella x 1.6 kg",
            priceSoles = 10.90,
            unitPriceRef = null,
            usageNote = "Cena Viernes y Medias Tardes"
        ),

        // 2. Queso, Jamón, Panes y Abarrotes (10 ítems)
        ShoppingItem(
            id = "sh_10",
            orderNumber = 10,
            category = ShopCategory.ABARROTES_PAN,
            name = "Queso Fresco Light Bonlé",
            quantity = "200 g en mostrador",
            priceSoles = 6.98,
            unitPriceRef = "S/ 34.90/kg",
            usageNote = "Desayunos Jueves y Domingo"
        ),
        ShoppingItem(
            id = "sh_11",
            orderNumber = 11,
            category = ShopCategory.ABARROTES_PAN,
            name = "Jamón de Pavita San Fernando",
            quantity = "1 paquete x 100 g",
            priceSoles = 4.40,
            unitPriceRef = null,
            usageNote = "Desayuno Domingo (Opción 7)"
        ),
        ShoppingItem(
            id = "sh_12",
            orderNumber = 12,
            category = ShopCategory.ABARROTES_PAN,
            name = "Pan de Molde Integral Bell's Mediano",
            quantity = "1 bolsa x 500 g",
            priceSoles = 7.50,
            unitPriceRef = null,
            usageNote = "Desayunos Lun, Mar, Jue, Vie y Dom"
        ),
        ShoppingItem(
            id = "sh_13",
            orderNumber = 13,
            category = ShopCategory.ABARROTES_PAN,
            name = "Tortillas Bimbo Rapiditas Integrales",
            quantity = "1 bolsa x 10 unidades",
            priceSoles = 7.90,
            unitPriceRef = null,
            usageNote = "Cena Miércoles (Opción 3)"
        ),
        ShoppingItem(
            id = "sh_14",
            orderNumber = 14,
            category = ShopCategory.ABARROTES_PAN,
            name = "Avena Tradicional Grano de Oro",
            quantity = "1 bolsa x 500 g",
            priceSoles = 4.60,
            unitPriceRef = null,
            usageNote = "Desayunos Mié/Sáb y Granola casera Vie"
        ),
        ShoppingItem(
            id = "sh_15",
            orderNumber = 15,
            category = ShopCategory.ABARROTES_PAN,
            name = "Arroz Integral Bell's",
            quantity = "1 bolsa x 750 g",
            priceSoles = 3.80,
            unitPriceRef = null,
            usageNote = "Almuerzos Lunes y Sábado"
        ),
        ShoppingItem(
            id = "sh_16",
            orderNumber = 16,
            category = ShopCategory.ABARROTES_PAN,
            name = "Lenteja Seca Superior Bell's",
            quantity = "1 bolsa x 500 g",
            priceSoles = 5.80,
            unitPriceRef = null,
            usageNote = "Almuerzo Martes (Opción 2)"
        ),
        ShoppingItem(
            id = "sh_17",
            orderNumber = 17,
            category = ShopCategory.ABARROTES_PAN,
            name = "Fideos Spaghetti o Tornillo Bell's",
            quantity = "1 paquete x 500 g",
            priceSoles = 2.50,
            unitPriceRef = null,
            usageNote = "Almuerzo Domingo (Opción 7)"
        ),
        ShoppingItem(
            id = "sh_18",
            orderNumber = 18,
            category = ShopCategory.ABARROTES_PAN,
            name = "Semillas de Chía Negra Ecoandino",
            quantity = "1 doypack x 200 g",
            priceSoles = 4.99,
            unitPriceRef = null,
            usageNote = "Desayunos Miércoles y Sábado"
        ),
        ShoppingItem(
            id = "sh_19",
            orderNumber = 19,
            category = ShopCategory.ABARROTES_PAN,
            name = "Maní Natural o Frutos Secos Sin Sal Villa Natura",
            quantity = "1 bolsa x 150-200 g",
            priceSoles = 7.50,
            unitPriceRef = null,
            usageNote = "Medias Tardes (20 g)"
        ),

        // 3. Frutas Exactas (5 ítems)
        ShoppingItem(
            id = "sh_20",
            orderNumber = 20,
            category = ShopCategory.FRUTAS,
            name = "Fresa Entera Congelada Bell's / ARO",
            quantity = "1 bolsa x 1 kg",
            priceSoles = 14.30,
            unitPriceRef = null,
            usageNote = "Batidos Lun, Jue y Vie (rinde 3 semanas)"
        ),
        ShoppingItem(
            id = "sh_21",
            orderNumber = 21,
            category = ShopCategory.FRUTAS,
            name = "Arándanos Frescos (Blueberries)",
            quantity = "1 bandeja x 125 g",
            priceSoles = 6.90,
            unitPriceRef = null,
            usageNote = "Avenas de Miércoles y Sábado"
        ),
        ShoppingItem(
            id = "sh_22",
            orderNumber = 22,
            category = ShopCategory.FRUTAS,
            name = "Mandarina W Murcott a Granel",
            quantity = "1.2 kg / ~10 unidades",
            priceSoles = 5.75,
            unitPriceRef = "S/ 4.79/kg",
            usageNote = "Desayunos, Almuerzos y Media Mañana"
        ),
        ShoppingItem(
            id = "sh_23",
            orderNumber = 23,
            category = ShopCategory.FRUTAS,
            name = "Manzana Israel a Granel",
            quantity = "1.0 kg / ~7 unidades",
            priceSoles = 3.99,
            unitPriceRef = "S/ 3.99/kg",
            usageNote = "Avenas, Almuerzos y Media Mañana"
        ),
        ShoppingItem(
            id = "sh_24",
            orderNumber = 24,
            category = ShopCategory.FRUTAS,
            name = "Plátano de Seda",
            quantity = "1 bolsa x 6 unidades",
            priceSoles = 3.70,
            unitPriceRef = null,
            usageNote = "Media porción Miércoles y Sábado"
        ),

        // 4. Tubérculos y Verduras Individuales (13 ítems)
        ShoppingItem(
            id = "sh_25",
            orderNumber = 25,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Papa Blanca Yungay a Granel",
            quantity = "500 g / 0.5 kg",
            priceSoles = 1.25,
            unitPriceRef = "S/ 2.49/kg",
            usageNote = "Cenas Lunes y Jueves (refrigerar cocida 12 h)"
        ),
        ShoppingItem(
            id = "sh_26",
            orderNumber = 26,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Camote Amarillo a Granel",
            quantity = "500 g / 0.5 kg",
            priceSoles = 1.65,
            unitPriceRef = "S/ 3.29/kg",
            usageNote = "Almuerzos Miércoles y Viernes"
        ),
        ShoppingItem(
            id = "sh_27",
            orderNumber = 27,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Choclo Desgranado Bell's",
            quantity = "1 bolsa x 500 g",
            priceSoles = 7.50,
            unitPriceRef = null,
            usageNote = "Cenas Martes/Sábado y Almuerzo Jueves"
        ),
        ShoppingItem(
            id = "sh_28",
            orderNumber = 28,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Palta Hass o Fuerte a Granel",
            quantity = "250 g / 1 unidad mediana",
            priceSoles = 1.87,
            unitPriceRef = "S/ 7.49/kg",
            usageNote = "Cena Domingo (Opción 7)"
        ),
        ShoppingItem(
            id = "sh_29",
            orderNumber = 29,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Pepinillo Fresco a Granel",
            quantity = "1.0 kg",
            priceSoles = 3.49,
            unitPriceRef = "S/ 3.49/kg",
            usageNote = "Base para las 2 tazas de ensalada diaria"
        ),
        ShoppingItem(
            id = "sh_30",
            orderNumber = 30,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Tomate Redondo a Granel",
            quantity = "800 g / 0.8 kg",
            priceSoles = 5.20,
            unitPriceRef = "S/ 6.50/kg",
            usageNote = "Pan con atún, estofado y ensaladas"
        ),
        ShoppingItem(
            id = "sh_31",
            orderNumber = 31,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Col Blanca o Lechuga Entera",
            quantity = "1 unidad grande",
            priceSoles = 3.90,
            unitPriceRef = null,
            usageNote = "Base de volumen para las 2 tazas de ensalada"
        ),
        ShoppingItem(
            id = "sh_32",
            orderNumber = 32,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Apio Entero Fresco",
            quantity = "1 atado entero",
            priceSoles = 4.60,
            unitPriceRef = null,
            usageNote = "Desayuno Viernes (pan con pollo y apio) y ensaladas"
        ),
        ShoppingItem(
            id = "sh_33",
            orderNumber = 33,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Vainita Americana a Granel o Bandeja",
            quantity = "250 g / 0.25 kg",
            priceSoles = 1.98,
            unitPriceRef = "S/ 7.90/kg",
            usageNote = "Arroz a la jardinera y Cena Domingo"
        ),
        ShoppingItem(
            id = "sh_34",
            orderNumber = 34,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Zanahoria Fresca a Granel",
            quantity = "500 g / 0.5 kg",
            priceSoles = 1.70,
            unitPriceRef = "S/ 3.40/kg",
            usageNote = "Estofado, lentejas y ensalada cocida"
        ),
        ShoppingItem(
            id = "sh_35",
            orderNumber = 35,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Cebolla Roja a Granel",
            quantity = "500 g / 0.5 kg",
            priceSoles = 1.99,
            unitPriceRef = "S/ 3.99/kg",
            usageNote = "Hígado encebollado (quercetina) y aderezos"
        ),
        ShoppingItem(
            id = "sh_36",
            orderNumber = 36,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Limón Tahití o Sutil a Granel",
            quantity = "500 g / 0.5 kg",
            priceSoles = 1.90,
            unitPriceRef = "S/ 3.80/kg",
            usageNote = "Aliño alcalinizante anti-ácido úrico"
        ),
        ShoppingItem(
            id = "sh_37",
            orderNumber = 37,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Ajo Entero en Malla",
            quantity = "1 malla x 100-150 g",
            priceSoles = 2.90,
            unitPriceRef = null,
            usageNote = "Aderezos sin aceite para cuidar TGP y presión"
        )
    )

    val totalBudgetSoles: Double = items.sumOf { it.priceSoles }

    fun buildKeepFormattedList(checkedIds: Set<String>): String {
        val sb = StringBuilder()
        sb.appendLine("Compras Semanales Exactas — Plan Lic. Isabel Ríos (Plaza Vea)")
        sb.appendLine("Total lista completa (37 insumos): S/ ${String.format(Locale.US, "%.2f", totalBudgetSoles)}")
        sb.appendLine("------------------------------------------------------------")
        listOf(
            ShopCategory.CARNES_LACTEOS,
            ShopCategory.ABARROTES_PAN,
            ShopCategory.FRUTAS,
            ShopCategory.VERDURAS_TUBERCULOS
        ).forEach { cat ->
            sb.appendLine()
            sb.appendLine(cat.sectionHeader.uppercase())
            items.filter { it.category == cat }.forEach { item ->
                val mark = if (checkedIds.contains(item.id)) "[x]" else "[ ]"
                val unitPart = if (item.unitPriceRef != null) " | ${item.unitPriceRef}" else ""
                sb.appendLine(
                    "$mark ${item.name} — ${item.quantity} (S/ ${String.format(Locale.US, "%.2f", item.priceSoles)}$unitPart) — ${item.usageNote}"
                )
            }
        }
        return sb.toString().trim()
    }
}
