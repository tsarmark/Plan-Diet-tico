package com.example.data

internal object MealCatalogPart1 {
    val daysLunesToJueves: List<DayPlan> = listOf(
        DayPlan(
            dayIndex = 0,
            dayName = "Lunes",
            shortName = "Lun",
            optionLabel = "Opción 1 de la Doctora",
            focusTag = "Desinflamación e Inicio Semanal",
            nightPrepReminder = "Para mañana Martes: Deja en remojo 65 g de Lenteja Superior BELL'S en agua por 12 h (desechar el agua mañana para eliminar purinas) y guarda en táper los 70 g extra de pechuga SADIA cocida hoy.",
            meals = listOf(
                Meal(
                    id = "lun_desayuno",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg inmediatamente al terminar + 12 min caminata estática",
                    title = "Jugo de fresas con leche light con stevia + 1 pan con atún con tomate + 1 huevo duro",
                    shortDesc = "1 Huevo Pardo BELL'S duro + sándwich integral con 1/2 lata de atún BELL'S desalado + licuado de 100 g fresa con leche light.",
                    macros = Macros(kcal = 465, prot = 37, carb = 46, fat = 11, fiber = 7),
                    ingredients = listOf(
                        "1/2 lata (60 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g (guardar la otra mitad en táper para el viernes)",
                        "60 g de Tomate redondo en cubitos + jugo de 1/2 limón y orégano",
                        "2 rebanadas (55 g) de Pan de Molde Integral BELL'S tostado",
                        "1 Huevo Pardo BELL'S duro (cocido 9 min)",
                        "100 g de Fresa Entera Congelada BELL'S",
                        "60 ml de Leche Light GLORIA/BELL'S + 180 ml de agua y 3 gotas de stevia"
                    ),
                    steps = listOf(
                        "Enjuaga durante 10 segundos en un colador 1/2 lata (60 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g (retira el 75% del sodio; guarda la otra mitad en táper para el viernes).",
                        "Mézclalo con 60 g de tomate redondo en cubitos, jugo de 1/2 limón y orégano sobre 2 rebanadas (55 g) de Pan de Molde Integral BELL'S tostado.",
                        "ORDEN CLÍNICO: Come primero 1 Huevo Pardo BELL'S duro (cocido 9 min) y el sándwich; al final bebe el licuado de 100 g de Fresa Entera Congelada BELL'S + 60 ml de Leche Light GLORIA/BELL'S + 180 ml de agua y 3 gotas de stevia.",
                        "Toma tu Irbesartán 150 mg al terminar y realiza 12 minutos de caminata estática en tu habitación."
                    ),
                    clinicalNote = "El huevo duro aporta colina hepatoprotectora para reducir tu TGP de 49.9 U/L, y enjuagar el atún 10 segundos retira el 75% del sodio potenciando el Irbesartán 150 mg.",
                    timers = listOf(
                        RecipeTimerSpec("Huevo duro (9 min)", 9 * 60),
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "lun_mm",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM (Valle del Bisoprolol • RPE 6–8/10)",
                    title = "1 unidad mediana (130 g) de Manzana Israel con cáscara + 400 ml de agua pura",
                    shortDesc = "Fruta entera de bajo índice glucémico e hidratación previa al entrenamiento en habitación.",
                    macros = Macros(kcal = 68, prot = 0, carb = 18, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 unidad mediana (130 g) de Manzana Israel fresca con cáscara",
                        "400 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Lava bien la Manzana Israel y cómela entera conservando toda su cáscara a las 10:30 AM.",
                        "Bebe los 400 ml de agua pura antes de entrenar en tu espacio de 2x2 m entre las 11:00 AM y las 13:00 PM (regulando el esfuerzo por Escala RPE 6–8/10 y Test del Habla)."
                    ),
                    clinicalNote = "La pectina de la cáscara de manzana entrega energía sostenida sin elevar la insulina basal (39.0 μU/mL)."
                ),
                Meal(
                    id = "lun_almuerzo",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
                    title = "Pollo a las Hierbas (200 g) + 1 Taza de Arroz Integral + 2 Tazas de Ensalada + 1 Mandarina",
                    shortDesc = "Filete de Pechuga SADIA al vapor/sartén sin aceite + arroz integral BELL'S refrigerado 12 h + 2 tazas de ensalada.",
                    macros = Macros(kcal = 545, prot = 52, carb = 61, fat = 7, fiber = 8),
                    ingredients = listOf(
                        "200 g en crudo de Filete de Pechuga de Pollo SADIA (cocina 70 g extra para el pan del martes)",
                        "55 g en crudo de Arroz Integral BELL'S (hervido y refrigerado 12 h antes = 1 taza / 150 g cocido)",
                        "Ensalada (2 tazas): 100 g de Lechuga Americana, 80 g de Pepinillo con cáscara, 60 g de Tomate Redondo, jugo de 1 Limón Tahití/Sutil (20 ml)",
                        "Aderezo: 1 diente de ajo chancado, 1 cdta de mostaza, comino, orégano y 1 pizca de sal",
                        "Postre: 1 Mandarina W Murcott (100 g)"
                    ),
                    steps = listOf(
                        "Marina el filete de pechuga SADIA 10 min con ajo chancado, mostaza, limón, comino y orégano.",
                        "Cocínalo en sartén antiadherente a fuego medio con 2 cucharadas de agua y tapado (4 min por lado, cero aceite vegetal).",
                        "ORDEN DE INGESTA OBLIGATORIO: Come 1° las 2 tazas de ensalada, 2° los 200 g de pollo y 3° la taza de arroz integral recalentado y la mandarina.",
                        "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
                    ),
                    clinicalNote = "Cocinar sin aceite de soya/maíz/girasol y comer las 2 tazas de ensalada antes del arroz reduce el pico glucémico y ayuda a revertir tu TGP de 49.9 U/L.",
                    timers = listOf(
                        RecipeTimerSpec("Pollo lado 1 (4 min)", 4 * 60),
                        RecipeTimerSpec("Pollo lado 2 (4 min)", 4 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "lun_mt",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0% frío con 1/2 cdta de canela en polvo",
                    shortDesc = "Colación proteica 0% grasa y 0% azúcar que favorece la excreción renal de ácido úrico.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0% frío",
                        "1/2 cucharadita de Canela en polvo"
                    ),
                    steps = listOf(
                        "Sirve los 180 ml de Yogurt GLORIA Slim Triple Zero 0% frío a las 16:30 y espolvorea media cucharadita de canela en polvo."
                    ),
                    clinicalNote = "Los péptidos lácteos desnatados sin azúcar facilitan la eliminación renal de uratos (bajando tu ácido úrico de 6.65 mg/dL)."
                ),
                Meal(
                    id = "lun_cena",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00 (13 horas de descanso insulínico nocturno hasta las 08:00 AM)",
                    title = "1 Lata de Atún + 1 Papa sancochada (Almidón Resistente Tipo 3)",
                    shortDesc = "1 lata de Filete de Atún en Agua BELL'S desalada al limón con cebolla roja + 1 Papa Blanca Yungay refrigerada 12 h.",
                    macros = Macros(kcal = 275, prot = 31, carb = 32, fat = 2, fiber = 4),
                    ingredients = listOf(
                        "1 lata completa (100–120 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g",
                        "30 g de Cebolla roja picada fina, jugo de 1/2 limón, orégano y pimienta",
                        "1 unidad mediana (150 g) de Papa Blanca Yungay sancochada con cáscara y refrigerada 12 h antes"
                    ),
                    steps = listOf(
                        "Abre 1 lata completa (100–120 g escurridos) de Filete de Atún en Agua BELL'S, enjuágala en colador por 10 seg para retirar el sodio.",
                        "Mézclala con 30 g de cebolla roja picada fina, jugo de 1/2 limón, orégano y pimienta.",
                        "Sirve con 1 unidad mediana (150 g) de Papa Blanca Yungay sancochada con cáscara y refrigerada 12 h antes (almidón resistente tipo 3)."
                    ),
                    clinicalNote = "Cerrar la ingesta a las 19:00 con almidón resistente tipo 3 otorga 13 horas de descanso insulínico nocturno para revertir el HOMA-IR de 9.73."
                )
            )
        ),
        DayPlan(
            dayIndex = 1,
            dayName = "Martes",
            shortName = "Mar",
            optionLabel = "Opción 2 de la Doctora",
            focusTag = "Fibra Soluble y Reducción de LDL",
            nightPrepReminder = "Para mañana Miércoles: Sancocha con cáscara 160 g de Camote Amarillo Procesado PLAZA VEA y déjalo refrigerando 12 h. Pasa 1 filete (200 g) de Basa BELL'S del congelador al refrigerador.",
            meals = listOf(
                Meal(
                    id = "mar_desayuno",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "1 Taza de leche light/sin lactosa + 2 mandarinas + 1 pan con pollo",
                    shortDesc = "Sándwich en Pan Integral BELL'S con 70 g de pechuga SADIA deshilachada, apio y Yogurt Slim 0% + leche tibia con canela + 2 mandarinas.",
                    macros = Macros(kcal = 440, prot = 32, carb = 56, fat = 8, fiber = 7),
                    ingredients = listOf(
                        "70 g de Pechuga de Pollo SADIA cocida y deshilachada (separada del lunes)",
                        "20 g de Apio picado + 1 cda (15 g) de Yogurt Gloria Slim 0% (en vez de mayonesa), limón y pimienta",
                        "2 rebanadas de Pan Integral BELL'S tostado",
                        "1 taza de leche tibia con canela (60 ml de Leche Light GLORIA + 180 ml de agua)",
                        "2 unidades (180 g) de Mandarina W Murcott en gajos enteros"
                    ),
                    steps = listOf(
                        "Mezcla 70 g de pechuga de pollo SADIA cocida y deshilachada (separada del lunes) con 20 g de apio picado, 1 cda (15 g) de Yogurt Gloria Slim 0% (en vez de mayonesa), limón y pimienta dentro de 2 rebanadas de Pan Integral BELL'S.",
                        "Acompaña con 1 taza de leche tibia con canela (60 ml de Leche Light + 180 ml de agua).",
                        "Termina con 2 unidades (180 g) de Mandarina W Murcott en gajos enteros. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "Reemplazar la mayonesa por Yogurt Gloria Slim 0% al limón evita grasas trans/omega-6 proinflamatorias y cuida tu perfil lipídico.",
                    timers = listOf(
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "mar_mm",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en espacio de 2x2 m entre 11:00 AM y 13:00 PM",
                    title = "1/2 unidad (60 g) de Plátano de Seda no muy maduro + 400 ml de agua",
                    shortDesc = "Energía pre-entreno con almidón resistente y potasio natural.",
                    macros = Macros(kcal = 55, prot = 1, carb = 14, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1/2 unidad (60 g) de Plátano de Seda no muy maduro",
                        "400 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Consume 1/2 unidad (60 g) de Plátano de Seda no muy maduro con 400 ml de agua a las 10:30 AM antes de tu sesión en habitación."
                    ),
                    clinicalNote = "El plátano pintón aporta potasio para la función muscular manteniendo bajo el índice glucémico."
                ),
                Meal(
                    id = "mar_almuerzo",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
                    title = "Medallones Caseros de Pavita (200 g) + 1 Taza de Lentejas + 2 Tazas de Ensalada + 1 Mandarina",
                    shortDesc = "2 medallones caseros de Carne Molida de Pavita SAN FERNANDO a la plancha + lentejas BELL'S despurinizadas + 2 tazas de ensalada.",
                    macros = Macros(kcal = 585, prot = 61, carb = 64, fat = 6, fiber = 15),
                    ingredients = listOf(
                        "200 g en crudo de Carne Molida de Pavita SAN FERNANDO (Paquete 500g; congelar los 300 g restantes)",
                        "65 g en crudo de Lenteja Superior BELL'S (remojada 12 h en agua que se desecha para eliminar purinas = 1 taza / 180 g cocida)",
                        "Sofrito al agua de lentejas: 30 g de cebolla roja, 1 diente de ajo, 20 g de zanahoria en cubitos, laurel y comino",
                        "Ensalada (2 tazas): 120 g de lechuga americana, 70 g de tomate, 50 g de pepinillo y jugo de 1 limón",
                        "Postre: 1 Mandarina W Murcott (100 g)"
                    ),
                    steps = listOf(
                        "Desecha el agua de remojo de 12 h de las lentejas y hierve los 65 g en agua limpia con cebolla, ajo, zanahoria en cubitos, laurel y comino por 20 minutos.",
                        "Sazona los 200 g de carne molida de pavita SAN FERNANDO con ajo picado, perejil/orégano, comino y pimienta; forma 2 medallones gruesos tipo hamburguesa y dóralos en sartén antiadherente 4 min por lado sin aceite.",
                        "ORDEN CLÍNICO: Come 1° las 2 tazas de ensalada, 2° los medallones de pavita y 3° la taza de lentejas y la mandarina. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Sus 15 g de fibra soluble atrapan sales biliares de colesterol en el intestino para reducir directamente tu LDL de 124 mg/dL a <100 mg/dL.",
                    timers = listOf(
                        RecipeTimerSpec("Cocción lentejas (20 min)", 20 * 60),
                        RecipeTimerSpec("Medallones pavita (4 min/lado)", 4 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "mar_mt",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Maní Tostado Natural Sin Sal VILLA NATURA pesado en balanza",
                    shortDesc = "Grasas monoinsaturadas cardioprotectoras para elevar el colesterol HDL (45.4 mg/dL).",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal VILLA NATURA pesado en balanza"
                    ),
                    steps = listOf(
                        "Pesa exactamente 20 g en tu balanza de cocina a las 16:30 y acompáñalos con un vaso grande de agua."
                    ),
                    clinicalNote = "El ácido oleico sin sal añadida eleva el colesterol protector HDL sin estimular la insulina."
                ),
                Meal(
                    id = "mar_cena",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00",
                    title = "Ensalada fresca (1.5 tazas) + Pollo a la plancha (150 g) + 1 Choclo",
                    shortDesc = "150 g de Filete de Pechuga SADIA a la plancha sin aceite + 1.5 tazas de ensalada + 1 taza de Choclo BELL'S.",
                    macros = Macros(kcal = 335, prot = 38, carb = 31, fat = 5, fiber = 5),
                    ingredients = listOf(
                        "150 g de Filete de Pechuga de Pollo SADIA sazonado con ajo, limón y orégano",
                        "1.5 tazas de ensalada (80 g lechuga americana, 70 g pepinillo, 50 g tomate)",
                        "1 taza (120 g) de Choclo Desgranado BELL'S sancochado con anís"
                    ),
                    steps = listOf(
                        "Cocina en sartén antiadherente sin aceite los 150 g de Filete de Pechuga de Pollo SADIA sazonado con ajo, limón y orégano.",
                        "Acompaña primero con las 1.5 tazas de ensalada fresca y luego con 1 taza (120 g) de Choclo Desgranado BELL'S sancochado con anís."
                    ),
                    clinicalNote = "Cena magra de digestión limpia que protege la masa muscular mientras inicia el ayuno nocturno de 13 horas."
                )
            )
        ),
        DayPlan(
            dayIndex = 2,
            dayName = "Miércoles",
            shortName = "Mié",
            optionLabel = "Opción 3 de la Doctora",
            focusTag = "Betaglucanos, Chía y Pescado Blanco",
            nightPrepReminder = "Para mañana Jueves: Pasa 1 porción (180–200 g) de Hígado de Res EL BUEN CORTE al refrigerador y deja sancochada y refrigerando 1 Papa Blanca Yungay mediana (130 g) para la cena del jueves.",
            meals = listOf(
                Meal(
                    id = "mie_desayuno",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "1 Taza de avena con canela + manzana, 1/2 plátano, arándanos, 1 cda chía + 2 huevos duros",
                    shortDesc = "Come primero los 2 Huevos Pardos BELL'S duros y luego el porridge de 40 g Avena con 10 g Chía, frutas y 30 g Blueberries BELL'S.",
                    macros = Macros(kcal = 485, prot = 21, carb = 58, fat = 18, fiber = 11),
                    ingredients = listOf(
                        "2 Huevos Pardos BELL'S duros (comer primero)",
                        "40 g de Avena GRANO DE ORO / 3 OSITOS hervida 4 min en 250 ml de agua con canela",
                        "1 cda (10 g) de Chía Negra ECOANDINO",
                        "1/2 Manzana Israel (65 g) en cubos + 1/2 Plátano de seda (55 g)",
                        "30 g de Blueberries (Arándanos) BELL'S FRESCOS"
                    ),
                    steps = listOf(
                        "ORDEN CLÍNICO: Come primero los 2 Huevos Pardos BELL'S duros (frena el pico glucémico matutino en un 38%).",
                        "Luego consume tu porridge hecho hirviendo 4 min 40 g de Avena GRANO DE ORO / 3 OSITOS en 250 ml de agua con canela.",
                        "Al apagar el fuego añade 1 cda (10 g) de Chía ECOANDINO, 1/2 Manzana Israel (65 g) en cubos, 1/2 Plátano de seda (55 g) y 30 g de Blueberries BELL'S FRESCOS.",
                        "Toma tu Irbesartán 150 mg al terminar."
                    ),
                    clinicalNote = "Los betaglucanos de la avena más el gel soluble de la chía y las antocianinas de los arándanos mejoran la sensibilidad a la insulina (HOMA-IR).",
                    timers = listOf(
                        RecipeTimerSpec("Hervor avena (4 min)", 4 * 60),
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "mie_mm",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en espacio de 2x2 m entre 11:00 AM y 13:00 PM",
                    title = "1 unidad mediana (100 g) de Mandarina W Murcott en gajos",
                    shortDesc = "Vitamina C y naringenina cítrica antes de tu entrenamiento.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 unidad mediana (100 g) de Mandarina W Murcott en gajos"
                    ),
                    steps = listOf(
                        "Consume la mandarina en gajos enteros conservando el hollejo blanco a las 10:30 AM."
                    ),
                    clinicalNote = "Favorece la oxidación hepática de ácidos grasos y aporta hidratación pre-entreno."
                ),
                Meal(
                    id = "mie_almuerzo",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
                    title = "Filete de Basa al Vapor/Sudado (200 g) + 1 Camote + 2 Tazas de Ensalada + 1 Manzana",
                    shortDesc = "200 g Filete de Basa BELL'S al vapor 7 min sobre cama de cebolla y tomate + 160 g camote refrigerado + 2 tazas de ensalada.",
                    macros = Macros(kcal = 495, prot = 43, carb = 64, fat = 6, fiber = 9),
                    ingredients = listOf(
                        "200 g de Filete de Basa BELL'S (Bolsa 1Kg) descongelado",
                        "160 g de Camote Amarillo Procesado PLAZA VEA sancochado con cáscara y refrigerado 12 h",
                        "Cama de sudado: 30 g de cebolla roja en pluma, 40 g de tomate en rodajas, 1 diente de ajo, orégano y limón",
                        "Ensalada (2 tazas): 100 g de lechuga americana, 60 g de Vainita Americana al vapor al dente, 60 g de pepinillo y limón",
                        "Postre: 1 Manzana Israel pequeña (110 g)"
                    ),
                    steps = listOf(
                        "Coloca el filete de basa BELL'S sobre la cama de cebolla, tomate y ajo en una sartén con 1/4 taza de agua; tapa y cocina al vapor 7 minutos (cero aceite).",
                        "Come 1° las 2 tazas de ensalada con vainitas al dente, 2° el filete de basa sudado y 3° el camote amarillo y la manzana.",
                        "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
                    ),
                    clinicalNote = "El pescado blanco (Basa) tiene 55% menos purinas que el bonito o caballa, protegiendo tu ácido úrico (6.65 mg/dL).",
                    timers = listOf(
                        RecipeTimerSpec("Basa al vapor (7 min)", 7 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "mie_mt",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%",
                    shortDesc = "Proteína ligera de media tarde sin grasa ni azúcar.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%"
                    ),
                    steps = listOf(
                        "Servir frío a las 16:30."
                    ),
                    clinicalNote = "Mantiene la saciedad vespertina y favorece la excreción renal de ácido úrico."
                ),
                Meal(
                    id = "mie_cena",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00",
                    title = "Ensalada + 1 Tortilla Rapidita Integral con Atún",
                    shortDesc = "1 Tortilla BIMBO Rapidita Integral rellena con 1 lata de Atún en Agua BELL'S desalada + 1 taza adicional de ensalada fresca.",
                    macros = Macros(kcal = 265, prot = 31, carb = 19, fat = 5, fiber = 5),
                    ingredients = listOf(
                        "1 Tortilla BIMBO Rapidita Integral (congelar las 9 restantes de la bolsa)",
                        "1 lata (100–120 g escurridos) de Filete de Atún en Agua BELL'S (enjuagada en colador)",
                        "Lechuga americana picada, tomate y limón + 1 taza adicional de ensalada fresca al lado"
                    ),
                    steps = listOf(
                        "Calienta 25 seg por lado 1 Tortilla BIMBO Rapidita Integral en sartén seca.",
                        "Rellénala con 1 lata (100–120 g escurridos) de Filete de Atún en Agua BELL'S (enjuagada en colador), lechuga americana picada, tomate y limón, más 1 taza adicional de ensalada fresca al lado."
                    ),
                    clinicalNote = "Aporta apenas 13 g de carbohidratos netos con 31 g de proteína magra para optimizar la sensibilidad insulínica nocturna."
                )
            )
        ),
        DayPlan(
            dayIndex = 3,
            dayName = "Jueves",
            shortName = "Jue",
            optionLabel = "Opción 4 de la Doctora",
            focusTag = "Protocolo Anti-Ácido Úrico",
            nightPrepReminder = "Para mañana Viernes: Deja listos 80 g de Filete de Pechuga SADIA cocida y deshilachada para el pan del desayuno del viernes, y verifica la 1/2 lata de atún reservada del lunes.",
            meals = listOf(
                Meal(
                    id = "jue_desayuno",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 de la Doctora",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
                    title = "Batido de fresa con leche + 1 Pan con queso fresco + 1 Mandarina",
                    shortDesc = "Sándwich en Pan Integral BELL'S con 40 g de Queso Fresco BELL'S desalado + licuado de 100 g fresa con leche light + 1 mandarina.",
                    macros = Macros(kcal = 395, prot = 21, carb = 55, fat = 9, fiber = 7),
                    ingredients = listOf(
                        "1 tajada de 40 g de Queso Fresco BELL'S (Paquete 300g) pasada 10 seg por agua fría",
                        "2 rebanadas de Pan Integral BELL'S tostado + rodajas de tomate y orégano",
                        "100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia",
                        "1 Mandarina W Murcott mediana (100 g)"
                    ),
                    steps = listOf(
                        "Pasa por agua fría durante 10 seg 1 tajada de 40 g de Queso Fresco BELL'S (Paquete 300g) y arma tu sándwich con rodajas de tomate y orégano en 2 rebanadas de Pan Integral BELL'S tostado.",
                        "Licúa 100 g de Fresa Congelada BELL'S con 60 ml de Leche Light, 180 ml de agua y stevia.",
                        "Come primero el sándwich de queso, luego el batido y cierra con 1 Mandarina mediana. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "El calcio y los péptidos lácteos del queso fresco BELL'S y la leche preparan al riñón para excretar uratos hoy que toca hígado en el almuerzo.",
                    timers = listOf(
                        RecipeTimerSpec("Caminata post-desayuno (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "jue_mm",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 de la Doctora",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM + beber 500 ml de agua",
                    title = "1 Manzana Israel mediana (130 g) con cáscara + 500 ml de agua",
                    shortDesc = "Quercetina natural e hidratación reforzada en el día de control de purinas.",
                    macros = Macros(kcal = 68, prot = 0, carb = 18, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 Manzana Israel mediana (130 g) con cáscara",
                        "500 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Consume la manzana entera con cáscara a las 10:30 AM acompañada de 500 ml de agua antes de tu rutina."
                    ),
                    clinicalNote = "Mantener alto el volumen urinario diluye el ácido úrico sérico (6.65 mg/dL)."
                ),
                Meal(
                    id = "jue_almuerzo",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 de la Doctora",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol 2.5 mg + 350 ml de agua con medio limón (Alcalinizante Renal)",
                    title = "Hígado de Res Encebollado Despurinizado (180 g) + 1 Choclo + 2 Tazas de Ensalada + 1 Mandarina",
                    shortDesc = "180 g Hígado EL BUEN CORTE sellado descartando el jugo oscuro + encebollado rico en quercetina + 1 taza de choclo + ensalada.",
                    macros = Macros(kcal = 510, prot = 46, carb = 58, fat = 8, fiber = 9),
                    ingredients = listOf(
                        "180 g de Hígado de Res EL BUEN CORTE",
                        "1 taza (140 g) de Choclo Desgranado BELL'S sancochado",
                        "Encebollado rico en quercetina: 70 g de cebolla roja en pluma gruesa, 50 g de tomate en gajos, 1 diente de ajo, 1 cda de vinagre, comino y orégano",
                        "Ensalada (2 tazas): 120 g de pepinillo, 80 g de lechuga americana, 40 g de zanahoria cruda rallada y jugo de 1 limón",
                        "Postre: 1 Mandarina + 350 ml de agua con medio limón"
                    ),
                    steps = listOf(
                        "PREPARACIÓN ANTI-ÁCIDO ÚRICO: Sella el hígado en sartén caliente 2 min por lado, retíralo al plato y DESCARTA POR COMPLETO el jugo oscuro que soltó en la sartén (allí se concentran las purinas hidrosolubles).",
                        "En la sartén limpia saltea con 2 cdas de agua los 70 g de cebolla roja y el tomate por 2 min y sírvelos encima del hígado.",
                        "Come 1° las 2 tazas de ensalada, 2° el hígado encebollado y 3° el choclo y la mandarina, bebiendo los 350 ml de agua con medio limón. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Descartar el caldo de cocción del hígado y combinarlo con 70 g de cebolla roja (quercetina inhibidora de la xantina oxidasa) y citrato de limón protege tu ácido úrico.",
                    timers = listOf(
                        RecipeTimerSpec("Sellado hígado (2 min/lado)", 2 * 60),
                        RecipeTimerSpec("Salteado cebolla (2 min)", 2 * 60),
                        RecipeTimerSpec("Caminata post-almuerzo (12 min)", 12 * 60)
                    )
                ),
                Meal(
                    id = "jue_mt",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 de la Doctora",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
                    shortDesc = "Grasas saludables y magnesio intracelular sin sodio.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
                    ),
                    steps = listOf(
                        "Pesar 20 g en balanza y consumir a las 16:30 con agua."
                    ),
                    clinicalNote = "Aporta saciedad sin elevar la glucosa ni el ácido úrico."
                ),
                Meal(
                    id = "jue_cena",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 de la Doctora",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ingesta a las 19:00",
                    title = "Ensalada de verduras (2 tazas) con 1 Lata de Atún y 1 Papa en cubos",
                    shortDesc = "Bowl de pepinillo, tomate, vainitas al vapor, lechuga americana, 1 Papa Yungay fría en dados y 1 lata de Atún BELL'S desalada.",
                    macros = Macros(kcal = 285, prot = 32, carb = 31, fat = 2, fiber = 5),
                    ingredients = listOf(
                        "1 lata de Filete de Atún en Agua BELL'S desalada al limón",
                        "1 Papa Blanca Yungay mediana (130 g) sancochada y fría en dados",
                        "Bowl de 2 tazas de verduras: 80 g de pepinillo, 60 g de tomate, 50 g de vainitas al vapor y 60 g de lechuga americana"
                    ),
                    steps = listOf(
                        "Mezcla en un bowl 80 g de pepinillo, 60 g de tomate, 50 g de vainitas al vapor, 60 g de lechuga americana y 1 Papa Blanca Yungay mediana (130 g) sancochada y fría en dados.",
                        "Corona con 1 lata de Filete de Atún en Agua BELL'S desalada en colador y aliñada con jugo de limón."
                    ),
                    clinicalNote = "Cena alcalinizante rica en potasio vegetal para sostener el control de presión arterial durante la noche."
                )
            )
        )
    )
}
