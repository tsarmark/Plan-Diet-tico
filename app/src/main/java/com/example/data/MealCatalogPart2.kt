package com.example.data

object ClinicalCatalog {
    private val daysViernesToDomingo: List<DayPlan> = listOf(
        DayPlan(
            dayIndex = 4,
            dayName = "Viernes",
            shortName = "Vie",
            optionLabel = "Opción 5 de la Doctora",
            focusTag = "Granola Casera Sin Azúcar y Ahorro",
            nightPrepReminder = "Para mañana Sábado: Deja cocidos 50 g en crudo de Arroz Integral BELL'S a la jardinera (con vainita, zanahoria y choclo) y sepáralo en refrigeración para el almuerzo del sábado.",
            meals = listOf(
                Meal(
                    id = "vie_desayuno",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "Jugo de fresas con leche light con stevia + 1 Pan con pollo y apio",
                    shortDesc = "Sándwich en Pan Integral BELL'S con 80 g de Pechuga SADIA deshilachada, apio y Yogurt Slim 0% + licuado de 100 g fresa con leche light.",
                    macros = Macros(kcal = 415, prot = 34, carb = 47, fat = 8, fiber = 7),
                    ingredients = listOf(
                        "80 g de Filete de Pechuga SADIA deshilachada",
                        "1 tallo grande (35 g) de Apio picado fino + 1 cda de Yogurt Gloria Slim 0%, limón y pimienta",
                        "2 rebanadas de Pan Integral BELL'S tostado",
                        "Licuado: 100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia"
                    ),
                    steps = listOf(
                        "Mezcla 80 g de Filete de Pechuga SADIA deshilachada con 1 tallo grande (35 g) de Apio picado fino, 1 cda de Yogurt Gloria Slim 0%, limón y pimienta en 2 rebanadas de Pan Integral BELL'S.",
                        "Come primero el sándwich y acompaña al final con el licuado de 100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia.",
                        "Toma tu Irbesartán 150 mg al terminar."
                    ),
                    clinicalNote = "Los ftálidos naturales del apio relajan el endotelio vascular actuando en sinergia con tu Irbesartán 150 mg.",
                    timers = listOf(
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "vie_mm",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM",
                    title = "1 Mandarina W Murcott mediana (100 g)",
                    shortDesc = "Antioxidantes cítricos e hidratación antes del entrenamiento.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 Mandarina W Murcott mediana (100 g)"
                    ),
                    steps = listOf(
                        "Consumir en gajos enteros a las 10:30 AM antes de entrenar."
                    ),
                    clinicalNote = "La vitamina C favorece la excreción tubular de ácido úrico."
                ),
                Meal(
                    id = "vie_almuerzo",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
                    title = "Zarza de Atún al Limón (1.5 latas) + 1 Camote al Horno + 2 Tazas de Ensalada + 1 Manzana",
                    shortDesc = "1.5 latas de Filete de Atún en Agua BELL'S desalado (1 nueva + 1/2 del lunes) + 160 g camote al horno/sartén + 2 tazas de ensalada.",
                    macros = Macros(kcal = 530, prot = 46, carb = 68, fat = 5, fiber = 10),
                    ingredients = listOf(
                        "1.5 latas (150–180 g escurridos = 1 lata nueva + la 1/2 lata guardada del lunes) de Filete de Atún en Agua BELL'S desalado en colador",
                        "160 g de Camote Amarillo en rodajas horneado o dorado en sartén seca con canela/orégano",
                        "Ensalada (2 tazas): 100 g de lechuga americana, 60 g de tomate, 40 g de cebolla roja lavada, 30 g de apio picado, 50 g de pepinillo y jugo de 1 limón",
                        "Postre: 1 Manzana Israel (120 g)"
                    ),
                    steps = listOf(
                        "Enjuaga en colador durante 10 segundos las 1.5 latas de Filete de Atún en Agua BELL'S para retirar el sodio.",
                        "Hornea o dora en sartén antiadherente seca con tapa los 160 g de Camote Amarillo en rodajas con canela u orégano.",
                        "Come 1° las 2 tazas de ensalada fresca con la zarza de atún al limón y apio, y 2° el camote dorado y la manzana. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Aprovechar la media lata guardada del lunes entrega 46 g de proteína limpia en el almuerzo post-entreno con cero desperdicio.",
                    timers = listOf(
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "vie_mt",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
                    shortDesc = "Aporte de fitoesteroles y grasas monoinsaturadas sin sal.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
                    ),
                    steps = listOf(
                        "Consumir 20 g pesados en balanza a las 16:30 con agua."
                    ),
                    clinicalNote = "Mantiene estable la saciedad vespertina y reduce el colesterol LDL."
                ),
                Meal(
                    id = "vie_cena",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00",
                    title = "1 Vaso de Yogurt 0% + Granola Casera \"Sin Azúcar\"",
                    shortDesc = "250 ml de Yogurt GLORIA Slim Triple Zero 0% con 25 g avena + 5 g chía + 10 g maní sin sal tostados 4 min en sartén seca con canela.",
                    macros = Macros(kcal = 295, prot = 18, carb = 31, fat = 9, fiber = 6),
                    ingredients = listOf(
                        "250 ml de Yogurt GLORIA Slim Triple Zero 0%",
                        "Granola Casera: 25 g (3 cdas) de tu Avena GRANO DE ORO + 5 g de Chía ECOANDINO + 10 g de tu Maní sin sal VILLA NATURA picado + canela y 2 gotas de stevia"
                    ),
                    steps = listOf(
                        "En lugar de gastar S/ 14.20 en granola comercial con maltitol, tuesta en sartén seca por 4 minutos 25 g (3 cdas) de tu Avena + 5 g de Chía + 10 g de tu Maní sin sal picado con canela y 2 gotas de stevia.",
                        "Deja enfriar 2 minutos para que quede crujiente y sírvela sobre 250 ml de Yogurt GLORIA Slim Triple Zero 0%."
                    ),
                    clinicalNote = "Ahorras S/ 14.20 evitando maltitol y aceites refinados de las granolas comerciales mientras sumas fibra soluble y Omega-3.",
                    timers = listOf(
                        RecipeTimerSpec("Tostado granola en sartén (4 min)", 4 * 60)
                    )
                )
            )
        ),
        DayPlan(
            dayIndex = 5,
            dayName = "Sábado",
            shortName = "Sáb",
            optionLabel = "Opción 6 de la Doctora",
            focusTag = "Estofado Peruano sin Aceite",
            nightPrepReminder = "Para mañana Domingo: Pasa 200 g de Lomito Saltado de Cerdo REDONDOS del congelador al refrigerador para el almuerzo dominical.",
            meals = listOf(
                Meal(
                    id = "sab_desayuno",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "1 Taza de avena con canela + 1/2 manzana, 1/2 plátano, 30 g arándanos, 1 cda chía + 2 huevos duros",
                    shortDesc = "Come primero los 2 Huevos Pardos BELL'S duros y luego el porridge de 40 g Avena + 10 g Chía + manzana, plátano y 30 g arándanos.",
                    macros = Macros(kcal = 485, prot = 21, carb = 58, fat = 18, fiber = 11),
                    ingredients = listOf(
                        "2 Huevos Pardos BELL'S duros (comer primero)",
                        "40 g de Avena GRANO DE ORO + 10 g de Chía Negra ECOANDINO",
                        "1/2 Manzana Israel (65 g) + 1/2 Plátano de seda (55 g) + 30 g de Blueberries BELL'S FRESCOS"
                    ),
                    steps = listOf(
                        "Come primero los 2 Huevos Pardos BELL'S duros.",
                        "Luego consume el porridge hervido 4 min de 40 g de Avena + 10 g de Chía + 1/2 manzana + 1/2 plátano + 30 g de arándanos.",
                        "Toma tu Irbesartán 150 mg al terminar."
                    ),
                    clinicalNote = "Segunda carga semanal de colina (2 yemas) y betaglucanos para acelerar la limpieza de grasa hepática (TGP 49.9 U/L).",
                    timers = listOf(
                        RecipeTimerSpec("Hervor avena (4 min)", 4 * 60),
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "sab_mm",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM",
                    title = "1 Mandarina W Murcott mediana (100 g)",
                    shortDesc = "Hidratación y flavonoides cítricos pre-entreno.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 Mandarina W Murcott mediana (100 g)"
                    ),
                    steps = listOf(
                        "Consumir en gajos enteros a las 10:30 AM antes de entrenar."
                    ),
                    clinicalNote = "Aporta vitamina C e hidratación celular."
                ),
                Meal(
                    id = "sab_almuerzo",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
                    title = "Estofado de Pollo sin Aceite (200 g) + 1 Taza de Arroz a la Jardinera + 2 Tazas de Ensalada + 1 Manzana",
                    shortDesc = "200 g Filete de Pechuga SADIA en salsa natural de tomate, cebolla, zanahoria y laurel + arroz integral a la jardinera + ensalada.",
                    macros = Macros(kcal = 560, prot = 53, carb = 66, fat = 7, fiber = 10),
                    ingredients = listOf(
                        "200 g de Filete de Pechuga SADIA en trozos",
                        "Salsa natural: 60 g de tomate licuado, 40 g de cebolla picada, 1 diente de ajo, 30 g de zanahoria en rodajas, laurel, páprika y orégano",
                        "Arroz a la jardinera (1 taza): 50 g en crudo de Arroz Integral BELL'S cocido con 30 g de vainitas picadas, 20 g de zanahoria en cubitos y 20 g de choclo desgranado",
                        "Ensalada (2 tazas): 120 g de lechuga americana + 80 g de pepinillo al limón",
                        "Postre: 1 Manzana Israel (110 g)"
                    ),
                    steps = listOf(
                        "Sella en olla antiadherente sin aceite los 200 g de Filete de Pechuga SADIA en trozos con ajo, páprika y orégano; añade el tomate licuado, cebolla, zanahoria en rodajas, laurel y 1/2 taza de agua cocinando tapado por 20 min.",
                        "Come 1° las 2 tazas de ensalada de lechuga y pepinillo al limón, 2° el estofado de pollo y 3° la taza de arroz integral a la jardinera y la manzana.",
                        "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
                    ),
                    clinicalNote = "El licopeno del tomate cocido sin aceites refinados evita la oxidación del colesterol LDL.",
                    timers = listOf(
                        RecipeTimerSpec("Estofado a fuego lento (20 min)", 20 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "sab_mt",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%",
                    shortDesc = "Colación proteica 0% grasa y 0% azúcar.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%"
                    ),
                    steps = listOf(
                        "Servir frío a las 16:30."
                    ),
                    clinicalNote = "Sostiene la saciedad de la tarde y ayuda a depurar ácido úrico."
                ),
                Meal(
                    id = "sab_cena",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00",
                    title = "Ensalada de tomate + Pollo en cuadritos (150 g) + Choclo",
                    shortDesc = "150 g de Pechuga de Pollo SADIA salteada en cuadritos con ajo y orégano + 150 g tomate en gajos con cebolla + 3/4 taza de Choclo BELL'S.",
                    macros = Macros(kcal = 320, prot = 37, carb = 28, fat = 5, fiber = 4),
                    ingredients = listOf(
                        "150 g de Pechuga de Pollo SADIA en cuadritos",
                        "150 g de Tomate en gajos con cebolla y limón",
                        "3/4 taza (100 g) de Choclo Desgranado BELL'S sancochado",
                        "Ajo, orégano, gotas de limón y 1 cda de agua"
                    ),
                    steps = listOf(
                        "Saltea 150 g de Pechuga de Pollo SADIA en cuadritos en sartén antiadherente con ajo, orégano, gotas de limón y 1 cda de agua por 6 minutos.",
                        "Acompaña con 150 g de tomate en gajos con cebolla y limón + 3/4 taza (100 g) de Choclo Desgranado BELL'S sancochado."
                    ),
                    clinicalNote = "Cena ligera que facilita un descanso profundo y repara el tejido muscular."
                )
            )
        ),
        DayPlan(
            dayIndex = 6,
            dayName = "Domingo",
            shortName = "Dom",
            optionLabel = "Opción 7 de la Doctora",
            focusTag = "Lomo de Cerdo Magro y Pasta Al Dente",
            nightPrepReminder = "Para mañana Lunes: Deja sancochada y refrigerando 12 h 1 Papa Blanca Yungay mediana (150 g) para la cena del lunes y 55 g en crudo de Arroz Integral BELL'S para el almuerzo del lunes.",
            meals = listOf(
                Meal(
                    id = "dom_desayuno",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "1 Taza de leche + 1 Pan con queso fresco y jamón de pavita + 2 mandarinas",
                    shortDesc = "Sándwich en Pan Integral BELL'S con 30 g Queso Fresco BELL'S desalado y 1 lámina de Jamón de Pavita SAN FERNANDO + leche tibia + 2 mandarinas.",
                    macros = Macros(kcal = 420, prot = 25, carb = 56, fat = 8, fiber = 6),
                    ingredients = listOf(
                        "2 rebanadas de Pan Integral BELL'S tostado",
                        "30 g de Queso Fresco BELL'S (pasado por agua) + 1 lámina (20 g) de Jamón de Pavita SAN FERNANDO (Paquete 100g) dorada en sartén seca",
                        "1 taza de leche tibia (60 ml Leche Light GLORIA + 180 ml agua con canela)",
                        "2 Mandarinas W Murcott en gajos (180 g)"
                    ),
                    steps = listOf(
                        "Arma tu sándwich en 2 rebanadas de Pan Integral BELL'S con 30 g de Queso Fresco BELL'S (pasado por agua) y 1 lámina (20 g) de Jamón de Pavita SAN FERNANDO (Paquete 100g) dorada en sartén seca.",
                        "Acompaña con 1 taza de leche tibia (60 ml Leche Light + 180 ml agua con canela) y termina con 2 Mandarinas en gajos.",
                        "Toma tu Irbesartán 150 mg al terminar."
                    ),
                    clinicalNote = "Desalar el queso fresco por 10 segundos mantiene controlado el sodio matutino en sinergia con el Irbesartán.",
                    timers = listOf(
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "dom_mm",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Sesión de movilidad o entrenamiento en 2x2 m (11:00 AM)",
                    title = "1 Manzana Israel pequeña (110 g) con cáscara",
                    shortDesc = "Pectina soluble para moderar el apetito antes del almuerzo dominical.",
                    macros = Macros(kcal = 60, prot = 0, carb = 15, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 Manzana Israel pequeña (110 g) con cáscara"
                    ),
                    steps = listOf(
                        "Lavar y comer entera con cáscara a las 10:30 AM."
                    ),
                    clinicalNote = "Prepara la microbiota intestinal y aporta saciedad previa al almuerzo."
                ),
                Meal(
                    id = "dom_almuerzo",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 15 min caminata suave",
                    title = "Lomo de Cerdo Magro (200 g) + 1 Taza de Fideos Al Dente + 2 Tazas de Ensalada + Arándanos",
                    shortDesc = "200 g Lomito Saltado de Cerdo REDONDOS limpio de grasa + 1 taza de Spaghetti/Tornillo BELL'S (8 min al dente) en salsa casera + 30 g arándanos.",
                    macros = Macros(kcal = 575, prot = 51, carb = 62, fat = 11, fiber = 8),
                    ingredients = listOf(
                        "200 g de Lomito Saltado de Cerdo REDONDOS (Bandeja 620g) limpio de grasa visible",
                        "55 g en crudo de Spaghetti o Tornillo BELL'S (hervido estrictamente 8 minutos al dente = 1 taza / 140 g cocido)",
                        "Salsa casera: 70 g de tomate picado, 40 g de cebolla, ajo y orégano",
                        "Ensalada (2 tazas obligatorias antes de la pasta): 100 g de lechuga americana, 60 g de vainitas al vapor, 60 g de pepinillo y limón",
                        "Postre: 30 g de Blueberries BELL'S FRESCOS"
                    ),
                    steps = listOf(
                        "REGLA DE ORO: Hierve los 55 g en crudo de Spaghetti o Tornillo BELL'S durante estrictamente 8 MINUTOS al dente (equivale a 1 taza / 140 g cocido).",
                        "Dora en sartén antiadherente sin aceite los 200 g de Lomito Saltado de Cerdo REDONDOS sazonado con ajo y orégano, y prepara la salsa casera con 70 g de tomate picado, 40 g de cebolla, ajo y orégano.",
                        "ORDEN ESTRICTO: Come 1° las 2 tazas obligatorias de ensalada, 2° los 200 g de lomo de cerdo y 3° la taza de fideos al dente y los 30 g de arándanos. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "El lomo de cerdo magro aporta tiamina (Vitamina B1) para oxidar los carbohidratos de la pasta al dente sin elevar los triglicéridos hepáticos.",
                    timers = listOf(
                        RecipeTimerSpec("Fideos Al Dente (8 min exactos)", 8 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (15 min)", 15 * 60)
                    )
                ),
                Meal(
                    id = "dom_mt",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
                    shortDesc = "Grasas monoinsaturadas y saciedad de domingo por la tarde.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
                    ),
                    steps = listOf(
                        "Consumir 20 g pesados en balanza a las 16:30 con agua."
                    ),
                    clinicalNote = "Completa el aporte semanal de ácido oleico cardioprotector."
                ),
                Meal(
                    id = "dom_cena",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de semana nutricional a las 19:00",
                    title = "Ensalada cocida al dente + 1 Lata de Atún + Palta",
                    shortDesc = "100 g de Vainita Americana y 80 g de Zanahoria en bastones al vapor por solo 6 min + 1 lata de Atún BELL'S desalada + 60 g de Palta Fuerte.",
                    macros = Macros(kcal = 310, prot = 31, carb = 16, fat = 13, fiber = 7),
                    ingredients = listOf(
                        "100 g de Vainita Americana + 80 g de Zanahoria en bastones (al vapor por solo 6 minutos al dente)",
                        "1 lata de Filete de Atún en Agua BELL'S desalada en colador",
                        "1/4 de unidad (60 g) de Palta Fuerte o Hass en láminas con limón"
                    ),
                    steps = listOf(
                        "Cocina al vapor por solo 6 minutos (al dente) 100 g de Vainita Americana y 80 g de Zanahoria en bastones.",
                        "Sirve encima 1 lata de Filete de Atún en Agua BELL'S desalada y 1/4 de unidad (60 g) de Palta Fuerte en láminas con limón."
                    ),
                    clinicalNote = "Cena muy baja en carbohidratos netos (9 g) para amanecer el lunes con la insulina basal en su nivel más bajo.",
                    timers = listOf(
                        RecipeTimerSpec("Verduras al vapor Al Dente (6 min)", 6 * 60)
                    )
                )
            )
        )
    )

    val days: List<DayPlan> = MealCatalogPart1.daysLunesToJueves + daysViernesToDomingo

    val allMealsFlat: List<Meal> = days.flatMap { it.meals }

    val biomarkers: List<BiomarkerTarget> = listOf(
        BiomarkerTarget(
            id = "insulina",
            label = "Insulina Basal",
            defaultValueText = "39.0",
            subUnit = "μU/mL",
            targetText = "Meta: < 9.0 μU/mL",
            tone = BiomarkerTone.AMBER
        ),
        BiomarkerTarget(
            id = "homa",
            label = "Índice HOMA-IR",
            defaultValueText = "9.73",
            subUnit = "Gluc: 101",
            targetText = "Meta: < 1.8",
            tone = BiomarkerTone.AMBER
        ),
        BiomarkerTarget(
            id = "tgp",
            label = "Hígado TGP (ALT)",
            defaultValueText = "49.9",
            subUnit = "U/L",
            targetText = "Meta: < 30 U/L",
            tone = BiomarkerTone.ROSE
        ),
        BiomarkerTarget(
            id = "urico",
            label = "Ácido Úrico",
            defaultValueText = "6.65",
            subUnit = "mg/dL",
            targetText = "Meta: < 5.5 mg/dL",
            tone = BiomarkerTone.ROSE
        ),
        BiomarkerTarget(
            id = "lipidos",
            label = "Colesterol LDL / HDL",
            defaultValueText = "124 / 45.4",
            subUnit = "mg/dL",
            targetText = "Meta: LDL <100 | HDL >50",
            tone = BiomarkerTone.SKY
        ),
        BiomarkerTarget(
            id = "renal",
            label = "Relación Alb/Creat",
            defaultValueText = "10.11",
            subUnit = "mg/g",
            targetText = "Normal (<30) • Creat 0.70",
            tone = BiomarkerTone.EMERALD
        )
    )

    val goldenRules: List<ClinicalGoldenRule> = listOf(
        ClinicalGoldenRule(
            title = "1° Ensalada (2 tazas) → 2° Proteína (200 g) → 3° Carbohidrato",
            detail = "En todos tus almuerzos de las 14:00 PM come obligatoriamente primero las 2 tazas de ensalada fresca y en los desayunos de avena come primero los 2 huevos duros (reduce el pico glucémico en un 38%)."
        ),
        ClinicalGoldenRule(
            title = "Cero Aceites de Soya, Maíz o Girasol",
            detail = "Todos los almuerzos se cocinan en sartén u olla antiadherente con agua, ajo, cebolla, limón y especias para revertir tu TGP de 49.9 U/L y bajar el LDL de 124 mg/dL."
        ),
        ClinicalGoldenRule(
            title = "Protocolo Anti-Ácido Úrico y Sodio Renal",
            detail = "Enjuaga 10 s el atún y el queso fresco (retira 75% de sodio), remoja las lentejas 12 h desechando el agua y descarta el caldo oscuro al sellar el hígado del jueves."
        ),
        ClinicalGoldenRule(
            title = "Descanso Insulínico Nocturno de 13 Horas (19:00 a 08:00)",
            detail = "Cierra la ingesta calórica a las 19:00 PM y refrigera 12 h antes la papa, el camote y el arroz integral para formar almidón resistente tipo 3."
        )
    )

    fun formatRecipeForSharing(meal: Meal): String {
        return buildString {
            appendLine("${meal.dayName.uppercase()} (${meal.optionLabel}) — ${meal.time} • ${meal.slotLabel}")
            appendLine("Plato: ${meal.title}")
            appendLine("Macros Fitia Pro: ${meal.macros.kcal} kcal | ${meal.macros.prot}g Prot | ${meal.macros.carb}g Carbos | ${meal.macros.fat}g Grasas | ${meal.macros.fiber}g Fibra")
            if (meal.medAlert != null) {
                appendLine("Recordatorio: ${meal.medAlert}")
            }
            appendLine()
            appendLine("INGREDIENTES EXACTOS (PLAZA VEA / AGORA):")
            meal.ingredients.forEach { appendLine("• $it") }
            appendLine()
            appendLine("PREPARACIÓN PASO A PASO:")
            meal.steps.forEachIndexed { idx, step -> appendLine("${idx + 1}. $step") }
            appendLine()
            appendLine("NOTA CLÍNICA: ${meal.clinicalNote}")
        }.trim()
    }
}
