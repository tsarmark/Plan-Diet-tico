package com.example.data

import java.util.Locale

object ShoppingCatalog {

    val portionGuides: List<AgoraPortionGuide> = listOf(
        AgoraPortionGuide(
            doctorRequest = "Pavita 200 g (Almuerzo Martes — Opción 2)",
            agoraProduct = "Carne Molida de Pavita SAN FERNANDO Paquete 500g",
            priceText = "S/ 10.90",
            homeInstruction = "Usas 200 g el martes (en 2 medallones/hamburguesas caseras a la plancha) y congelas 300 g para la semana siguiente (S/ 4.36/sem)."
        ),
        AgoraPortionGuide(
            doctorRequest = "Pollo 200 g (Opciones 1, 2, 5 y 6)",
            agoraProduct = "Filete de Pechuga de Pollo SADIA Bolsa 1Kg",
            priceText = "S/ 14.90",
            homeInstruction = "Viene en filetes individuales listos para porcionar (usas 950–1,000 g exactos entre lunes, martes, viernes y sábado)."
        ),
        AgoraPortionGuide(
            doctorRequest = "Pescado Blanco 200 g (Almuerzo Miércoles — Opción 3)",
            agoraProduct = "Filete de Basa BELL'S Congelado Bolsa 1Kg",
            priceText = "S/ 14.50",
            homeInstruction = "Trae 5 filetes blancos bajos en purinas. Usas 200 g el miércoles y tienes pescado para 5 semanas (S/ 2.90/sem)."
        ),
        AgoraPortionGuide(
            doctorRequest = "Hígado de Res 180 g (Almuerzo Jueves — Opción 4)",
            agoraProduct = "Hígado de Res EL BUEN CORTE x kg (~1 kg)",
            priceText = "S/ 14.50",
            homeInstruction = "Al llegar el pedido, sepáralo en 5 bolsas de 200 g en el congelador. Te dura 5 jueves (S/ 2.90/sem)."
        ),
        AgoraPortionGuide(
            doctorRequest = "Lomo de Cerdo 200 g (Almuerzo Domingo — Opción 7)",
            agoraProduct = "Lomito Saltado de Cerdo REDONDOS Bandeja 620g",
            priceText = "S/ 19.90",
            homeInstruction = "La bandeja de 620 g de lomo magro te rinde 3 domingos exactos de 200 g (S/ 6.63/sem)."
        ),
        AgoraPortionGuide(
            doctorRequest = "Queso Fresco (Opciones 4 y 7)",
            agoraProduct = "Queso Fresco BELL'S Paquete 300g",
            priceText = "S/ 9.90",
            homeInstruction = "Empaque cerrado de 300 g. Usas 70 g por semana (40 g jueves + 30 g domingo); rinde 3 semanas (S/ 3.30/sem)."
        )
    )

    val items: List<ShoppingItem> = listOf(
        // 1. Carnes, Pescados, Huevos y Lácteos (SKUs #1 al #9)
        ShoppingItem(
            id = "sh_01",
            skuLabel = "SKU #1",
            orderNumber = 1,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Filete de Pechuga de Pollo SADIA Bolsa 1Kg (o Pechuga Entera Plaza Vea x kg a S/ 13.50)",
            quantity = "1 Bolsa de 1.0 kg",
            priceSoles = 14.90,
            weeklyCostSoles = 14.90,
            durationNote = "Dura 1 semana (950 g usados)",
            usageNote = "Almuerzo Lunes (200 g + 70 g pan Mar), Cena Martes (150 g), Desayuno Viernes (80 g), Almuerzo y Cena Sábado (350 g)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_02",
            skuLabel = "SKU #2",
            orderNumber = 2,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Carne Molida de Pavita SAN FERNANDO Paquete 500g",
            quantity = "1 Paquete de 500 g (sellado al vacío)",
            priceSoles = 10.90,
            weeklyCostSoles = 4.36,
            durationNote = "Dura 2.5 semanas (usas 200 g el martes)",
            usageNote = "Almuerzo Martes (Opción 2: 2 medallones caseros a la plancha); congelar 300 g restantes",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_03",
            skuLabel = "SKU #3",
            orderNumber = 3,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Filete de Atún en Agua BELL'S Lata 150g (Paquete 4un S/ 18.50 + 2 latas S/ 4.80 c/u)",
            quantity = "1 Paquete x 4 unid + 2 Latas sueltas (6 latas total)",
            priceSoles = 28.10,
            weeklyCostSoles = 28.10,
            durationNote = "Dura 1 semana (6 latas semanales)",
            usageNote = "Lun desayuno (1/2) y cena (1), Mié cena (1), Jue cena (1), Vie almuerzo (1.5) y Dom cena (1). Enjuagar sodio 10 s",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_04",
            skuLabel = "SKU #4",
            orderNumber = 4,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Filete de Basa BELL'S Congelado Bolsa 1Kg (o Basa Refrigerado x kg a S/ 10.50)",
            quantity = "1 Bolsa de 1.0 kg (5 filetes de 200 g)",
            priceSoles = 14.50,
            weeklyCostSoles = 2.90,
            durationNote = "Dura 5 semanas (usas 200 g el miércoles)",
            usageNote = "Almuerzo Miércoles (Opción 3: 200 g al vapor/sudado bajo en purinas)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_05",
            skuLabel = "SKU #5",
            orderNumber = 5,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Hígado de Res EL BUEN CORTE x kg",
            quantity = "1 Unidad en app (= Presentación 1.0 kg aprox.)",
            priceSoles = 14.50,
            weeklyCostSoles = 2.90,
            durationNote = "Dura 5 semanas (dividir en 5 bolsas de 200 g)",
            usageNote = "Almuerzo Jueves (Opción 4: 180 g encebollado descartando caldo de cocción)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_06",
            skuLabel = "SKU #6",
            orderNumber = 6,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Lomito Saltado de Cerdo REDONDOS Empaque 620g (o Chuleta de Lomo 1 kg a S/ 20.90)",
            quantity = "1 Bandeja de 620 g",
            priceSoles = 19.90,
            weeklyCostSoles = 6.63,
            durationNote = "Dura 3 semanas (usas 200 g el domingo)",
            usageNote = "Almuerzo Domingo (Opción 7: 200 g de lomo magro a la plancha)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_07",
            skuLabel = "SKU #7",
            orderNumber = 7,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Huevos Pardos BELL'S Bandeja 30un",
            quantity = "1 Bandeja de 30 unidades",
            priceSoles = 18.90,
            weeklyCostSoles = 4.73,
            durationNote = "Dura 4 semanas (usas 5 a 7 huevos/sem)",
            usageNote = "Desayunos Lunes (1 huevo duro), Miércoles (2 huevos duros) y Sábado (2 huevos duros)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_08",
            skuLabel = "SKU #8",
            orderNumber = 8,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Yogurt GLORIA Slim Triple Zero Botella 1.6Kg (0% grasa, 0% azúcar)",
            quantity = "1 Botella de 1.6 kg",
            priceSoles = 10.90,
            weeklyCostSoles = 8.38,
            durationNote = "Dura 1.3 semanas (cubre tardes + cena viernes)",
            usageNote = "Medias Tardes Lun/Mié/Sáb (180 ml), Cena Viernes (250 ml) y aderezo de pan con pollo Mar/Vie",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_09",
            skuLabel = "SKU #9",
            orderNumber = 9,
            category = ShopCategory.CARNES_LACTEOS,
            name = "Leche Light GLORIA Lata 390g (o Leche Evaporada Light BELL'S Lata 410g)",
            quantity = "1 Lata (390 g – 410 g; rinde los 5 desayunos diluidos)",
            priceSoles = 4.20,
            weeklyCostSoles = 4.20,
            durationNote = "Dura 1 semana (300 ml usados en total)",
            usageNote = "Desayunos Lun, Mar, Jue, Vie y Dom (60 ml + 180 ml de agua por toma)",
            isWeeklyReplenishment = true
        ),

        // 2. Queso, Jamón, Panes y Abarrotes (SKUs #10 al #19)
        ShoppingItem(
            id = "sh_10",
            skuLabel = "SKU #10",
            orderNumber = 10,
            category = ShopCategory.ABARROTES_PAN,
            name = "Queso Fresco BELL'S Paquete 300g (o Queso Fresco Light BELL'S a S/ 10.50)",
            quantity = "1 Paquete cerrado de 300 g",
            priceSoles = 9.90,
            weeklyCostSoles = 3.30,
            durationNote = "Dura 3 semanas (usas 70 g/sem: jue y dom)",
            usageNote = "Desayuno Jueves (40 g) y Desayuno Domingo (30 g) — pasar 10 s por agua fría",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_11",
            skuLabel = "SKU #11",
            orderNumber = 11,
            category = ShopCategory.ABARROTES_PAN,
            name = "Jamón de Pavita SAN FERNANDO Paquete 100g",
            quantity = "1 Paquete cerrado de 100 g",
            priceSoles = 5.50,
            weeklyCostSoles = 1.83,
            durationNote = "Dura 3 semanas (usas 1 a 2 láminas el domingo)",
            usageNote = "Desayuno Domingo (Opción 7: 1 lámina de 20 g dorada en sartén seca)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_12",
            skuLabel = "SKU #12",
            orderNumber = 12,
            category = ShopCategory.ABARROTES_PAN,
            name = "Pan de Molde Integral BELL'S Mediano Bolsa 500g",
            quantity = "1 Bolsa de 500 g (~20 rebanadas)",
            priceSoles = 7.50,
            weeklyCostSoles = 3.75,
            durationNote = "Dura 2 semanas (usas 10 rebanadas/sem)",
            usageNote = "Desayunos Lunes, Martes, Jueves, Viernes y Domingo (2 rebanadas tostadas)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_13",
            skuLabel = "SKU #13",
            orderNumber = 13,
            category = ShopCategory.ABARROTES_PAN,
            name = "Tortillas BIMBO Rapiditas Integrales Bolsa 10un",
            quantity = "1 Bolsa (congelar las 9 restantes)",
            priceSoles = 7.90,
            weeklyCostSoles = 0.79,
            durationNote = "Dura 10 semanas (usas 1 unidad el miércoles)",
            usageNote = "Cena Miércoles (Opción 3: 1 tortilla integral con atún y ensalada)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_14",
            skuLabel = "SKU #14",
            orderNumber = 14,
            category = ShopCategory.ABARROTES_PAN,
            name = "Avena GRANO DE ORO Bolsa 500g (o Avena 3 Ositos 540g)",
            quantity = "1 Bolsa de 500 g",
            priceSoles = 4.60,
            weeklyCostSoles = 1.15,
            durationNote = "Dura 4 semanas (usas 105 g/sem: mié, vie, sáb)",
            usageNote = "Porridge Miércoles y Sábado (40 g c/u) + Granola casera Viernes (25 g)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_15",
            skuLabel = "SKU #15",
            orderNumber = 15,
            category = ShopCategory.ABARROTES_PAN,
            name = "Arroz Integral BELL'S Bolsa 750g",
            quantity = "1 Bolsa de 750 g",
            priceSoles = 3.80,
            weeklyCostSoles = 0.54,
            durationNote = "Dura 7 semanas (usas 105 g en crudo/sem)",
            usageNote = "Almuerzo Lunes (55 g crudo) y Almuerzo Sábado a la jardinera (50 g crudo)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_16",
            skuLabel = "SKU #16",
            orderNumber = 16,
            category = ShopCategory.ABARROTES_PAN,
            name = "Lenteja Superior BELL'S Bolsa 500g",
            quantity = "1 Bolsa de 500 g",
            priceSoles = 5.80,
            weeklyCostSoles = 0.83,
            durationNote = "Dura 7 semanas (usas 65 g en crudo el martes)",
            usageNote = "Almuerzo Martes (Opción 2: remojar 12 h antes y desechar agua de remojo)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_17",
            skuLabel = "SKU #17",
            orderNumber = 17,
            category = ShopCategory.ABARROTES_PAN,
            name = "Spaghetti o Tornillo BELL'S Paquete 500g",
            quantity = "1 Paquete de 500 g",
            priceSoles = 2.50,
            weeklyCostSoles = 0.28,
            durationNote = "Dura 9 semanas (usas 55 g en crudo el domingo)",
            usageNote = "Almuerzo Domingo (Opción 7: hervir estrictamente 8 min al dente)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_18",
            skuLabel = "SKU #18",
            orderNumber = 18,
            category = ShopCategory.ABARROTES_PAN,
            name = "Chía Negra ECOANDINO Doypack 200g",
            quantity = "1 Doypack de 200 g",
            priceSoles = 4.99,
            weeklyCostSoles = 0.62,
            durationNote = "Dura 8 semanas (usas 25 g/sem)",
            usageNote = "Desayunos Miércoles y Sábado (10 g c/u) + Granola casera Viernes (5 g)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_19",
            skuLabel = "SKU #19",
            orderNumber = 19,
            category = ShopCategory.ABARROTES_PAN,
            name = "Maní Tostado Sin Sal VILLA NATURA Bolsa 200g",
            quantity = "1 Bolsa de 200 g",
            priceSoles = 7.50,
            weeklyCostSoles = 3.40,
            durationNote = "Dura 2.2 semanas (usas 90 g/sem)",
            usageNote = "Medias Tardes Mar, Jue, Vie y Dom (20 g) + Granola casera Viernes (10 g)",
            isWeeklyReplenishment = false
        ),

        // 3. Frutas en Agora (SKUs #20 al #24)
        ShoppingItem(
            id = "sh_20",
            skuLabel = "SKU #20",
            orderNumber = 20,
            category = ShopCategory.FRUTAS,
            name = "Fresa Entera Congelada BELL'S Bolsa 1kg",
            quantity = "1 Bolsa de 1.0 kg",
            priceSoles = 14.50,
            weeklyCostSoles = 4.35,
            durationNote = "Dura 3.3 semanas (usas 300 g/sem en batidos)",
            usageNote = "Batidos de desayuno Lunes, Jueves y Viernes (100 g por batido)",
            isWeeklyReplenishment = false
        ),
        ShoppingItem(
            id = "sh_21",
            skuLabel = "SKU #21",
            orderNumber = 21,
            category = ShopCategory.FRUTAS,
            name = "Blueberries (Arándanos) BELL'S FRESCOS Bandeja 125g",
            quantity = "1 Bandeja de 125 g",
            priceSoles = 6.90,
            weeklyCostSoles = 4.60,
            durationNote = "Dura 1.5 semanas (usas 90 g/sem)",
            usageNote = "Desayunos Miércoles y Sábado (30 g) + Postre Almuerzo Domingo (30 g)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_22",
            skuLabel = "SKU #22",
            orderNumber = 22,
            category = ShopCategory.FRUTAS,
            name = "Mandarina W MURCOTT x kg (S/ 4.79/kg)",
            quantity = "Seleccionar 1.2 kg (~10 unidades)",
            priceSoles = 5.75,
            weeklyCostSoles = 5.75,
            durationNote = "Dura 1 semana completa",
            usageNote = "Desayunos Mar/Jue/Dom, Pre-entreno Mié/Vie/Sáb y Almuerzos Lun/Mar/Jue",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_23",
            skuLabel = "SKU #23",
            orderNumber = 23,
            category = ShopCategory.FRUTAS,
            name = "Manzana Israel x kg (S/ 3.99/kg)",
            quantity = "Seleccionar 1.0 kg (~7 unidades)",
            priceSoles = 3.99,
            weeklyCostSoles = 3.99,
            durationNote = "Dura 1 semana completa",
            usageNote = "Pre-entreno Lun/Jue/Dom, Avenas Mié/Sáb y Postre Almuerzos Mié/Vie/Sáb",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_24",
            skuLabel = "SKU #24",
            orderNumber = 24,
            category = ShopCategory.FRUTAS,
            name = "Plátano de Seda Bolsa 6un (o x kg a S/ 3.89/kg)",
            quantity = "1 Bolsa de 6 unidades (o 3 unid = 0.75 kg)",
            priceSoles = 3.70,
            weeklyCostSoles = 1.85,
            durationNote = "Dura 2 semanas (usas 1.5 plátanos/sem)",
            usageNote = "Pre-entreno Martes (1/2 unid) y Avenas Miércoles y Sábado (1/2 unid c/u)",
            isWeeklyReplenishment = false
        ),

        // 4. Tubérculos y Verduras Frescas en Agora (SKUs #25 al #28 desglosados individualmente)
        ShoppingItem(
            id = "sh_25",
            skuLabel = "SKU #25",
            orderNumber = 25,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Choclo Desgranado BELL'S Bolsa 500g",
            quantity = "1 Bolsa de 500 g",
            priceSoles = 7.90,
            weeklyCostSoles = 5.64,
            durationNote = "Dura 1.4 semanas (usas 360 g/sem)",
            usageNote = "Cena Martes (120 g), Almuerzo Jueves (140 g), Almuerzo y Cena Sábado (120 g)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_26a",
            skuLabel = "SKU #26A",
            orderNumber = 26,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Papa Blanca Yungay x kg (S/ 2.59/kg)",
            quantity = "Seleccionar 1 Und. en app (0.4 kg)",
            priceSoles = 1.04,
            weeklyCostSoles = 1.04,
            durationNote = "Dura 1 semana completa",
            usageNote = "Cena Lunes (150 g) y Cena Jueves (130 g) — sancochar y refrigerar 12 h antes",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_26b",
            skuLabel = "SKU #26B",
            orderNumber = 27,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Camote Amarillo Procesado x kg (S/ 3.29/kg)",
            quantity = "Seleccionar 1 Und. en app (0.5 kg)",
            priceSoles = 1.65,
            weeklyCostSoles = 1.65,
            durationNote = "Dura 1 semana completa",
            usageNote = "Almuerzo Miércoles (160 g) y Almuerzo Viernes al horno (160 g)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_27a",
            skuLabel = "SKU #27A",
            orderNumber = 28,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Lechuga Americana x und (S/ 2.59 c/u)",
            quantity = "2 unidades en Agora",
            priceSoles = 5.18,
            weeklyCostSoles = 5.18,
            durationNote = "Dura 1 semana (base de las 14 tazas de ensalada)",
            usageNote = "Base crujiente obligatoria de las 2 tazas de ensalada de almuerzo y cenas",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_27b",
            skuLabel = "SKU #27B",
            orderNumber = 29,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Pepinillo Fresco x kg (S/ 3.49/kg)",
            quantity = "Seleccionar 2 unid en app (= 1.0 kg)",
            priceSoles = 3.49,
            weeklyCostSoles = 3.49,
            durationNote = "Dura 1 semana completa",
            usageNote = "Volumen hidratante y potasio para las 2 tazas diarias de ensalada",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_27c",
            skuLabel = "SKU #27C",
            orderNumber = 30,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Tomate Redondo x kg (S/ 6.50/kg)",
            quantity = "Seleccionar 3 unid en app (= 0.75 kg)",
            priceSoles = 4.88,
            weeklyCostSoles = 4.88,
            durationNote = "Dura 1 semana completa",
            usageNote = "Pan con atún, sudado de basa, hígado encebollado, estofado y ensaladas",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_28a",
            skuLabel = "SKU #28A",
            orderNumber = 31,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Vainita Americana Pack x 250g",
            quantity = "1 Pack de 250 g",
            priceSoles = 2.22,
            weeklyCostSoles = 2.22,
            durationNote = "Dura 1 semana completa",
            usageNote = "Ensaladas Mié/Jue/Dom, Arroz a la jardinera Sáb y Cena Domingo al vapor (6 min)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_28b",
            skuLabel = "SKU #28B",
            orderNumber = 32,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Zanahoria Fresca x kg (S/ 4.40/kg)",
            quantity = "Seleccionar 1 unid en app (= 0.3 kg)",
            priceSoles = 1.32,
            weeklyCostSoles = 1.32,
            durationNote = "Dura 1 semana completa",
            usageNote = "Lentejas Mar, Ensalada Jue, Estofado Sáb y Cena Domingo al vapor (6 min)",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_28c",
            skuLabel = "SKU #28C",
            orderNumber = 33,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Cebolla Roja x kg (S/ 3.98/kg)",
            quantity = "Seleccionar 0.5 kg en Agora",
            priceSoles = 1.99,
            weeklyCostSoles = 1.99,
            durationNote = "Dura 1 semana completa",
            usageNote = "Rica en quercetina anti-ácido úrico: Hígado encebollado Jueves, atún y aderezos",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_28d",
            skuLabel = "SKU #28D",
            orderNumber = 34,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Limón Tahití x kg (S/ 3.80/kg)",
            quantity = "Seleccionar 0.3 kg en Agora",
            priceSoles = 1.14,
            weeklyCostSoles = 1.14,
            durationNote = "Dura 1 semana completa",
            usageNote = "Citrato alcalinizante diario para ensaladas, atún y agua con limón del jueves",
            isWeeklyReplenishment = true
        ),
        ShoppingItem(
            id = "sh_28e",
            skuLabel = "SKU #28E",
            orderNumber = 35,
            category = ShopCategory.VERDURAS_TUBERCULOS,
            name = "Palta Hass o Fuerte x und",
            quantity = "1 unidad mediana (~250 g)",
            priceSoles = 1.87,
            weeklyCostSoles = 1.87,
            durationNote = "Dura 1 semana",
            usageNote = "Cena Domingo (Opción 7: 1/4 de unidad = 60 g en láminas)",
            isWeeklyReplenishment = true
        )
    )

    // Totales exactos auditados en el PDF (Página 10):
    // Semana 1 (Compra inicial con despensa y bolsas de 1 kg): S/ 264.31
    // Semanas 2, 3 y 4 (Reposición semanal de frescos): S/ 88.60
    // Promedio Neto Semanal Consumido: S/ 116.45
    val totalBudgetSoles: Double = items.sumOf { it.priceSoles } // 264.31
    val weeklyReplenishmentSoles: Double = 88.60
    val netWeeklyConsumedSoles: Double = 116.45

    fun buildKeepFormattedList(checkedIds: Set<String>): String {
        val sb = StringBuilder()
        sb.appendLine("🛒 LISTA DE COMPRAS REAL EN PLAZA VEA VÍA AGORA — PLAN LIC. ISABEL RÍOS")
        sb.appendLine("💰 Semana 1 (Carrito completo): S/ ${String.format(Locale.US, "%.2f", totalBudgetSoles)} | Semanas 2–4 (Reposición): S/ 88.60/sem | Costo Real Consumido: S/ 116.45/sem")
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
                sb.appendLine(
                    "$mark ${item.skuLabel} • ${item.name} — ${item.quantity} | Caja: S/ ${String.format(Locale.US, "%.2f", item.priceSoles)} (Costo real: S/ ${String.format(Locale.US, "%.2f", item.weeklyCostSoles)}/sem) | ${item.usageNote}"
                )
            }
        }
        return sb.toString().trim()
    }
}
