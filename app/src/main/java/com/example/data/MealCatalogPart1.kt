package com.example.data

internal object MealCatalogPart1 {
    val daysLunesToJueves: List<DayPlan> = listOf(
        DayPlan(
            dayIndex = 0,
            dayName = "Lunes",
            shortName = "Lun",
            optionLabel = "Opción 1 — Lic. Isabel Ríos",
            focusTag = "Desinflamación e Inicio Semanal",
            meals = listOf(
                Meal(
                    id = "lun_desayuno",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "Jugo de fresas con leche light con stevia + 1 pan con atún con tomate + 1 huevo duro",
                    shortDesc = "Batido antioxidante de fresa + sándwich integral de atún desalado al limón + 1 huevo duro.",
                    macros = Macros(kcal = 465, prot = 37, carb = 46, fat = 11, fiber = 7),
                    ingredients = listOf(
                        "100 g de Fresa entera congelada Bell's / ARO",
                        "60 ml de Leche Evaporada Light Bell's + 180 ml de agua fría",
                        "3 gotas de Stevia líquida natural (sin maltodextrina)",
                        "1/2 lata (60 g escurridos) de Filete de Atún en Agua Bell's (guardar la otra mitad en táper para el viernes)",
                        "60 g de Tomate fresco picado en cubitos",
                        "2 rebanadas (55 g) de Pan de Molde Integral Bell's tostado",
                        "1 unidad (55 g) de Huevo Pardo Bell's duro (cocido 9 min)",
                        "Jugo de 1/2 limón sutil (10 ml), orégano seco y pimienta"
                    ),
                    steps = listOf(
                        "Coloca la media lata de atún en un colador pequeño y enjuágala durante 10 segundos bajo el chorro de agua fría para eliminar hasta el 75% del sodio de la conserva.",
                        "Mezcla el atún bien escurrido con los 60 g de tomate en cubitos, el jugo de medio limón, orégano seco y pimienta negra. Rellena las 2 rebanadas de pan integral tostado.",
                        "En la licuadora, procesa los 100 g de fresas congeladas con los 60 ml de leche evaporada light, 180 ml de agua y 3 gotas de stevia por 30 segundos.",
                        "ORDEN DE INGESTA CLÍNICO: Come primero el huevo duro y el sándwich de atún con tomate; bebe el batido de fresa con leche al final para evitar picos de glucosa.",
                        "Toma tu pastilla de Irbesartán 150 mg con un vaso de agua pura al terminar y realiza 12 minutos de marcha suave en tu habitación a las 08:20 AM."
                    ),
                    clinicalNote = "El huevo duro aporta 145 mg de colina para exportar grasa del hígado (bajando tu TGP de 49.9 U/L), mientras que enjuagar el atún en agua protege tus riñones y potencia el efecto antihipertensivo del Irbesartán 150 mg."
                ),
                Meal(
                    id = "lun_mm",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar en 2x2 m entre 11:00 AM y 13:00 PM (Valle del Bisoprolol — Escala RPE 6 a 8)",
                    title = "1 Manzana Israel mediana con cáscara + Hidratación pre-entreno",
                    shortDesc = "Fruta entera de bajo índice glucémico antes de tu rutina en habitación de 2x2 m.",
                    macros = Macros(kcal = 68, prot = 0, carb = 18, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 unidad mediana (130 g) de Manzana Israel fresca bien lavada (con cáscara)",
                        "400 ml de Agua pura a temperatura ambiente"
                    ),
                    steps = listOf(
                        "Lava bien la manzana Israel y cómela en trozos conservando el 100% de la cáscara (allí se concentra la pectina y el ácido ursólico).",
                        "Bebe 400 ml de agua pura antes de iniciar tu rutina silenciosa de fuerza en tu habitación de 2x2 metros."
                    ),
                    clinicalNote = "La pectina de la cáscara de manzana libera energía gradual para tu entrenamiento de media mañana sin disparar la insulina basal (39.0 uU/mL)."
                ),
                Meal(
                    id = "lun_almuerzo",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática (14:20)",
                    title = "2 Tazas de Ensalada Fresca + Pollo a las Hierbas (200 g) + 1 Taza de Arroz + 1 Mandarina",
                    shortDesc = "Pechuga jugosa al vapor/sartén sin aceite + arroz integral refrigerado + 2 tazas de ensalada.",
                    macros = Macros(kcal = 545, prot = 52, carb = 61, fat = 7, fiber = 8),
                    ingredients = listOf(
                        "200 g en crudo de Filete de Pechuga de Pollo Fresca sin piel (tip: cocina 70 g extra para dejar listo tu pan del martes)",
                        "55 g en crudo de Arroz Integral Bell's (equivale exactamente a 1 taza / 150 g ya cocido y refrigerado 12 h)",
                        "100 g de Col blanca o Lechuga fresca picada fina (Ensalada Taza 1)",
                        "80 g de Pepinillo en rodajas con cáscara + 60 g de Tomate en gajos (Ensalada Taza 2)",
                        "Jugo de 1 limón sutil entero (20 ml), 1 diente de ajo chancado (4 g), 1 cdta de mostaza, comino, orégano y 1 pizca medida de sal",
                        "1 unidad mediana (100 g) de Mandarina W Murcott en gajos"
                    ),
                    steps = listOf(
                        "Marina los 200 g de pechuga de pollo durante 10 minutos con el diente de ajo chancado, 1 cdta de mostaza, jugo de medio limón, comino, orégano y pimienta.",
                        "Calienta tu sartén antiadherente a fuego medio (CERO aceite vegetal). Coloca la pechuga con 2 cucharadas soperas de agua, tapa la sartén y cocina 4 minutos por lado hasta que quede dorada y jugosa.",
                        "Arma tus 2 tazas reglamentarias de ensalada con la col/lechuga, pepinillo con cáscara y tomate, aliñando con jugo de limón y orégano.",
                        "ORDEN DE INGESTA OBLIGATORIO: 1° Come las 2 tazas de ensalada fresca → 2° Come los 200 g de pollo → 3° Come la taza de arroz integral (previamente refrigerado 12 h y recalentado) y cierra con la mandarina.",
                        "Toma tu pastilla de Bisoprolol 2.5 mg al terminar de almorzar (14:15)."
                    ),
                    clinicalNote = "Al entrenar antes de las 14:00 y comer primero las 2 tazas de ensalada, tus músculos captan la glucosa de la taza de arroz mediante transportadores GLUT-4 sin exigir que tu páncreas secrete insulina extra."
                ),
                Meal(
                    id = "lun_mt",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 Vaso de Yogurt Gloria Slim Triple Zero 0% con Canela",
                    shortDesc = "Aporte proteico ligero de media tarde sin azúcar ni grasa saturada.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt Gloria Slim Triple Zero (0% grasa, 0% azúcar añadida, 0% lactosa)",
                        "1/2 cucharadita de Canela en polvo"
                    ),
                    steps = listOf(
                        "Sirve los 180 ml de Yogurt Gloria Slim 0% frío en un vaso o bowl a las 16:30 y espolvorea media cucharadita de canela en polvo encima."
                    ),
                    clinicalNote = "Los lácteos desnatados sin azúcar contienen péptidos bioactivos (caseína y lactosuero) que promueven la excreción renal de ácido úrico (bajando tu nivel de 6.65 mg/dL)."
                ),
                Meal(
                    id = "lun_cena",
                    dayIndex = 0,
                    dayName = "Lunes",
                    optionLabel = "Opción 1 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00 (13 horas de descanso insulínico nocturno hasta las 08:00 AM)",
                    title = "1 Lata de Atún al Limón + 1 Papa Sancochada (Almidón Resistente)",
                    shortDesc = "Atún en agua desalado con cebolla roja y perejil + papa blanca sancochada y enfriada.",
                    macros = Macros(kcal = 275, prot = 31, carb = 32, fat = 2, fiber = 4),
                    ingredients = listOf(
                        "1 lata completa (120 g escurridos) de Filete de Atún en Agua Bell's",
                        "1 unidad mediana (150 g en crudo) de Papa Blanca Yungay sancochada con cáscara y refrigerada 12 horas",
                        "30 g de Cebolla roja picada muy fina y lavada",
                        "Jugo de 1/2 limón sutil (10 ml), orégano o perejil picado y pimienta"
                    ),
                    steps = listOf(
                        "Abre la lata de Filete de Atún en Agua Bell's, vacíala en un colador y enjuágala 10 segundos bajo el caño para retirar el sodio de conserva.",
                        "Mezcla el atún con la cebolla roja picada fina, el jugo de medio limón, orégano y pimienta.",
                        "Corta en rodajas la papa sancochada (que estuvo refrigerada al menos 12 horas para cristalizar su almidón en almidón resistente tipo 3; puedes comerla tibia o fría) y sírvela con el atún encima."
                    ),
                    clinicalNote = "Cenar a las 19:00 con solo 2 g de grasa y papa retrogradada permite que tu insulina baje rápidamente a niveles basales durante la noche, activando la lipólisis hepática."
                )
            )
        ),
        DayPlan(
            dayIndex = 1,
            dayName = "Martes",
            shortName = "Mar",
            optionLabel = "Opción 2 — Lic. Isabel Ríos",
            focusTag = "Fibra Soluble y Control de LDL",
            meals = listOf(
                Meal(
                    id = "mar_desayuno",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "1 Taza de leche sin lactosa/light + 2 Mandarinas + 1 Pan con pollo",
                    shortDesc = "Taza de leche tibia a la canela + sándwich integral de pollo deshilachado (70 g) + 2 mandarinas.",
                    macros = Macros(kcal = 440, prot = 32, carb = 56, fat = 8, fiber = 7),
                    ingredients = listOf(
                        "60 ml de Leche Evaporada Light / Sin Lactosa Bell's + 180 ml de agua caliente con canela y clavo",
                        "70 g de Pechuga de pollo ya cocida y deshilachada (reservada del lunes)",
                        "20 g de Apio fresco picado muy chiquito",
                        "1 cucharada (15 g) de Yogurt Gloria Slim 0% (como reemplazo saludable de la mayonesa) + gotas de limón",
                        "2 rebanadas (55 g) de Pan de Molde Integral Bell's tostado",
                        "2 unidades medianas (180 g) de Mandarina W Murcott enteras en gajos"
                    ),
                    steps = listOf(
                        "Mezcla los 70 g de pechuga deshilachada con el apio picado, 1 cucharada de yogurt natural 0%, gotas de limón, pimienta y orégano. Arma tu sándwich en el pan integral tostado.",
                        "Prepara tu taza de 240 ml de leche tibia diluyendo 60 ml de leche light en 180 ml de agua hervida con canela.",
                        "Come primero el pan con pollo, luego la taza de leche y termina con las 2 mandarinas en gajos enteros (nunca exprimidas en jugo). Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "Sustituir la mayonesa comercial por yogurt 0% con limón elimina 12 g de aceite de soya proinflamatorio y protege tu colesterol LDL (actualmente en 124 mg/dL, meta <100 mg/dL)."
                ),
                Meal(
                    id = "mar_mm",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM en tu espacio de 2x2 m",
                    title = "1/2 Plátano de seda pequeño (o 1 Manzana Israel)",
                    shortDesc = "Potasio biodisponible y energía controlada pre-entrenamiento.",
                    macros = Macros(kcal = 55, prot = 1, carb = 14, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1/2 unidad (60 g) de Plátano de seda no muy maduro (o 1 manzana pequeña de 110 g)",
                        "400 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Consume el medio plátano de seda a las 10:30 AM antes de iniciar tu sesión de ejercicios en habitación."
                    ),
                    clinicalNote = "El plátano no excesivamente maduro conserva almidón resistente y aporta potasio natural para la contracción muscular sin disparar la glucemia."
                ),
                Meal(
                    id = "mar_almuerzo",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática (14:20)",
                    title = "2 Tazas de Ensalada + Pavita a la Plancha (200 g) + 1 Taza de Lentejas + 1 Mandarina",
                    shortDesc = "Medallones magros de pavita San Fernando + lentejas despurinizadas por remojo + 2 tazas de ensalada.",
                    macros = Macros(kcal = 585, prot = 61, carb = 64, fat = 6, fiber = 15),
                    ingredients = listOf(
                        "200 g en crudo de Pavita en trozos o medallones San Fernando (sin piel)",
                        "65 g en crudo de Lenteja Superior Bell's (remojada 12 h y escurrida; rinde 1 taza / 180 g cocida)",
                        "Aderezo al agua para lentejas: 30 g de Cebolla roja picada, 1 diente de ajo, 20 g de Zanahoria en cubitos, 1 hoja de laurel y comino (CERO tocino o embutidos)",
                        "Ensalada (2 tazas): 120 g de Col blanca picada muy fina, 70 g de Tomate en cubos, 50 g de Pepinillo y jugo de 1 limón sutil (20 ml)",
                        "1 unidad mediana (100 g) de Mandarina en gajos"
                    ),
                    steps = listOf(
                        "REGLA ANTI-ÁCIDO ÚRICO: Deja las lentejas en remojo desde la noche anterior (12 h), bota el agua de remojo y enjuágalas bien (esto reduce oligosacáridos y purinas solubles).",
                        "En una olla pequeña, cocina la cebolla y el ajo con 3 cucharadas de agua (sin aceite) por 3 minutos; añade las lentejas, zanahoria en cubitos, laurel y agua limpia por 20 minutos.",
                        "Sazona los 200 g de pavita con ajo, orégano, comino, pimienta y gotas de limón, y dóralos en sartén antiadherente caliente.",
                        "Come primero las 2 tazas de ensalada al limón, luego los 200 g de pavita, después la taza de lentejas y finalmente la mandarina. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Este plato entrega 15 g de fibra soluble viscosa que atrapa sales biliares de colesterol en el intestino, siendo tu herramienta #1 para bajar el LDL de 124 mg/dL a menos de 100 mg/dL."
                ),
                Meal(
                    id = "mar_mt",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Frutos Secos / Maní Tostado Natural Sin Sal",
                    shortDesc = "Grasas monoinsaturadas (ácido oleico) para elevar tu colesterol HDL.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g (1 puñado pequeño pesado en balanza) de Maní Tostado Natural Sin Sal ni Aceite Villa Natura"
                    ),
                    steps = listOf(
                        "Pesa exactamente 20 g en tu balanza de cocina a las 16:30 y mastícalos despacio acompañados de un vaso grande de agua."
                    ),
                    clinicalNote = "Sus 10 g de grasas monoinsaturadas sin sodio elevan directamente tu colesterol protector HDL (45.4 mg/dL) con impacto glucémico e insulínico igual a cero."
                ),
                Meal(
                    id = "mar_cena",
                    dayIndex = 1,
                    dayName = "Martes",
                    optionLabel = "Opción 2 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00",
                    title = "Ensalada Fresca (1.5 tazas) + Pollo a la Plancha (150 g) + 1 Choclo",
                    shortDesc = "Filete de pechuga a las finas hierbas + 1 taza de choclo sancochado + ensalada al limón.",
                    macros = Macros(kcal = 335, prot = 38, carb = 31, fat = 5, fiber = 5),
                    ingredients = listOf(
                        "150 g en crudo de Filete de Pechuga de Pollo Fresca sin piel",
                        "1 taza (120 g) de Choclo Desgranado Bell's sancochado con anís",
                        "1.5 tazas de Ensalada fresca: 80 g de Col/Lechuga, 70 g de Pepinillo en rodajas, 50 g de Tomate",
                        "Jugo de 1/2 limón sutil, 1 diente de ajo, orégano seco y pimienta"
                    ),
                    steps = listOf(
                        "Sazona los 150 g de filete de pechuga con ajo, orégano, pimienta y limón, y cocínalos en sartén antiadherente 4 minutos por lado sin aceite.",
                        "Sirve primero la ensalada fresca, luego la pechuga a la plancha y acompaña con el choclo sancochado."
                    ),
                    clinicalNote = "El grano entero de choclo peruano tiene una matriz fibrosa de digestión lenta que evita picos nocturnos de glucosa mientras los 38 g de proteína protegen tu masa muscular."
                )
            )
        ),
        DayPlan(
            dayIndex = 2,
            dayName = "Miércoles",
            shortName = "Mié",
            optionLabel = "Opción 3 — Lic. Isabel Ríos",
            focusTag = "Betaglucanos, Omega-3 y Pescado Blanco",
            meals = listOf(
                Meal(
                    id = "mie_desayuno",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "1 Taza de avena con canela + 1/2 manzana, 1/2 plátano, 30 g arándanos, 1 cda chía + 2 huevos duros",
                    shortDesc = "Porridge alto en betaglucanos y Omega-3 con polifenoles de arándanos + 2 huevos duros.",
                    macros = Macros(kcal = 485, prot = 21, carb = 58, fat = 18, fiber = 11),
                    ingredients = listOf(
                        "40 g en crudo (4 cucharadas soperas) de Avena Hojuela Entera Grano de Oro",
                        "250 ml de Agua + 1 cucharadita de Canela en polvo + 2 gotas de Stevia",
                        "1 cucharada sopera (10 g) de Semillas de Chía Negra Ecoandino",
                        "1/2 unidad (65 g) de Manzana Israel picada en cubitos con cáscara",
                        "1/2 unidad (55 g) de Plátano de seda en rodajas",
                        "30 g de Arándanos frescos lavados",
                        "2 unidades (110 g) de Huevos Pardos Bell's duros (cocidos 9 min)"
                    ),
                    steps = listOf(
                        "ORDEN CLÍNICO ANTI-PICO DE INSULINA: Come PRIMERO los 2 huevos duros con una pizca de orégano antes de probar la avena con frutas.",
                        "En una olla pequeña, hierve los 40 g de avena en hojuelas con 250 ml de agua y canela durante 4 minutos revolviendo.",
                        "Apaga el fuego, agrega inmediatamente la cucharada (10 g) de semillas de chía para que forme su gel mucilaginoso, y decora encima con la media manzana, el medio plátano y los 30 g de arándanos.",
                        "Toma tu Irbesartán 150 mg al finalizar el desayuno."
                    ),
                    clinicalNote = "Comer primero los 2 huevos duros y sumar 10 g de chía a la avena reduce en un 38% la velocidad de absorción de las frutas, mientras las antocianinas de los arándanos mejoran directamente tu sensibilidad a la insulina (HOMA-IR)."
                ),
                Meal(
                    id = "mie_mm",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM en habitación 2x2 m",
                    title = "1 Mandarina W Murcott mediana en gajos",
                    shortDesc = "Vitamina C y naringenina hepatoprotectora antes de entrenar.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 unidad mediana (100 g) de Mandarina fresca en gajos (con su hollejo blanco)"
                    ),
                    steps = listOf(
                        "Pela la mandarina a las 10:30 AM y cómela en gajos conservando la fibra blanca que recubre cada gajo."
                    ),
                    clinicalNote = "El flavonoide naringenina de los cítricos activa la oxidación hepática de ácidos grasos y ayuda a reducir la transaminasa TGP (49.9 U/L)."
                ),
                Meal(
                    id = "mie_almuerzo",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática (14:20)",
                    title = "2 Tazas de Ensalada + Pescado Blanco al Vapor/Sudado (200 g) + 1 Camote + 1 Manzana",
                    shortDesc = "Filete de Tilapia/Basa bajo en purinas al kión y tomate + camote amarillo refrigerado + 2 tazas de ensalada.",
                    macros = Macros(kcal = 495, prot = 43, carb = 64, fat = 6, fiber = 9),
                    ingredients = listOf(
                        "200 g en crudo de Filete de Basa o Tilapia Blanca Bell's (pescado blanco bajo en purinas)",
                        "1 unidad mediana (160 g en crudo) de Camote Amarillo sancochado con cáscara y refrigerado 12 h",
                        "Sudado natural: 30 g de Cebolla roja en pluma, 40 g de Tomate en rodajas, 1 diente de ajo, 2 rodajas de kión (jengibre) y culantro fresco",
                        "Ensalada (2 tazas): 100 g de Col/Lechuga, 60 g de Vainitas cocidas al vapor al dente, 60 g de Pepinillo y jugo de 1 limón",
                        "1 unidad pequeña (110 g) de Manzana Israel con cáscara"
                    ),
                    steps = listOf(
                        "En una sartén con tapa, arma una cama con la cebolla en pluma, el tomate, el ajo y el kión; coloca encima los 200 g de filete de pescado blanco sazonado con limón y pimienta.",
                        "Agrega 1/4 de taza de agua, tapa y cocina al vapor/sudado a fuego medio por 7 minutos (cero aceite).",
                        "Come primero las 2 tazas de ensalada con vainitas al dente, luego el pescado sudado, y al final el camote y la manzana. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Elegimos pescado blanco (Basa/Tilapia) en lugar de pescados azules oscuros (bonito/caballa/anchoveta) porque contiene un 55% menos de purinas, protegiendo tu ácido úrico de 6.65 mg/dL."
                ),
                Meal(
                    id = "mie_mt",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 Vaso (180 ml) de Yogurt Gloria Slim 0%",
                    shortDesc = "Proteína ligera de alta digestibilidad y efecto uricosúrico.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt Gloria Slim Triple Zero"
                    ),
                    steps = listOf(
                        "Servir frío a las 16:30."
                    ),
                    clinicalNote = "Mantiene estable la saciedad vespertina evitando el picoteo nocturno."
                ),
                Meal(
                    id = "mie_cena",
                    dayIndex = 2,
                    dayName = "Miércoles",
                    optionLabel = "Opción 3 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00",
                    title = "Ensalada Fresca + 1 Tortilla Bimbo Rapidita Integral con Atún",
                    shortDesc = "Wrap en tortilla integral con 1 lata de atún en agua escurrido, tomate y lechuga.",
                    macros = Macros(kcal = 265, prot = 31, carb = 19, fat = 5, fiber = 5),
                    ingredients = listOf(
                        "1 unidad (30 g) de Tortilla Bimbo Rapidita Integral (congelar el resto del paquete para que dure semanas)",
                        "1 lata completa (120 g escurridos) de Filete de Atún en Agua Bell's (enjuagada 10 seg en colador)",
                        "1.5 tazas de Ensalada fresca: 80 g de Lechuga/Col picada, 60 g de Tomate en cubitos, 50 g de Pepinillo, 20 g de Cebolla roja y jugo de limón"
                    ),
                    steps = listOf(
                        "Calienta la Tortilla Rapidita Integral en sartén seca durante 25 segundos por lado.",
                        "Mezcla el atún desalado y escurrido con parte de la lechuga, tomate, cebolla y limón; arma tu wrap o taco y acompáñalo con el resto de la ensalada fresca en el plato."
                    ),
                    clinicalNote = "Una sola Tortilla Rapidita Integral aporta apenas 13 g de carbohidratos netos, permitiendo una cena rápida, saciante y con mínima respuesta de insulina antes de dormir."
                )
            )
        ),
        DayPlan(
            dayIndex = 3,
            dayName = "Jueves",
            shortName = "Jue",
            optionLabel = "Opción 4 — Lic. Isabel Ríos",
            focusTag = "Protocolo Especial de Control de Purinas",
            meals = listOf(
                Meal(
                    id = "jue_desayuno",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "Batido de fresa con leche light + 1 Pan integral con 40 g queso fresco light + 1 Mandarina",
                    shortDesc = "Batido proteico de fresa con leche light + sándwich de queso fresco light Bonlé (lavado) + mandarina.",
                    macros = Macros(kcal = 395, prot = 21, carb = 55, fat = 9, fiber = 7),
                    ingredients = listOf(
                        "100 g de Fresa entera congelada Bell's / ARO",
                        "60 ml de Leche Evaporada Light Bell's + 180 ml de agua + 3 gotas de Stevia",
                        "2 rebanadas (55 g) de Pan de Molde Integral Bell's tostado",
                        "40 g de Queso Fresco Light Bonlé (pasado 10 seg por agua fría para retirar sal superficial)",
                        "3 rodajas de Tomate fresco y orégano seco",
                        "1 unidad mediana (100 g) de Mandarina en gajos"
                    ),
                    steps = listOf(
                        "Enjuaga la tajada de 40 g de Queso Fresco Light bajo el caño, sécala con papel toalla y colócala en tu pan integral tostado con rodajas de tomate y abundante orégano.",
                        "Licúa los 100 g de fresas con los 60 ml de leche light, 180 ml de agua y stevia.",
                        "Come primero el pan con queso fresco (cuya caseína y calcio favorecen la eliminación de ácido úrico hoy que toca hígado en el almuerzo), luego el batido y la mandarina. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "El calcio y los péptidos del queso fresco light y la leche ayudan al túbulo renal a excretar uratos, preparando tu organismo para el almuerzo de la Opción 4."
                ),
                Meal(
                    id = "jue_mm",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM + tomar 500 ml de agua",
                    title = "1 Manzana Israel entera con cáscara",
                    shortDesc = "Fibra pectina y quercetina natural antes de tu entrenamiento.",
                    macros = Macros(kcal = 68, prot = 0, carb = 18, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 unidad mediana (130 g) de Manzana Israel con cáscara",
                        "500 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Come la manzana entera con cáscara a las 10:30 AM y bebe medio litro de agua antes de tu rutina."
                    ),
                    clinicalNote = "Mantener el flujo urinario alto hoy es fundamental para que el ácido úrico (6.65 mg/dL) no se eleve tras el almuerzo."
                ),
                Meal(
                    id = "jue_almuerzo",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol 2.5 mg + 1 vaso extra (350 ml) de Agua con Limón (Alcalinizante Renal)",
                    title = "2 Tazas de Ensalada + Hígado de Res Encebollado (160-180 g) + 1 Choclo + 1 Mandarina",
                    shortDesc = "Bistec de hígado sellado descartando el caldo de cocción por las purinas + cebolla roja rica en quercetina.",
                    macros = Macros(kcal = 510, prot = 46, carb = 58, fat = 8, fiber = 9),
                    ingredients = listOf(
                        "160 a 180 g en crudo de Hígado de Res fresco limpio de nervios",
                        "1 taza (140 g) de Choclo Desgranado Bell's sancochado",
                        "Encebollado Protector: 70 g de Cebolla roja en pluma gruesa, 50 g de Tomate en gajos, 1 diente de ajo, 1 cda de vinagre tinto/blanco, comino y orégano",
                        "Ensalada (2 tazas): 120 g de Pepinillo en rodajas, 80 g de Col/Lechuga, 40 g de Zanahoria cruda rallada y jugo de 1 limón sutil entero",
                        "1 unidad mediana (100 g) de Mandarina + 1 vaso grande (350 ml) de agua con el jugo de medio limón"
                    ),
                    steps = listOf(
                        "PROTOCOLO ESTRICTO ANTI-ÁCIDO ÚRICO: Marina el bistec de hígado con ajo, vinagre, comino y pimienta. Séllalo en sartén antiadherente caliente por 2 minutos por lado.",
                        "Retira el hígado a un plato y DESCARTA POR COMPLETO el líquido oscuro que soltó en la sartén (allí quedan disueltas gran parte de las purinas libres).",
                        "Limpia la sartén con papel toalla y saltea los 70 g de cebolla roja y 50 g de tomate con 2 cucharadas de agua y orégano por 2 minutos; sírvelos encima del hígado.",
                        "Come primero las 2 tazas de ensalada, luego el hígado encebollado, después el choclo y la mandarina, acompañando con el vaso extra de agua con limón. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Al descartar el caldo de cocción del hígado y combinarlo con 70 g de cebolla roja (quercetina que inhibe la xantina oxidasa) y citrato de limón, evitas que suba tu ácido úrico de 6.65 mg/dL."
                ),
                Meal(
                    id = "jue_mt",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Frutos Secos Naturales Sin Sal",
                    shortDesc = "Saciante vespertino rico en ácido oleico y magnesio.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal Villa Natura"
                    ),
                    steps = listOf(
                        "Pesar 20 g a las 16:30 y consumir con un vaso de agua."
                    ),
                    clinicalNote = "Aporta magnesio intracelular, un cofactor esencial para que el receptor de insulina funcione correctamente."
                ),
                Meal(
                    id = "jue_cena",
                    dayIndex = 3,
                    dayName = "Jueves",
                    optionLabel = "Opción 4 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00",
                    title = "Bowl de Ensalada de Verduras (2 tazas) con 1 Lata de Atún y 1 Papa en Cubos",
                    shortDesc = "Bowl fresco de 2 tazas de vegetales + 1 lata de atún en agua desalado + dados de papa refrigerada al limón.",
                    macros = Macros(kcal = 285, prot = 32, carb = 31, fat = 2, fiber = 5),
                    ingredients = listOf(
                        "1 lata completa (120 g escurridos) de Filete de Atún en Agua Bell's (enjuagada 10 seg en colador)",
                        "1 unidad mediana (130 g) de Papa Blanca Yungay sancochada, refrigerada 12 h y cortada en cubos",
                        "2 tazas de Verduras: 80 g de Pepinillo, 60 g de Tomate, 50 g de Vainitas cocidas al vapor, 60 g de Col/Lechuga",
                        "Jugo de 1 limón sutil, ajo en polvo, perejil/orégano y pimienta"
                    ),
                    steps = listOf(
                        "En un bowl amplio mezcla las 2 tazas de verduras con los cubos de papa fría y el atún previamente desalado en colador.",
                        "Aliña con jugo de limón recién exprimido, ajo en polvo y orégano."
                    ),
                    clinicalNote = "Cena limpia y alta en potasio vegetal para contrarrestar el sodio y mantener la presión arterial óptima durante el sueño."
                )
            )
        )
    )
}
