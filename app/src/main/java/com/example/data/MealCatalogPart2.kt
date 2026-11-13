package com.example.data

object ClinicalCatalog {
    private val daysViernesToDomingo: List<DayPlan> = listOf(
        DayPlan(
            dayIndex = 4,
            dayName = "Viernes",
            shortName = "Vie",
            optionLabel = "Opción 5 — Lic. Isabel Ríos",
            focusTag = "Granola Casera Sin Azúcar y Alta Saciedad",
            meals = listOf(
                Meal(
                    id = "vie_desayuno",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "Jugo de fresas con leche light con stevia + 1 Pan integral con pollo (80 g) y apio",
                    shortDesc = "Batido de fresa con leche light + sándwich integral de pechuga deshilachada con apio y yogur 0%.",
                    macros = Macros(kcal = 415, prot = 34, carb = 47, fat = 8, fiber = 7),
                    ingredients = listOf(
                        "100 g de Fresa entera congelada Bell's / ARO",
                        "60 ml de Leche Evaporada Light Bell's + 180 ml de agua + 3 gotas de Stevia",
                        "80 g de Pechuga de pollo sancochada y deshilachada",
                        "1 tallo grande (35 g) de Apio fresco picado en medias lunas muy finas",
                        "1 cucharada (15 g) de Yogurt Gloria Slim 0% + jugo de medio limón, orégano y pimienta",
                        "2 rebanadas (55 g) de Pan de Molde Integral Bell's tostado"
                    ),
                    steps = listOf(
                        "Mezcla los 80 g de pollo deshilachado con el apio picado, la cucharada de yogurt 0% (en reemplazo de mayonesa), gotas de limón y pimienta. Arma el sándwich en pan integral tostado.",
                        "Licúa las fresas con la leche light diluida y stevia.",
                        "Come primero el sándwich de pollo y apio y luego toma el batido de fresa. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "El apio aporta ftálidos naturales (como el 3-n-butilftálido) que relajan el músculo liso de las arterias, actuando en sinergia con tu Irbesartán de las 08:00 AM."
                ),
                Meal(
                    id = "vie_mm",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM en tu habitación de 2x2 m",
                    title = "1 Mandarina W Murcott entera",
                    shortDesc = "Hidratación y antioxidantes cítricos pre-entreno.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 unidad mediana (100 g) de Mandarina en gajos",
                        "400 ml de Agua pura"
                    ),
                    steps = listOf(
                        "Consumir a las 10:30 AM antes de entrenar."
                    ),
                    clinicalNote = "Aporta vitamina C, la cual compite favorablemente en el riñón para facilitar la excreción de ácido úrico."
                ),
                Meal(
                    id = "vie_almuerzo",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática (14:20)",
                    title = "2 Tazas de Ensalada + 1.5 Latas de Atún al Limón + 1 Camote al Horno + 1 Manzana",
                    shortDesc = "Zarza proteica de atún en agua Bell's con apio y cebolla + camote amarillo al horno + ensalada.",
                    macros = Macros(kcal = 530, prot = 46, carb = 68, fat = 5, fiber = 10),
                    ingredients = listOf(
                        "1.5 latas (180 g escurridos = 1 lata nueva + la 1/2 lata guardada del lunes) de Filete de Atún en Agua Bell's",
                        "1 unidad mediana (160 g en crudo) de Camote Amarillo cortado en rodajas o bastones con cáscara",
                        "Ensalada (2 tazas): 100 g de Col/Lechuga, 60 g de Tomate, 40 g de Cebolla roja en pluma lavada, 30 g de Apio picado, 50 g de Pepinillo y jugo de 1 limón sutil",
                        "1 unidad mediana (120 g) de Manzana Israel con cáscara"
                    ),
                    steps = listOf(
                        "Enjuaga el atún durante 10 segundos en colador bajo el chorro de agua para retirar el sodio.",
                        "Cocina las rodajas de camote en horno, freidora de aire o sartén antiadherente tapada a fuego bajo con una pizca de canela u orégano hasta que doren.",
                        "Come primero las 2 tazas de ensalada fresca con el atún al limón y apio, y termina con el camote al horno y la manzana. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "Al usar la media lata restante del lunes llegas a 46 g de proteína magra en el almuerzo post-entreno sin desperdiciar alimento ni presupuesto."
                ),
                Meal(
                    id = "vie_mt",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Frutos Secos Sin Sal",
                    shortDesc = "Grasas cardioprotectoras sin sodio.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal Villa Natura"
                    ),
                    steps = listOf(
                        "Consumir a las 16:30 con agua."
                    ),
                    clinicalNote = "Mantiene el colesterol LDL controlado gracias a sus fitoesteroles."
                ),
                Meal(
                    id = "vie_cena",
                    dayIndex = 4,
                    dayName = "Viernes",
                    optionLabel = "Opción 5 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00",
                    title = "1 Vaso Grande (250 ml) de Yogurt 0% + Granola Casera Sin Azúcar",
                    shortDesc = "Yogurt Gloria Slim 0% con 3 cdas de avena tostada en sartén con chía, canela, stevia y 10 g frutos secos.",
                    macros = Macros(kcal = 295, prot = 18, carb = 31, fat = 9, fiber = 6),
                    ingredients = listOf(
                        "250 ml de Yogurt Gloria Slim Triple Zero (0% grasa, 0% azúcar)",
                        "Granola Casera Sin Azúcar: 25 g (3 cdas) de tu Avena Grano de Oro + 5 g (1 cdta) de Chía Ecoandino + 10 g de tu Maní Natural picado + canela en polvo y 2 gotas de Stevia",
                        "(Opcional post-entreno): 2 claras de huevo duras aparte si deseas sumar +7 g de proteína pura"
                    ),
                    steps = listOf(
                        "TRUCO DE AHORRO Y SALUD: En una sartén seca antiadherente a fuego medio-bajo, tuesta durante 4 minutos los 25 g de avena en hojuelas, 5 g de chía y 10 g de maní picado con canela en polvo revolviendo constantemente hasta que quede crujiente.",
                        "Retira del fuego, deja enfriar 2 minutos para que gane crocancia y sírvelo encima de los 250 ml de Yogurt Gloria Slim 0% frío."
                    ),
                    clinicalNote = "Las granolas comerciales \"sin azúcar\" cuestan S/ 14.20 y suelen usar maltitol o aceites refinados; hacerla en 4 minutos con tu misma avena, chía y maní tiene menor carga glucémica y te ahorra S/ 14.20."
                )
            )
        ),
        DayPlan(
            dayIndex = 5,
            dayName = "Sábado",
            shortName = "Sáb",
            optionLabel = "Opción 6 — Lic. Isabel Ríos",
            focusTag = "Estofado Casero sin Aceite y Betaglucanos",
            meals = listOf(
                Meal(
                    id = "sab_desayuno",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "1 Taza de avena con canela + 1/2 manzana, 1/2 plátano, 30 g arándanos, 1 cda chía + 2 huevos duros",
                    shortDesc = "Porridge sensibilizador con chía y arándanos precedido por 2 huevos duros.",
                    macros = Macros(kcal = 485, prot = 21, carb = 58, fat = 18, fiber = 11),
                    ingredients = listOf(
                        "40 g en crudo de Avena Hojuela Entera Grano de Oro hervida en 250 ml de agua y canela",
                        "1 cucharada sopera (10 g) de Semillas de Chía Negra Ecoandino",
                        "1/2 Manzana Israel picada (65 g) + 1/2 Plátano en rodajas (55 g) + 30 g de Arándanos frescos",
                        "2 unidades (110 g) de Huevos Pardos Bell's duros"
                    ),
                    steps = listOf(
                        "Come primero los 2 huevos duros.",
                        "Hierve la avena 4 minutos con agua y canela, apaga el fuego, incorpora la cucharada de chía y sirve con la manzana, el medio plátano y los arándanos encima. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "Segundo día semanal de carga de betaglucanos de avena + colina de 2 yemas para seguir limpiando la grasa hepática (TGP 49.9 U/L)."
                ),
                Meal(
                    id = "sab_mm",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Entrenar entre 11:00 AM y 13:00 PM en tu habitación de 2x2 m",
                    title = "1 Mandarina W Murcott entera",
                    shortDesc = "Energía ligera antes de la sesión de sábado.",
                    macros = Macros(kcal = 50, prot = 1, carb = 12, fat = 0, fiber = 2),
                    ingredients = listOf(
                        "1 unidad mediana (100 g) de Mandarina en gajos"
                    ),
                    steps = listOf(
                        "Consumir en gajos enteros a las 10:30 AM antes de entrenar."
                    ),
                    clinicalNote = "Aporta flavonoides cítricos e hidratación celular."
                ),
                Meal(
                    id = "sab_almuerzo",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática (14:20)",
                    title = "2 Tazas de Ensalada + Estofado de Pollo sin Aceite (200 g) + 1 Taza de Arroz a la Jardinera + 1 Manzana",
                    shortDesc = "Estofado peruano de pechuga en salsa natural de tomate, zanahoria y laurel + arroz integral a la jardinera.",
                    macros = Macros(kcal = 560, prot = 53, carb = 66, fat = 7, fiber = 10),
                    ingredients = listOf(
                        "200 g en crudo de Pechuga de Pollo sin piel en trozos grandes",
                        "Salsa natural del estofado: 60 g de Tomate maduro licuado, 40 g de Cebolla roja picada, 1 diente de ajo, 30 g de Zanahoria en rodajas, 1 hoja de laurel, orégano y páprika",
                        "Arroz a la jardinera (1 taza): 50 g en crudo de Arroz Integral Bell's cocido con 30 g de Vainitas picadas, 20 g de Zanahoria en cubitos y 20 g de Choclo desgranado",
                        "Ensalada (2 tazas): 120 g de Col/Lechuga fresca + 80 g de Pepinillo en rodajas con jugo de 1 limón",
                        "1 unidad pequeña (110 g) de Manzana Israel"
                    ),
                    steps = listOf(
                        "En una olla antiadherente caliente sin aceite, sella los 200 g de pollo con ajo, comino y páprika por 2 minutos.",
                        "Agrega la cebolla picada, el tomate licuado, las rodajas de zanahoria, la hoja de laurel y 1/2 taza de agua. Tapa y cocina a fuego lento por 20 minutos hasta formar un jugo espeso natural.",
                        "Come primero las 2 tazas de ensalada fresca al limón, luego el estofado de pollo y al final la taza de arroz integral a la jardinera y la manzana. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "El licopeno del tomate cocido sin aceites refinados reduce la oxidación de las partículas de colesterol LDL, protegiendo tu endotelio vascular."
                ),
                Meal(
                    id = "sab_mt",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "1 Vaso (180 ml) de Yogurt Gloria Slim 0%",
                    shortDesc = "Colación proteica vespertina 0% azúcar.",
                    macros = Macros(kcal = 75, prot = 8, carb = 9, fat = 0, fiber = 0),
                    ingredients = listOf(
                        "1 vaso (180 ml) de Yogurt Gloria Slim Triple Zero"
                    ),
                    steps = listOf(
                        "Servir frío a las 16:30."
                    ),
                    clinicalNote = "Favorece la saciedad y el control del ácido úrico."
                ),
                Meal(
                    id = "sab_cena",
                    dayIndex = 5,
                    dayName = "Sábado",
                    optionLabel = "Opción 6 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de ventana nutricional a las 19:00",
                    title = "Ensalada de Tomate y Cebolla (1.5 tazas) + Pollo en Cuadritos (150 g) + 3/4 Taza de Choclo",
                    shortDesc = "Pollo salteado al ajo y orégano en cubos + ensalada fresca de tomate y cebolla + choclo.",
                    macros = Macros(kcal = 320, prot = 37, carb = 28, fat = 5, fiber = 4),
                    ingredients = listOf(
                        "150 g en crudo de Pechuga de Pollo cortada en cuadritos",
                        "1.5 tazas de Ensalada de Tomate: 150 g de Tomate en gajos + 30 g de Cebolla en pluma lavada + jugo de limón y orégano",
                        "3/4 de taza (100 g) de Choclo Desgranado Bell's sancochado",
                        "1 diente de ajo picado, comino y pimienta"
                    ),
                    steps = listOf(
                        "Saltea los 150 g de pollo en cuadritos en tu sartén antiadherente con ajo picado, orégano, gotas de limón y 1 cucharada de agua durante 6 minutos.",
                        "Sirve junto a la ensalada de tomate al orégano y el choclo sancochado."
                    ),
                    clinicalNote = "Cena ligera de rápida digestión que evita el reflujo y permite un sueño profundo reparador (clave para mantener tu cortisol AM en su óptimo 7.93 ug/dL)."
                )
            )
        ),
        DayPlan(
            dayIndex = 6,
            dayName = "Domingo",
            shortName = "Dom",
            optionLabel = "Opción 7 — Lic. Isabel Ríos",
            focusTag = "Lomo de Cerdo Magro y Pasta Al Dente",
            meals = listOf(
                Meal(
                    id = "dom_desayuno",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 — Lic. Isabel Ríos",
                    slot = MealSlot.DESAYUNO,
                    time = "08:00 AM",
                    slotLabel = "Desayuno",
                    medAlert = "Tomar Irbesartán 150 mg al terminar (08:15 AM) + 12 min caminata estática",
                    title = "1 Taza de leche light + 1 Pan con 30 g queso fresco y 1 lámina jamón de pavita + 2 Mandarinas",
                    shortDesc = "Sándwich mixto saludable de queso fresco light y jamón de pavita San Fernando + leche tibia + 2 mandarinas.",
                    macros = Macros(kcal = 420, prot = 25, carb = 56, fat = 8, fiber = 6),
                    ingredients = listOf(
                        "60 ml de Leche Evaporada Light Bell's + 180 ml de agua caliente con canela",
                        "2 rebanadas (55 g) de Pan de Molde Integral Bell's tostado",
                        "30 g de Queso Fresco Light Bonlé (enjuagado 10 seg en agua para bajar sodio)",
                        "1 lámina (20 g) de Jamón de Pavita San Fernando",
                        "2 unidades medianas (180 g) de Mandarina W Murcott en gajos"
                    ),
                    steps = listOf(
                        "Pasa la lámina de jamón de pavita 20 segundos por sartén seca y arma tu sándwich en el pan integral tostado junto con los 30 g de queso fresco light desalado y orégano.",
                        "Acompaña con la taza de leche tibia con canela y termina con las 2 mandarinas en gajos. Toma tu Irbesartán 150 mg."
                    ),
                    clinicalNote = "Al enjuagar el queso fresco y usar 1 lámina de jamón de pavita, disfrutas del desayuno dominical de la doctora manteniendo el sodio total del plato debajo de 400 mg."
                ),
                Meal(
                    id = "dom_mm",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_MANANA,
                    time = "10:30 AM",
                    slotLabel = "Pre-entreno",
                    medAlert = "Caminata recreativa o sesión de movilidad articular (11:00 AM)",
                    title = "1 Manzana Israel pequeña con cáscara",
                    shortDesc = "Pectina soluble antes del almuerzo dominical.",
                    macros = Macros(kcal = 60, prot = 0, carb = 15, fat = 0, fiber = 3),
                    ingredients = listOf(
                        "1 unidad pequeña (110 g) de Manzana Israel entera con cáscara"
                    ),
                    steps = listOf(
                        "Lavar y comer con cáscara a las 10:30 AM."
                    ),
                    clinicalNote = "Prepara el tránsito intestinal y reduce el apetito voraz antes del almuerzo con pasta."
                ),
                Meal(
                    id = "dom_almuerzo",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 — Lic. Isabel Ríos",
                    slot = MealSlot.ALMUERZO,
                    time = "14:00 (2:00 PM)",
                    slotLabel = "Almuerzo Principal",
                    medAlert = "Tomar Bisoprolol fumarato 2.5 mg al terminar + 15 min caminata suave (14:20)",
                    title = "2 Tazas de Ensalada + Lomo de Cerdo Magro (200 g) + 1 Taza de Fideos Al Dente + Fruta",
                    shortDesc = "Lomo de cerdo magro a la plancha + 1 taza de fideos al dente (8 min) con salsa de tomate casera + 30 g arándanos.",
                    macros = Macros(kcal = 575, prot = 51, carb = 62, fat = 11, fiber = 8),
                    ingredients = listOf(
                        "200 g en crudo de Lomo de Cerdo Magro Ternez (retirar cualquier borde de grasa blanca visible)",
                        "55 g en crudo de Spaghetti o Fideos Tornillo Bell's (cocidos estrictamente 8 minutos AL DENTE = 1 taza / 140 g cocidos)",
                        "Salsa de Tomate Casera: 70 g de Tomate picado, 40 g de Cebolla roja, 1 diente de ajo, orégano, albahaca y 1 cdta de vinagre",
                        "Ensalada (2 tazas OBLIGATORIAS ANTES DE LA PASTA): 100 g de Col/Lechuga, 60 g de Vainitas al vapor, 60 g de Pepinillo y jugo de 1 limón",
                        "30 g de Arándanos frescos (o 1 mandarina mediana)"
                    ),
                    steps = listOf(
                        "REGLA DE ORO PARA COMER FIDEOS CON INSULINA DE 39.0: Hierve los 55 g de fideos durante SOLO 8 MINUTOS para que queden firmes ('al dente'). Al dente su índice glucémico es bajo.",
                        "Sazona los 200 g de lomo de cerdo magro con ajo, vinagre, comino y orégano, y dóralos en sartén antiadherente sin aceite.",
                        "En la misma sartén saltea el tomate picado, cebolla y albahaca con 3 cucharadas de agua y baña tu taza de fideos.",
                        "ORDEN ESTRICTO: Come 1° las 2 tazas completas de ensalada con limón → 2° los 200 g de lomo de cerdo → 3° la taza de fideos al dente y los arándanos. Toma tu Bisoprolol 2.5 mg."
                    ),
                    clinicalNote = "El lomo de cerdo magro es rico en tiamina (Vitamina B1), cofactor indispensable para oxidar los carbohidratos de los fideos en la mitocondria sin convertirlos en triglicéridos hepáticos."
                ),
                Meal(
                    id = "dom_mt",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 — Lic. Isabel Ríos",
                    slot = MealSlot.MEDIA_TARDE,
                    time = "16:30 (4:30 PM)",
                    slotLabel = "Media Tarde",
                    medAlert = null,
                    title = "20 g de Frutos Secos Sin Sal",
                    shortDesc = "Aporte de grasas monoinsaturadas y saciedad de domingo.",
                    macros = Macros(kcal = 115, prot = 5, carb = 3, fat = 10, fiber = 2),
                    ingredients = listOf(
                        "20 g de Maní Tostado Natural Sin Sal Villa Natura"
                    ),
                    steps = listOf(
                        "Consumir 20 g a las 16:30 con agua."
                    ),
                    clinicalNote = "Cierra el aporte semanal de fitoesteroles reductores de LDL."
                ),
                Meal(
                    id = "dom_cena",
                    dayIndex = 6,
                    dayName = "Domingo",
                    optionLabel = "Opción 7 — Lic. Isabel Ríos",
                    slot = MealSlot.CENA,
                    time = "19:00 (7:00 PM)",
                    slotLabel = "Cena Ligera",
                    medAlert = "Cierre de semana nutricional a las 19:00",
                    title = "Ensalada Cocida Al Dente (1.5 tazas) + 1 Lata de Atún + 1/4 de Palta Fuerte (60 g)",
                    shortDesc = "Vainitas y zanahoria en bastones al vapor (6 min) + 1 lata de atún en agua + 60 g de palta al limón.",
                    macros = Macros(kcal = 310, prot = 31, carb = 16, fat = 13, fiber = 7),
                    ingredients = listOf(
                        "1 lata completa (120 g escurridos) de Filete de Atún en Agua Bell's (enjuagada 10 seg en colador)",
                        "1.5 tazas de Ensalada Cocida Al Dente: 100 g de Vainitas picadas + 80 g de Zanahoria en bastones cocidas al vapor por solo 6 minutos",
                        "1/4 de unidad mediana (60 g de pulpa limpia) de Palta Fuerte o Hass en láminas",
                        "Jugo de 1 limón sutil, orégano y pimienta negra"
                    ),
                    steps = listOf(
                        "Cocina al vapor las vainitas y los bastones de zanahoria durante SOLO 6 MINUTOS (deben quedar crujientes / al dente; nunca blandas ni sobrecocidas para no elevar su índice glucémico).",
                        "Pásalas por un chorro breve de agua fría para cortar la cocción y sírvelas con la lata de atún desalado encima y los 60 g de palta en láminas aliñadas con limón."
                    ),
                    clinicalNote = "Cena cetogénica suave de domingo (solo 9 g de carbohidratos netos) que deja la insulina basal en su nivel más bajo de toda la semana para arrancar el lunes oxidando grasa visceral."
                )
            )
        )
    )

    val days: List<DayPlan> = MealCatalogPart1.daysLunesToJueves + daysViernesToDomingo

    val allMealsFlat: List<Meal> = days.flatMap { it.meals }

    val biomarkers: List<BiomarkerTarget> = listOf(
        BiomarkerTarget(
            label = "Insulina Basal",
            valueText = "39.0",
            subUnit = "μU/mL",
            targetText = "Meta: < 9.0 μU/mL",
            tone = BiomarkerTone.AMBER
        ),
        BiomarkerTarget(
            label = "Índice HOMA-IR",
            valueText = "9.73",
            subUnit = "Gluc: 101",
            targetText = "Meta: < 1.8",
            tone = BiomarkerTone.AMBER
        ),
        BiomarkerTarget(
            label = "Hígado TGP (ALT)",
            valueText = "49.9",
            subUnit = "U/L",
            targetText = "Meta: < 30 U/L",
            tone = BiomarkerTone.ROSE
        ),
        BiomarkerTarget(
            label = "Ácido Úrico",
            valueText = "6.65",
            subUnit = "mg/dL",
            targetText = "Meta: < 5.5 mg/dL",
            tone = BiomarkerTone.ROSE
        ),
        BiomarkerTarget(
            label = "Colesterol LDL / HDL",
            valueText = "124 / 45.4",
            subUnit = "mg/dL",
            targetText = "Meta: LDL <100 | HDL >50",
            tone = BiomarkerTone.SKY
        ),
        BiomarkerTarget(
            label = "Relación Alb/Creat",
            valueText = "10.11",
            subUnit = "mg/g",
            targetText = "Normal (<30) • Creat 0.70",
            tone = BiomarkerTone.EMERALD
        )
    )

    val goldenRules: List<ClinicalGoldenRule> = listOf(
        ClinicalGoldenRule(
            title = "1° Fibra → 2° Proteína → 3° Carbohidrato",
            detail = "Come siempre las 2 tazas de ensalada o los huevos duros antes del arroz, papa, camote, avena o fideos para frenar los picos de insulina."
        ),
        ClinicalGoldenRule(
            title = "Desalado Renal en 10 Segundos",
            detail = "Enjuaga siempre el atún en agua y el queso fresco light bajo el caño para reducir hasta el 75% del sodio y potenciar tu Irbesartán 150 mg."
        ),
        ClinicalGoldenRule(
            title = "Protocolo Anti-Ácido Úrico (6.65 mg/dL)",
            detail = "Remoja las lentejas 12 h desechando el agua, descarta el caldo de cocción del hígado del jueves y usa jugo de limón diario como alcalinizante."
        ),
        ClinicalGoldenRule(
            title = "Almidón Resistente Refrigerado 12 h",
            detail = "Cocina con anticipación la papa, el camote y el arroz integral y refrigéralos 12 horas para reducir su impacto glucémico."
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
            appendLine("INGREDIENTES EXACTOS:")
            meal.ingredients.forEach { appendLine("• $it") }
            appendLine()
            appendLine("PREPARACIÓN PASO A PASO:")
            meal.steps.forEachIndexed { idx, step -> appendLine("${idx + 1}. $step") }
            appendLine()
            appendLine("NOTA CLÍNICA: ${meal.clinicalNote}")
        }.trim()
    }
}
