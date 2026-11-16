// Catálogo Clínico Completo y Lista de Compras Agora (Plaza Vea) — Lic. Isabel Ríos
window.PLAN_DATA = {
  financials: {
    week1Total: 264.31,
    weeklyReplenishment: 88.60,
    netWeeklyConsumed: 116.45
  },
  portionGuides: [
    {
      doctorRequest: "Pavita 200 g (Almuerzo Martes — Opción 2)",
      agoraProduct: "Carne Molida de Pavita SAN FERNANDO Paquete 500g",
      priceText: "S/ 10.90",
      homeInstruction: "Usas 200 g el martes (en 2 medallones/hamburguesas caseras a la plancha) y congelas 300 g para la semana siguiente (S/ 4.36/sem)."
    },
    {
      doctorRequest: "Pollo 200 g (Opciones 1, 2, 5 y 6)",
      agoraProduct: "Filete de Pechuga de Pollo SADIA Bolsa 1Kg",
      priceText: "S/ 14.90",
      homeInstruction: "Viene en filetes individuales listos para porcionar (usas 950–1,000 g exactos entre lunes, martes, viernes y sábado)."
    },
    {
      doctorRequest: "Pescado Blanco 200 g (Almuerzo Miércoles — Opción 3)",
      agoraProduct: "Filete de Basa BELL'S Congelado Bolsa 1Kg",
      priceText: "S/ 14.50",
      homeInstruction: "Trae 5 filetes blancos bajos en purinas. Usas 200 g el miércoles y tienes pescado para 5 semanas (S/ 2.90/sem)."
    },
    {
      doctorRequest: "Hígado de Res 180 g (Almuerzo Jueves — Opción 4)",
      agoraProduct: "Hígado de Res EL BUEN CORTE x kg (~1 kg)",
      priceText: "S/ 14.50",
      homeInstruction: "Al llegar el pedido, sepáralo en 5 bolsas de 200 g en el congelador. Te dura 5 jueves (S/ 2.90/sem)."
    },
    {
      doctorRequest: "Lomo de Cerdo 200 g (Almuerzo Domingo — Opción 7)",
      agoraProduct: "Lomito Saltado de Cerdo REDONDOS Bandeja 620g",
      priceText: "S/ 19.90",
      homeInstruction: "La bandeja de 620 g de lomo magro te rinde 3 domingos exactos de 200 g (S/ 6.63/sem)."
    },
    {
      doctorRequest: "Queso Fresco (Opciones 4 y 7)",
      agoraProduct: "Queso Fresco BELL'S Paquete 300g",
      priceText: "S/ 9.90",
      homeInstruction: "Empaque cerrado de 300 g. Usas 70 g por semana (40 g jueves + 30 g domingo); rinde 3 semanas (S/ 3.30/sem)."
    }
  ],
  biomarkers: [
    { id: "insulina", label: "Insulina Basal", defaultValueText: "39.0", subUnit: "μU/mL", targetText: "Meta: < 9.0 μU/mL", tone: "amber" },
    { id: "homa", label: "Índice HOMA-IR", defaultValueText: "9.73", subUnit: "Gluc: 101", targetText: "Meta: < 1.8", tone: "amber" },
    { id: "tgp", label: "Hígado TGP (ALT)", defaultValueText: "49.9", subUnit: "U/L", targetText: "Meta: < 30 U/L", tone: "rose" },
    { id: "urico", label: "Ácido Úrico", defaultValueText: "6.65", subUnit: "mg/dL", targetText: "Meta: < 5.5 mg/dL", tone: "rose" },
    { id: "lipidos", label: "Colesterol LDL / HDL", defaultValueText: "124 / 45.4", subUnit: "mg/dL", targetText: "Meta: LDL <100 | HDL >50", tone: "sky" },
    { id: "renal", label: "Relación Alb/Creat", defaultValueText: "10.11", subUnit: "mg/g", targetText: "Normal (<30) • Creat 0.70", tone: "emerald" }
  ],
  goldenRules: [
    {
      title: "1° Ensalada (2 tazas) → 2° Proteína (200 g) → 3° Carbohidrato",
      detail: "En todos tus almuerzos de las 14:00 PM come obligatoriamente primero las 2 tazas de ensalada fresca y en los desayunos de avena come primero los 2 huevos duros (reduce el pico glucémico en un 38%)."
    },
    {
      title: "Cero Aceites de Soya, Maíz o Girasol",
      detail: "Todos los almuerzos se cocinan en sartén u olla antiadherente con agua, ajo, cebolla, limón y especias para revertir tu TGP de 49.9 U/L y bajar el LDL de 124 mg/dL."
    },
    {
      title: "Protocolo Anti-Ácido Úrico y Sodio Renal",
      detail: "Enjuaga 10 s el atún y el queso fresco (retira 75% de sodio), remoja las lentejas 12 h desechando el agua y descarta el caldo oscuro al sellar el hígado del jueves."
    },
    {
      title: "Descanso Insulínico Nocturno de 13 Horas (19:00 a 08:00)",
      detail: "Cierra la ingesta calórica a las 19:00 PM y refrigera 12 h antes la papa, el camote y el arroz integral para formar almidón resistente tipo 3."
    }
  ],
  days: [
    {
      dayIndex: 0,
      dayName: "Lunes",
      shortName: "Lun",
      optionLabel: "Opción 1 de la Doctora",
      focusTag: "Desinflamación e Inicio Semanal",
      nightPrepReminder: "Para mañana Martes: Deja en remojo 65 g de Lenteja Superior BELL'S en agua por 12 h (desechar el agua mañana para eliminar purinas) y guarda en táper los 70 g extra de pechuga SADIA cocida hoy.",
      meals: [
        {
          id: "lun_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg inmediatamente al terminar + 12 min caminata estática",
          title: "Jugo de fresas con leche light con stevia + 1 pan con atún con tomate + 1 huevo duro",
          shortDesc: "1 Huevo Pardo BELL'S duro + sándwich integral con 1/2 lata de atún BELL'S desalado + licuado de 100 g fresa con leche light.",
          macros: { kcal: 465, prot: 37, carb: 46, fat: 11, fiber: 7 },
          ingredients: [
            "1/2 lata (60 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g (guardar la otra mitad en táper para el viernes)",
            "60 g de Tomate redondo en cubitos + jugo de 1/2 limón y orégano",
            "2 rebanadas (55 g) de Pan de Molde Integral BELL'S tostado",
            "1 Huevo Pardo BELL'S duro (cocido 9 min)",
            "100 g de Fresa Entera Congelada BELL'S",
            "60 ml de Leche Light GLORIA/BELL'S + 180 ml de agua y 3 gotas de stevia"
          ],
          steps: [
            "Enjuaga durante 10 segundos en un colador 1/2 lata (60 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g (retira el 75% del sodio; guarda la otra mitad en táper para el viernes).",
            "Mézclalo con 60 g de tomate redondo en cubitos, jugo de 1/2 limón y orégano sobre 2 rebanadas (55 g) de Pan de Molde Integral BELL'S tostado.",
            "ORDEN CLÍNICO: Come primero 1 Huevo Pardo BELL'S duro (cocido 9 min) y el sándwich; al final bebe el licuado de 100 g de Fresa Entera Congelada BELL'S + 60 ml de Leche Light GLORIA/BELL'S + 180 ml de agua y 3 gotas de stevia.",
            "Toma tu Irbesartán 150 mg al terminar y realiza 12 minutos de caminata estática en tu habitación."
          ],
          clinicalNote: "El huevo duro aporta colina hepatoprotectora para reducir tu TGP de 49.9 U/L, y enjuagar el atún 10 segundos retira el 75% del sodio potenciando el Irbesartán 150 mg.",
          timers: [
            { label: "Huevo duro (9 min)", durationSeconds: 540 },
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "lun_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM (Valle del Bisoprolol • RPE 6–8/10)",
          title: "1 unidad mediana (130 g) de Manzana Israel con cáscara + 400 ml de agua pura",
          shortDesc: "Fruta entera de bajo índice glucémico e hidratación previa al entrenamiento en habitación.",
          macros: { kcal: 68, prot: 0, carb: 18, fat: 0, fiber: 3 },
          ingredients: [
            "1 unidad mediana (130 g) de Manzana Israel fresca con cáscara",
            "400 ml de Agua pura"
          ],
          steps: [
            "Lava bien la Manzana Israel y cómela entera conservando toda su cáscara a las 10:30 AM.",
            "Bebe los 400 ml de agua pura antes de entrenar en tu espacio de 2x2 m entre las 11:00 AM y las 13:00 PM (regulando el esfuerzo por Escala RPE 6–8/10 y Test del Habla)."
          ],
          clinicalNote: "La pectina de la cáscara de manzana entrega energía sostenida sin elevar la insulina basal (39.0 μU/mL).",
          timers: []
        },
        {
          id: "lun_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
          title: "Pollo a las Hierbas (200 g) + 1 Taza de Arroz Integral + 2 Tazas de Ensalada + 1 Mandarina",
          shortDesc: "Filete de Pechuga SADIA al vapor/sartén sin aceite + arroz integral BELL'S refrigerado 12 h + 2 tazas de ensalada.",
          macros: { kcal: 545, prot: 52, carb: 61, fat: 7, fiber: 8 },
          ingredients: [
            "200 g en crudo de Filete de Pechuga de Pollo SADIA (cocina 70 g extra para el pan del martes)",
            "55 g en crudo de Arroz Integral BELL'S (hervido y refrigerado 12 h antes = 1 taza / 150 g cocido)",
            "Ensalada (2 tazas): 100 g de Lechuga Americana, 80 g de Pepinillo con cáscara, 60 g de Tomate Redondo, jugo de 1 Limón Tahití/Sutil (20 ml)",
            "Aderezo: 1 diente de ajo chancado, 1 cdta de mostaza, comino, orégano y 1 pizca de sal",
            "Postre: 1 Mandarina W Murcott (100 g)"
          ],
          steps: [
            "Marina el filete de pechuga SADIA 10 min con ajo chancado, mostaza, limón, comino y orégano.",
            "Cocínalo en sartén antiadherente a fuego medio con 2 cucharadas de agua y tapado (4 min por lado, cero aceite vegetal).",
            "ORDEN DE INGESTA OBLIGATORIO: Come 1° las 2 tazas de ensalada, 2° los 200 g de pollo y 3° la taza de arroz integral recalentado y la mandarina.",
            "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
          ],
          clinicalNote: "Cocinar sin aceite de soya/maíz/girasol y comer las 2 tazas de ensalada antes del arroz reduce el pico glucémico y ayuda a revertir tu TGP de 49.9 U/L.",
          timers: [
            { label: "Pollo lado 1 (4 min)", durationSeconds: 240 },
            { label: "Pollo lado 2 (4 min)", durationSeconds: 240 },
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "lun_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0% frío con 1/2 cdta de canela en polvo",
          shortDesc: "Colación proteica 0% grasa y 0% azúcar que favorece la excreción renal de ácido úrico.",
          macros: { kcal: 75, prot: 8, carb: 9, fat: 0, fiber: 0 },
          ingredients: [
            "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0% frío",
            "1/2 cucharadita de Canela en polvo"
          ],
          steps: [
            "Sirve los 180 ml de Yogurt GLORIA Slim Triple Zero 0% frío a las 16:30 y espolvorea media cucharadita de canela en polvo."
          ],
          clinicalNote: "Los péptidos lácteos desnatados sin azúcar facilitan la eliminación renal de uratos (bajando tu ácido úrico de 6.65 mg/dL).",
          timers: []
        },
        {
          id: "lun_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00 (13 horas de descanso insulínico nocturno hasta las 08:00 AM)",
          title: "1 Lata de Atún + 1 Papa sancochada (Almidón Resistente Tipo 3)",
          shortDesc: "1 lata de Filete de Atún en Agua BELL'S desalada al limón con cebolla roja + 1 Papa Blanca Yungay refrigerada 12 h.",
          macros: { kcal: 275, prot: 31, carb: 32, fat: 2, fiber: 4 },
          ingredients: [
            "1 lata completa (100–120 g escurridos) de Filete de Atún en Agua BELL'S Lata 150g",
            "30 g de Cebolla roja picada fina, jugo de 1/2 limón, orégano y pimienta",
            "1 unidad mediana (150 g) de Papa Blanca Yungay sancochada con cáscara y refrigerada 12 h antes"
          ],
          steps: [
            "Abre 1 lata completa (100–120 g escurridos) de Filete de Atún en Agua BELL'S, enjuágala en colador por 10 seg para retirar el sodio.",
            "Mézclala con 30 g de cebolla roja picada fina, jugo de 1/2 limón, orégano y pimienta.",
            "Sirve con 1 unidad mediana (150 g) de Papa Blanca Yungay sancochada con cáscara y refrigerada 12 h antes (almidón resistente tipo 3)."
          ],
          clinicalNote: "Cerrar la ingesta a las 19:00 con almidón resistente tipo 3 otorga 13 horas de descanso insulínico nocturno para revertir el HOMA-IR de 9.73.",
          timers: []
        }
      ]
    },
    {
      dayIndex: 1,
      dayName: "Martes",
      shortName: "Mar",
      optionLabel: "Opción 2 de la Doctora",
      focusTag: "Fibra Soluble y Reducción de LDL",
      nightPrepReminder: "Para mañana Miércoles: Sancocha con cáscara 160 g de Camote Amarillo Procesado PLAZA VEA y déjalo refrigerando 12 h. Pasa 1 filete (200 g) de Basa BELL'S del congelador al refrigerador.",
      meals: [
        {
          id: "mar_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "1 Taza de leche light/sin lactosa + 2 mandarinas + 1 pan con pollo",
          shortDesc: "Sándwich en Pan Integral BELL'S con 70 g de pechuga SADIA deshilachada, apio y Yogurt Slim 0% + leche tibia con canela + 2 mandarinas.",
          macros: { kcal: 440, prot: 32, carb: 56, fat: 8, fiber: 7 },
          ingredients: [
            "70 g de Pechuga de Pollo SADIA cocida y deshilachada (separada del lunes)",
            "20 g de Apio picado + 1 cda (15 g) de Yogurt Gloria Slim 0% (en vez de mayonesa), limón y pimienta",
            "2 rebanadas de Pan Integral BELL'S tostado",
            "1 taza de leche tibia con canela (60 ml de Leche Light GLORIA + 180 ml de agua)",
            "2 unidades (180 g) de Mandarina W Murcott en gajos enteros"
          ],
          steps: [
            "Mezcla 70 g de pechuga de pollo SADIA cocida y deshilachada (separada del lunes) con 20 g de apio picado, 1 cda (15 g) de Yogurt Gloria Slim 0% (en vez de mayonesa), limón y pimienta dentro de 2 rebanadas de Pan Integral BELL'S.",
            "Acompaña con 1 taza de leche tibia con canela (60 ml de Leche Light + 180 ml de agua).",
            "Termina con 2 unidades (180 g) de Mandarina W Murcott en gajos enteros. Toma tu Irbesartán 150 mg."
          ],
          clinicalNote: "Reemplazar la mayonesa por Yogurt Gloria Slim 0% al limón evita grasas trans/omega-6 proinflamatorias y cuida tu perfil lipídico.",
          timers: [
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "mar_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar en espacio de 2x2 m entre 11:00 AM y 13:00 PM",
          title: "1/2 unidad (60 g) de Plátano de Seda no muy maduro + 400 ml de agua",
          shortDesc: "Energía pre-entreno con almidón resistente y potasio natural.",
          macros: { kcal: 55, prot: 1, carb: 14, fat: 0, fiber: 2 },
          ingredients: [
            "1/2 unidad (60 g) de Plátano de Seda no muy maduro",
            "400 ml de Agua pura"
          ],
          steps: [
            "Consume 1/2 unidad (60 g) de Plátano de Seda no muy maduro con 400 ml de agua a las 10:30 AM antes de tu sesión en habitación."
          ],
          clinicalNote: "El plátano pintón aporta potasio para la función muscular manteniendo bajo el índice glucémico.",
          timers: []
        },
        {
          id: "mar_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
          title: "Medallones Caseros de Pavita (200 g) + 1 Taza de Lentejas + 2 Tazas de Ensalada + 1 Mandarina",
          shortDesc: "2 medallones caseros de Carne Molida de Pavita SAN FERNANDO a la plancha + lentejas BELL'S despurinizadas + 2 tazas de ensalada.",
          macros: { kcal: 585, prot: 61, carb: 64, fat: 6, fiber: 15 },
          ingredients: [
            "200 g en crudo de Carne Molida de Pavita SAN FERNANDO (Paquete 500g; congelar los 300 g restantes)",
            "65 g en crudo de Lenteja Superior BELL'S (remojada 12 h en agua que se desecha para eliminar purinas = 1 taza / 180 g cocida)",
            "Sofrito al agua de lentejas: 30 g de cebolla roja, 1 diente de ajo, 20 g de zanahoria en cubitos, laurel y comino",
            "Ensalada (2 tazas): 120 g de lechuga americana, 70 g de tomate, 50 g de pepinillo y jugo de 1 limón",
            "Postre: 1 Mandarina W Murcott (100 g)"
          ],
          steps: [
            "Desecha el agua de remojo de 12 h de las lentejas y hierve los 65 g en agua limpia con cebolla, ajo, zanahoria en cubitos, laurel y comino por 20 minutos.",
            "Sazona los 200 g de carne molida de pavita SAN FERNANDO con ajo picado, perejil/orégano, comino y pimienta; forma 2 medallones gruesos tipo hamburguesa y dóralos en sartén antiadherente 4 min por lado sin aceite.",
            "ORDEN CLÍNICO: Come 1° las 2 tazas de ensalada, 2° los medallones de pavita y 3° la taza de lentejas y la mandarina. Toma tu Bisoprolol 2.5 mg."
          ],
          clinicalNote: "Sus 15 g de fibra soluble atrapan sales biliares de colesterol en el intestino para reducir directamente tu LDL de 124 mg/dL a <100 mg/dL.",
          timers: [
            { label: "Cocción lentejas (20 min)", durationSeconds: 1200 },
            { label: "Medallones pavita (4 min/lado)", durationSeconds: 240 },
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "mar_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "20 g de Maní Tostado Natural Sin Sal VILLA NATURA pesado en balanza",
          shortDesc: "Grasas monoinsaturadas cardioprotectoras para elevar el colesterol HDL (45.4 mg/dL).",
          macros: { kcal: 115, prot: 5, carb: 3, fat: 10, fiber: 2 },
          ingredients: [
            "20 g de Maní Tostado Natural Sin Sal VILLA NATURA pesado en balanza"
          ],
          steps: [
            "Pesa exactamente 20 g en tu balanza de cocina a las 16:30 y acompáñalos con un vaso grande de agua."
          ],
          clinicalNote: "El ácido oleico sin sal añadida eleva el colesterol protector HDL sin estimular la insulina.",
          timers: []
        },
        {
          id: "mar_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00",
          title: "Ensalada fresca (1.5 tazas) + Pollo a la plancha (150 g) + 1 Choclo",
          shortDesc: "150 g de Filete de Pechuga SADIA a la plancha sin aceite + 1.5 tazas de ensalada + 1 taza de Choclo BELL'S.",
          macros: { kcal: 335, prot: 38, carb: 31, fat: 5, fiber: 5 },
          ingredients: [
            "150 g de Filete de Pechuga de Pollo SADIA sazonado con ajo, limón y orégano",
            "1.5 tazas de ensalada (80 g lechuga americana, 70 g pepinillo, 50 g tomate)",
            "1 taza (120 g) de Choclo Desgranado BELL'S sancochado con anís"
          ],
          steps: [
            "Cocina en sartén antiadherente sin aceite los 150 g de Filete de Pechuga de Pollo SADIA sazonado con ajo, limón y orégano.",
            "Acompaña primero con las 1.5 tazas de ensalada fresca y luego con 1 taza (120 g) de Choclo Desgranado BELL'S sancochado con anís."
          ],
          clinicalNote: "Cena magra de digestión limpia que protege la masa muscular mientras inicia el ayuno nocturno de 13 horas.",
          timers: []
        }
      ]
    },
    {
      dayIndex: 2,
      dayName: "Miércoles",
      shortName: "Mié",
      optionLabel: "Opción 3 de la Doctora",
      focusTag: "Betaglucanos, Chía y Pescado Blanco",
      nightPrepReminder: "Para mañana Jueves: Pasa 1 porción (180–200 g) de Hígado de Res EL BUEN CORTE al refrigerador y deja sancochada y refrigerando 1 Papa Blanca Yungay mediana (130 g) para la cena del jueves.",
      meals: [
        {
          id: "mie_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "1 Taza de avena con canela + manzana, 1/2 plátano, arándanos, 1 cda chía + 2 huevos duros",
          shortDesc: "Come primero los 2 Huevos Pardos BELL'S duros y luego el porridge de 40 g Avena con 10 g Chía, frutas y 30 g Blueberries BELL'S.",
          macros: { kcal: 485, prot: 21, carb: 58, fat: 18, fiber: 11 },
          ingredients: [
            "2 Huevos Pardos BELL'S duros (comer primero)",
            "40 g de Avena GRANO DE ORO / 3 OSITOS hervida 4 min en 250 ml de agua con canela",
            "1 cda (10 g) de Chía Negra ECOANDINO",
            "1/2 Manzana Israel (65 g) en cubos + 1/2 Plátano de seda (55 g)",
            "30 g de Blueberries (Arándanos) BELL'S FRESCOS"
          ],
          steps: [
            "ORDEN CLÍNICO: Come primero los 2 Huevos Pardos BELL'S duros (frena el pico glucémico matutino en un 38%).",
            "Luego consume tu porridge hecho hirviendo 4 min 40 g de Avena GRANO DE ORO / 3 OSITOS en 250 ml de agua con canela.",
            "Al apagar el fuego añade 1 cda (10 g) de Chía ECOANDINO, 1/2 Manzana Israel (65 g) en cubos, 1/2 Plátano de seda (55 g) y 30 g de Blueberries BELL'S FRESCOS.",
            "Toma tu Irbesartán 150 mg al terminar."
          ],
          clinicalNote: "Los betaglucanos de la avena más el gel soluble de la chía y las antocianinas de los arándanos mejoran la sensibilidad a la insulina (HOMA-IR).",
          timers: [
            { label: "Hervor avena (4 min)", durationSeconds: 240 },
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "mie_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar en espacio de 2x2 m entre 11:00 AM y 13:00 PM",
          title: "1 unidad mediana (100 g) de Mandarina W Murcott en gajos",
          shortDesc: "Vitamina C y naringenina cítrica antes de tu entrenamiento.",
          macros: { kcal: 50, prot: 1, carb: 12, fat: 0, fiber: 2 },
          ingredients: [
            "1 unidad mediana (100 g) de Mandarina W Murcott en gajos"
          ],
          steps: [
            "Consume la mandarina en gajos enteros conservando el hollejo blanco a las 10:30 AM."
          ],
          clinicalNote: "Favorece la oxidación hepática de ácidos grasos y aporta hidratación pre-entreno.",
          timers: []
        },
        {
          id: "mie_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
          title: "Filete de Basa al Vapor/Sudado (200 g) + 1 Camote + 2 Tazas de Ensalada + 1 Manzana",
          shortDesc: "200 g Filete de Basa BELL'S al vapor 7 min sobre cama de cebolla y tomate + 160 g camote refrigerado + 2 tazas de ensalada.",
          macros: { kcal: 495, prot: 43, carb: 64, fat: 6, fiber: 9 },
          ingredients: [
            "200 g de Filete de Basa BELL'S (Bolsa 1Kg) descongelado",
            "160 g de Camote Amarillo Procesado PLAZA VEA sancochado con cáscara y refrigerado 12 h",
            "Cama de sudado: 30 g de cebolla roja en pluma, 40 g de tomate en rodajas, 1 diente de ajo, orégano y limón",
            "Ensalada (2 tazas): 100 g de lechuga americana, 60 g de Vainita Americana al vapor al dente, 60 g de pepinillo y limón",
            "Postre: 1 Manzana Israel pequeña (110 g)"
          ],
          steps: [
            "Coloca el filete de basa BELL'S sobre la cama de cebolla, tomate y ajo en una sartén con 1/4 taza de agua; tapa y cocina al vapor 7 minutos (cero aceite).",
            "Come 1° las 2 tazas de ensalada con vainitas al dente, 2° el filete de basa sudado y 3° el camote amarillo y la manzana.",
            "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
          ],
          clinicalNote: "El pescado blanco (Basa) tiene 55% menos purinas que el bonito o caballa, protegiendo tu ácido úrico (6.65 mg/dL).",
          timers: [
            { label: "Basa al vapor (7 min)", durationSeconds: 420 },
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "mie_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%",
          shortDesc: "Proteína ligera de media tarde sin grasa ni azúcar.",
          macros: { kcal: 75, prot: 8, carb: 9, fat: 0, fiber: 0 },
          ingredients: [
            "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%"
          ],
          steps: [
            "Servir frío a las 16:30."
          ],
          clinicalNote: "Mantiene la saciedad vespertina y favorece la excreción renal de ácido úrico.",
          timers: []
        },
        {
          id: "mie_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00",
          title: "Ensalada + 1 Tortilla Rapidita Integral con Atún",
          shortDesc: "1 Tortilla BIMBO Rapidita Integral rellena con 1 lata de Atún en Agua BELL'S desalada + 1 taza adicional de ensalada fresca.",
          macros: { kcal: 265, prot: 31, carb: 19, fat: 5, fiber: 5 },
          ingredients: [
            "1 Tortilla BIMBO Rapidita Integral (congelar las 9 restantes de la bolsa)",
            "1 lata (100–120 g escurridos) de Filete de Atún en Agua BELL'S (enjuagada en colador)",
            "Lechuga americana picada, tomate y limón + 1 taza adicional de ensalada fresca al lado"
          ],
          steps: [
            "Calienta 25 seg por lado 1 Tortilla BIMBO Rapidita Integral en sartén seca.",
            "Rellénala con 1 lata (100–120 g escurridos) de Filete de Atún en Agua BELL'S (enjuagada en colador), lechuga americana picada, tomate y limón, más 1 taza adicional de ensalada fresca al lado."
          ],
          clinicalNote: "Aporta apenas 13 g de carbohidratos netos con 31 g de proteína magra para optimizar la sensibilidad insulínica nocturna.",
          timers: []
        }
      ]
    },
    {
      dayIndex: 3,
      dayName: "Jueves",
      shortName: "Jue",
      optionLabel: "Opción 4 de la Doctora",
      focusTag: "Protocolo Anti-Ácido Úrico",
      nightPrepReminder: "Para mañana Viernes: Deja listos 80 g de Filete de Pechuga SADIA cocida y deshilachada para el pan del desayuno del viernes, y verifica la 1/2 lata de atún reservada del lunes.",
      meals: [
        {
          id: "jue_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "Batido de fresa con leche + 1 Pan con queso fresco + 1 Mandarina",
          shortDesc: "Sándwich en Pan Integral BELL'S con 40 g de Queso Fresco BELL'S desalado + licuado de 100 g fresa con leche light + 1 mandarina.",
          macros: { kcal: 395, prot: 21, carb: 55, fat: 9, fiber: 7 },
          ingredients: [
            "1 tajada de 40 g de Queso Fresco BELL'S (Paquete 300g) pasada 10 seg por agua fría",
            "2 rebanadas de Pan Integral BELL'S tostado + rodajas de tomate y orégano",
            "100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia",
            "1 Mandarina W Murcott mediana (100 g)"
          ],
          steps: [
            "Pasa por agua fría durante 10 seg 1 tajada de 40 g de Queso Fresco BELL'S (Paquete 300g) y arma tu sándwich con rodajas de tomate y orégano en 2 rebanadas de Pan Integral BELL'S tostado.",
            "Licúa 100 g de Fresa Congelada BELL'S con 60 ml de Leche Light, 180 ml de agua y stevia.",
            "Come primero el sándwich de queso, luego el batido y cierra con 1 Mandarina mediana. Toma tu Irbesartán 150 mg."
          ],
          clinicalNote: "El calcio y los péptidos lácteos del queso fresco BELL'S y la leche preparan al riñón para excretar uratos hoy que toca hígado en el almuerzo.",
          timers: [
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "jue_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar entre 11:00 AM y 13:00 PM + beber 500 ml de agua",
          title: "1 Manzana Israel mediana (130 g) con cáscara + 500 ml de agua",
          shortDesc: "Quercetina natural e hidratación reforzada en el día de control de purinas.",
          macros: { kcal: 68, prot: 0, carb: 18, fat: 0, fiber: 3 },
          ingredients: [
            "1 Manzana Israel mediana (130 g) con cáscara",
            "500 ml de Agua pura"
          ],
          steps: [
            "Consume la manzana entera con cáscara a las 10:30 AM acompañada de 500 ml de agua antes de tu rutina."
          ],
          clinicalNote: "Mantener alto el volumen urinario diluye el ácido úrico sérico (6.65 mg/dL).",
          timers: []
        },
        {
          id: "jue_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol 2.5 mg + 350 ml de agua con medio limón (Alcalinizante Renal)",
          title: "Hígado de Res Encebollado Despurinizado (180 g) + 1 Choclo + 2 Tazas de Ensalada + 1 Mandarina",
          shortDesc: "180 g Hígado EL BUEN CORTE sellado descartando el jugo oscuro + encebollado rico en quercetina + 1 taza de choclo + ensalada.",
          macros: { kcal: 510, prot: 46, carb: 58, fat: 8, fiber: 9 },
          ingredients: [
            "180 g de Hígado de Res EL BUEN CORTE",
            "1 taza (140 g) de Choclo Desgranado BELL'S sancochado",
            "Encebollado rico en quercetina: 70 g de cebolla roja en pluma gruesa, 50 g de tomate en gajos, 1 diente de ajo, 1 cda de vinagre, comino y orégano",
            "Ensalada (2 tazas): 120 g de pepinillo, 80 g de lechuga americana, 40 g de zanahoria cruda rallada y jugo de 1 limón",
            "Postre: 1 Mandarina + 350 ml de agua con medio limón"
          ],
          steps: [
            "PREPARACIÓN ANTI-ÁCIDO ÚRICO: Sella el hígado en sartén caliente 2 min por lado, retíralo al plato y DESCARTA POR COMPLETO el jugo oscuro que soltó en la sartén (allí se concentran las purinas hidrosolubles).",
            "En la sartén limpia saltea con 2 cdas de agua los 70 g de cebolla roja y el tomate por 2 min y sírvelos encima del hígado.",
            "Come 1° las 2 tazas de ensalada, 2° el hígado encebollado y 3° el choclo y la mandarina, bebiendo los 350 ml de agua con medio limón. Toma tu Bisoprolol 2.5 mg."
          ],
          clinicalNote: "Descartar el caldo de cocción del hígado y combinarlo con 70 g de cebolla roja (quercetina inhibidora de la xantina oxidasa) y citrato de limón protege tu ácido úrico.",
          timers: [
            { label: "Sellado hígado (2 min/lado)", durationSeconds: 120 },
            { label: "Salteado cebolla (2 min)", durationSeconds: 120 },
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "jue_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
          shortDesc: "Grasas saludables y magnesio intracelular sin sodio.",
          macros: { kcal: 115, prot: 5, carb: 3, fat: 10, fiber: 2 },
          ingredients: [
            "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
          ],
          steps: [
            "Pesar 20 g en balanza y consumir a las 16:30 con agua."
          ],
          clinicalNote: "Aporta saciedad sin elevar la glucosa ni el ácido úrico.",
          timers: []
        },
        {
          id: "jue_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00",
          title: "Ensalada de verduras (2 tazas) con 1 Lata de Atún y 1 Papa en cubos",
          shortDesc: "Bowl de pepinillo, tomate, vainitas al vapor, lechuga americana, 1 Papa Yungay fría en dados y 1 lata de Atún BELL'S desalada.",
          macros: { kcal: 285, prot: 32, carb: 31, fat: 2, fiber: 5 },
          ingredients: [
            "1 lata de Filete de Atún en Agua BELL'S desalada al limón",
            "1 Papa Blanca Yungay mediana (130 g) sancochada y fría en dados",
            "Bowl de 2 tazas de verduras: 80 g de pepinillo, 60 g de tomate, 50 g de vainitas al vapor y 60 g de lechuga americana"
          ],
          steps: [
            "Mezcla en un bowl 80 g de pepinillo, 60 g de tomate, 50 g de vainitas al vapor, 60 g de lechuga americana y 1 Papa Blanca Yungay mediana (130 g) sancochada y fría en dados.",
            "Corona con 1 lata de Filete de Atún en Agua BELL'S desalada en colador y aliñada con jugo de limón."
          ],
          clinicalNote: "Cena alcalinizante rica en potasio vegetal para sostener el control de presión arterial durante la noche.",
          timers: []
        }
      ]
    },
    {
      dayIndex: 4,
      dayName: "Viernes",
      shortName: "Vie",
      optionLabel: "Opción 5 de la Doctora",
      focusTag: "Granola Casera Sin Azúcar y Ahorro",
      nightPrepReminder: "Para mañana Sábado: Deja cocidos 50 g en crudo de Arroz Integral BELL'S a la jardinera (con vainita, zanahoria y choclo) y sepáralo en refrigeración para el almuerzo del sábado.",
      meals: [
        {
          id: "vie_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "Jugo de fresas con leche light con stevia + 1 Pan con pollo y apio",
          shortDesc: "Sándwich en Pan Integral BELL'S con 80 g de Pechuga SADIA deshilachada, apio y Yogurt Slim 0% + licuado de 100 g fresa con leche light.",
          macros: { kcal: 415, prot: 34, carb: 47, fat: 8, fiber: 7 },
          ingredients: [
            "80 g de Filete de Pechuga SADIA deshilachada",
            "1 tallo grande (35 g) de Apio picado fino + 1 cda de Yogurt Gloria Slim 0%, limón y pimienta",
            "2 rebanadas de Pan Integral BELL'S tostado",
            "Licuado: 100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia"
          ],
          steps: [
            "Mezcla 80 g de Filete de Pechuga SADIA deshilachada con 1 tallo grande (35 g) de Apio picado fino, 1 cda de Yogurt Gloria Slim 0%, limón y pimienta en 2 rebanadas de Pan Integral BELL'S.",
            "Come primero el sándwich y acompaña al final con el licuado de 100 g de Fresa Congelada BELL'S + 60 ml de Leche Light + 180 ml de agua y stevia.",
            "Toma tu Irbesartán 150 mg al terminar."
          ],
          clinicalNote: "Los ftálidos naturales del apio relajan el endotelio vascular actuando en sinergia con tu Irbesartán 150 mg.",
          timers: [
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "vie_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM",
          title: "1 Mandarina W Murcott mediana (100 g)",
          shortDesc: "Antioxidantes cítricos e hidratación antes del entrenamiento.",
          macros: { kcal: 50, prot: 1, carb: 12, fat: 0, fiber: 2 },
          ingredients: [
            "1 Mandarina W Murcott mediana (100 g)"
          ],
          steps: [
            "Consumir en gajos enteros a las 10:30 AM antes de entrenar."
          ],
          clinicalNote: "La vitamina C favorece la excreción tubular de ácido úrico.",
          timers: []
        },
        {
          id: "vie_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
          title: "Zarza de Atún al Limón (1.5 latas) + 1 Camote al Horno + 2 Tazas de Ensalada + 1 Manzana",
          shortDesc: "1.5 latas de Filete de Atún en Agua BELL'S desalado (1 nueva + 1/2 del lunes) + 160 g camote al horno/sartén + 2 tazas de ensalada.",
          macros: { kcal: 530, prot: 46, carb: 68, fat: 5, fiber: 10 },
          ingredients: [
            "1.5 latas (150–180 g escurridos = 1 lata nueva + la 1/2 lata guardada del lunes) de Filete de Atún en Agua BELL'S desalado en colador",
            "160 g de Camote Amarillo en rodajas horneado o dorado en sartén seca con canela/orégano",
            "Ensalada (2 tazas): 100 g de lechuga americana, 60 g de tomate, 40 g de cebolla roja lavada, 30 g de apio picado, 50 g de pepinillo y jugo de 1 limón",
            "Postre: 1 Manzana Israel (120 g)"
          ],
          steps: [
            "Enjuaga en colador durante 10 segundos las 1.5 latas de Filete de Atún en Agua BELL'S para retirar el sodio.",
            "Hornea o dora en sartén antiadherente seca con tapa los 160 g de Camote Amarillo en rodajas con canela u orégano.",
            "Come 1° las 2 tazas de ensalada fresca con la zarza de atún al limón y apio, y 2° el camote dorado y la manzana. Toma tu Bisoprolol 2.5 mg."
          ],
          clinicalNote: "Aprovechar la media lata guardada del lunes entrega 46 g de proteína limpia en el almuerzo post-entreno con cero desperdicio.",
          timers: [
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "vie_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
          shortDesc: "Aporte de fitoesteroles y grasas monoinsaturadas sin sal.",
          macros: { kcal: 115, prot: 5, carb: 3, fat: 10, fiber: 2 },
          ingredients: [
            "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
          ],
          steps: [
            "Consumir 20 g pesados en balanza a las 16:30 con agua."
          ],
          clinicalNote: "Mantiene estable la saciedad vespertina y reduce el colesterol LDL.",
          timers: []
        },
        {
          id: "vie_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00",
          title: "1 Vaso de Yogurt 0% + Granola Casera \"Sin Azúcar\"",
          shortDesc: "250 ml de Yogurt GLORIA Slim Triple Zero 0% con 25 g avena + 5 g chía + 10 g maní sin sal tostados 4 min en sartén seca con canela.",
          macros: { kcal: 295, prot: 18, carb: 31, fat: 9, fiber: 6 },
          ingredients: [
            "250 ml de Yogurt GLORIA Slim Triple Zero 0%",
            "Granola Casera: 25 g (3 cdas) de tu Avena GRANO DE ORO + 5 g de Chía ECOANDINO + 10 g de tu Maní sin sal VILLA NATURA picado + canela y 2 gotas de stevia"
          ],
          steps: [
            "En lugar de gastar S/ 14.20 en granola comercial con maltitol, tuesta en sartén seca por 4 minutos 25 g (3 cdas) de tu Avena + 5 g de Chía + 10 g de tu Maní sin sal picado con canela y 2 gotas de stevia.",
            "Deja enfriar 2 minutos para que quede crujiente y sírvela sobre 250 ml de Yogurt GLORIA Slim Triple Zero 0%."
          ],
          clinicalNote: "Ahorras S/ 14.20 evitando maltitol y aceites refinados de las granolas comerciales mientras sumas fibra soluble y Omega-3.",
          timers: [
            { label: "Tostado granola en sartén (4 min)", durationSeconds: 240 }
          ]
        }
      ]
    },
    {
      dayIndex: 5,
      dayName: "Sábado",
      shortName: "Sáb",
      optionLabel: "Opción 6 de la Doctora",
      focusTag: "Estofado Peruano sin Aceite",
      nightPrepReminder: "Para mañana Domingo: Pasa 200 g de Lomito Saltado de Cerdo REDONDOS del congelador al refrigerador para el almuerzo dominical.",
      meals: [
        {
          id: "sab_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "1 Taza de avena con canela + 1/2 manzana, 1/2 plátano, 30 g arándanos, 1 cda chía + 2 huevos duros",
          shortDesc: "Come primero los 2 Huevos Pardos BELL'S duros y luego el porridge de 40 g Avena + 10 g Chía + manzana, plátano y 30 g arándanos.",
          macros: { kcal: 485, prot: 21, carb: 58, fat: 18, fiber: 11 },
          ingredients: [
            "2 Huevos Pardos BELL'S duros (comer primero)",
            "40 g de Avena GRANO DE ORO + 10 g de Chía Negra ECOANDINO",
            "1/2 Manzana Israel (65 g) + 1/2 Plátano de seda (55 g) + 30 g de Blueberries BELL'S FRESCOS"
          ],
          steps: [
            "Come primero los 2 Huevos Pardos BELL'S duros.",
            "Luego consume el porridge hervido 4 min de 40 g de Avena + 10 g de Chía + 1/2 manzana + 1/2 plátano + 30 g de arándanos.",
            "Toma tu Irbesartán 150 mg al terminar."
          ],
          clinicalNote: "Segunda carga semanal de colina (2 yemas) y betaglucanos para acelerar la limpieza de grasa hepática (TGP 49.9 U/L).",
          timers: [
            { label: "Hervor avena (4 min)", durationSeconds: 240 },
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "sab_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Entrenar en tu espacio de 2x2 m entre 11:00 AM y 13:00 PM",
          title: "1 Mandarina W Murcott mediana (100 g)",
          shortDesc: "Hidratación y flavonoides cítricos pre-entreno.",
          macros: { kcal: 50, prot: 1, carb: 12, fat: 0, fiber: 2 },
          ingredients: [
            "1 Mandarina W Murcott mediana (100 g)"
          ],
          steps: [
            "Consumir en gajos enteros a las 10:30 AM antes de entrenar."
          ],
          clinicalNote: "Aporta vitamina C e hidratación celular.",
          timers: []
        },
        {
          id: "sab_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 12 min caminata estática",
          title: "Estofado de Pollo sin Aceite (200 g) + 1 Taza de Arroz a la Jardinera + 2 Tazas de Ensalada + 1 Manzana",
          shortDesc: "200 g Filete de Pechuga SADIA en salsa natural de tomate, cebolla, zanahoria y laurel + arroz integral a la jardinera + ensalada.",
          macros: { kcal: 560, prot: 53, carb: 66, fat: 7, fiber: 10 },
          ingredients: [
            "200 g de Filete de Pechuga SADIA en trozos",
            "Salsa natural: 60 g de tomate licuado, 40 g de cebolla picada, 1 diente de ajo, 30 g de zanahoria en rodajas, laurel, páprika y orégano",
            "Arroz a la jardinera (1 taza): 50 g en crudo de Arroz Integral BELL'S cocido con 30 g de vainitas picadas, 20 g de zanahoria en cubitos y 20 g de choclo desgranado",
            "Ensalada (2 tazas): 120 g de lechuga americana + 80 g de pepinillo al limón",
            "Postre: 1 Manzana Israel (110 g)"
          ],
          steps: [
            "Sella en olla antiadherente sin aceite los 200 g de Filete de Pechuga SADIA en trozos con ajo, páprika y orégano; añade el tomate licuado, cebolla, zanahoria en rodajas, laurel y 1/2 taza de agua cocinando tapado por 20 min.",
            "Come 1° las 2 tazas de ensalada de lechuga y pepinillo al limón, 2° el estofado de pollo y 3° la taza de arroz integral a la jardinera y la manzana.",
            "Toma tu Bisoprolol fumarato 2.5 mg al terminar."
          ],
          clinicalNote: "El licopeno del tomate cocido sin aceites refinados evita la oxidación del colesterol LDL.",
          timers: [
            { label: "Estofado a fuego lento (20 min)", durationSeconds: 1200 },
            { label: "Caminata post-almuerzo (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "sab_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%",
          shortDesc: "Colación proteica 0% grasa y 0% azúcar.",
          macros: { kcal: 75, prot: 8, carb: 9, fat: 0, fiber: 0 },
          ingredients: [
            "1 vaso (180 ml) de Yogurt GLORIA Slim Triple Zero 0%"
          ],
          steps: [
            "Servir frío a las 16:30."
          ],
          clinicalNote: "Sostiene la saciedad de la tarde y ayuda a depurar ácido úrico.",
          timers: []
        },
        {
          id: "sab_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de ingesta a las 19:00",
          title: "Ensalada de tomate + Pollo en cuadritos (150 g) + Choclo",
          shortDesc: "150 g de Pechuga de Pollo SADIA salteada en cuadritos con ajo y orégano + 150 g tomate en gajos con cebolla + 3/4 taza de Choclo BELL'S.",
          macros: { kcal: 320, prot: 37, carb: 28, fat: 5, fiber: 4 },
          ingredients: [
            "150 g de Pechuga de Pollo SADIA en cuadritos",
            "150 g de Tomate en gajos con cebolla y limón",
            "3/4 taza (100 g) de Choclo Desgranado BELL'S sancochado",
            "Ajo, orégano, gotas de limón y 1 cda de agua"
          ],
          steps: [
            "Saltea 150 g de Pechuga de Pollo SADIA en cuadritos en sartén antiadherente con ajo, orégano, gotas de limón y 1 cda de agua por 6 minutos.",
            "Acompaña con 150 g de tomate en gajos con cebolla y limón + 3/4 taza (100 g) de Choclo Desgranado BELL'S sancochado."
          ],
          clinicalNote: "Cena ligera que facilita un descanso profundo y repara el tejido muscular.",
          timers: []
        }
      ]
    },
    {
      dayIndex: 6,
      dayName: "Domingo",
      shortName: "Dom",
      optionLabel: "Opción 7 de la Doctora",
      focusTag: "Lomo de Cerdo Magro y Pasta Al Dente",
      nightPrepReminder: "Para mañana Lunes: Deja sancochada y refrigerando 12 h 1 Papa Blanca Yungay mediana (150 g) para la cena del lunes y 55 g en crudo de Arroz Integral BELL'S para el almuerzo del lunes.",
      meals: [
        {
          id: "dom_desayuno",
          slot: "desayuno",
          time: "08:00 AM",
          slotLabel: "Desayuno",
          medAlert: "Tomar Irbesartán 150 mg al terminar + 12 min caminata estática",
          title: "1 Taza de leche + 1 Pan con queso fresco y jamón de pavita + 2 mandarinas",
          shortDesc: "Sándwich en Pan Integral BELL'S con 30 g Queso Fresco BELL'S desalado y 1 lámina de Jamón de Pavita SAN FERNANDO + leche tibia + 2 mandarinas.",
          macros: { kcal: 420, prot: 25, carb: 56, fat: 8, fiber: 6 },
          ingredients: [
            "2 rebanadas de Pan Integral BELL'S tostado",
            "30 g de Queso Fresco BELL'S (pasado por agua) + 1 lámina (20 g) de Jamón de Pavita SAN FERNANDO (Paquete 100g) dorada en sartén seca",
            "1 taza de leche tibia (60 ml Leche Light GLORIA + 180 ml agua con canela)",
            "2 Mandarinas W Murcott en gajos (180 g)"
          ],
          steps: [
            "Arma tu sándwich en 2 rebanadas de Pan Integral BELL'S con 30 g de Queso Fresco BELL'S (pasado por agua) y 1 lámina (20 g) de Jamón de Pavita SAN FERNANDO (Paquete 100g) dorada en sartén seca.",
            "Acompaña con 1 taza de leche tibia (60 ml Leche Light + 180 ml agua con canela) y termina con 2 Mandarinas en gajos.",
            "Toma tu Irbesartán 150 mg al terminar."
          ],
          clinicalNote: "Desalar el queso fresco por 10 segundos mantiene controlado el sodio matutino en sinergia con el Irbesartán.",
          timers: [
            { label: "Caminata post-desayuno (12 min)", durationSeconds: 720 }
          ]
        },
        {
          id: "dom_mm",
          slot: "media_manana",
          time: "10:30 AM",
          slotLabel: "Pre-entreno",
          medAlert: "Sesión de movilidad o entrenamiento en 2x2 m (11:00 AM)",
          title: "1 Manzana Israel pequeña (110 g) con cáscara",
          shortDesc: "Pectina soluble para moderar el apetito antes del almuerzo dominical.",
          macros: { kcal: 60, prot: 0, carb: 15, fat: 0, fiber: 3 },
          ingredients: [
            "1 Manzana Israel pequeña (110 g) con cáscara"
          ],
          steps: [
            "Lavar y comer entera con cáscara a las 10:30 AM."
          ],
          clinicalNote: "Prepara la microbiota intestinal y aporta saciedad previa al almuerzo.",
          timers: []
        },
        {
          id: "dom_almuerzo",
          slot: "almuerzo",
          time: "14:00 (2:00 PM)",
          slotLabel: "Almuerzo Principal",
          medAlert: "Tomar Bisoprolol fumarato 2.5 mg al terminar + 15 min caminata suave",
          title: "Lomo de Cerdo Magro (200 g) + 1 Taza de Fideos Al Dente + 2 Tazas de Ensalada + Arándanos",
          shortDesc: "200 g Lomito Saltado de Cerdo REDONDOS limpio de grasa + 1 taza de Spaghetti/Tornillo BELL'S (8 min al dente) en salsa casera + 30 g arándanos.",
          macros: { kcal: 575, prot: 51, carb: 62, fat: 11, fiber: 8 },
          ingredients: [
            "200 g de Lomito Saltado de Cerdo REDONDOS (Bandeja 620g) limpio de grasa visible",
            "55 g en crudo de Spaghetti o Tornillo BELL'S (hervido estrictamente 8 minutos al dente = 1 taza / 140 g cocido)",
            "Salsa casera: 70 g de tomate picado, 40 g de cebolla, ajo y orégano",
            "Ensalada (2 tazas obligatorias antes de la pasta): 100 g de lechuga americana, 60 g de vainitas al vapor, 60 g de pepinillo y limón",
            "Postre: 30 g de Blueberries BELL'S FRESCOS"
          ],
          steps: [
            "REGLA DE ORO: Hierve los 55 g en crudo de Spaghetti o Tornillo BELL'S durante estrictamente 8 MINUTOS al dente (equivale a 1 taza / 140 g cocido).",
            "Dora en sartén antiadherente sin aceite los 200 g de Lomito Saltado de Cerdo REDONDOS sazonado con ajo y orégano, y prepara la salsa casera con 70 g de tomate picado, 40 g de cebolla, ajo y orégano.",
            "ORDEN ESTRICTO: Come 1° las 2 tazas obligatorias de ensalada, 2° los 200 g de lomo de cerdo y 3° la taza de fideos al dente y los 30 g de arándanos. Toma tu Bisoprolol 2.5 mg."
          ],
          clinicalNote: "El lomo de cerdo magro aporta tiamina (Vitamina B1) para oxidar los carbohidratos de la pasta al dente sin elevar los triglicéridos hepáticos.",
          timers: [
            { label: "Fideos Al Dente (8 min exactos)", durationSeconds: 480 },
            { label: "Caminata post-almuerzo (15 min)", durationSeconds: 900 }
          ]
        },
        {
          id: "dom_mt",
          slot: "media_tarde",
          time: "16:30 (4:30 PM)",
          slotLabel: "Media Tarde",
          medAlert: null,
          title: "20 g de Maní Tostado Natural Sin Sal VILLA NATURA",
          shortDesc: "Grasas monoinsaturadas y saciedad de domingo por la tarde.",
          macros: { kcal: 115, prot: 5, carb: 3, fat: 10, fiber: 2 },
          ingredients: [
            "20 g de Maní Tostado Natural Sin Sal VILLA NATURA"
          ],
          steps: [
            "Consumir 20 g pesados en balanza a las 16:30 con agua."
          ],
          clinicalNote: "Completa el aporte semanal de ácido oleico cardioprotector.",
          timers: []
        },
        {
          id: "dom_cena",
          slot: "cena",
          time: "19:00 (7:00 PM)",
          slotLabel: "Cena Ligera",
          medAlert: "Cierre de semana nutricional a las 19:00",
          title: "Ensalada cocida al dente + 1 Lata de Atún + Palta",
          shortDesc: "100 g de Vainita Americana y 80 g de Zanahoria en bastones al vapor por solo 6 min + 1 lata de Atún BELL'S desalada + 60 g de Palta Fuerte.",
          macros: { kcal: 310, prot: 31, carb: 16, fat: 13, fiber: 7 },
          ingredients: [
            "100 g de Vainita Americana + 80 g de Zanahoria en bastones (al vapor por solo 6 minutos al dente)",
            "1 lata de Filete de Atún en Agua BELL'S desalada en colador",
            "1/4 de unidad (60 g) de Palta Fuerte o Hass en láminas con limón"
          ],
          steps: [
            "Cocina al vapor por solo 6 minutos (al dente) 100 g de Vainita Americana y 80 g de Zanahoria en bastones.",
            "Sirve encima 1 lata de Filete de Atún en Agua BELL'S desalada y 1/4 de unidad (60 g) de Palta Fuerte en láminas con limón."
          ],
          clinicalNote: "Cena muy baja en carbohidratos netos (9 g) para amanecer el lunes con la insulina basal en su nivel más bajo.",
          timers: [
            { label: "Verduras al vapor Al Dente (6 min)", durationSeconds: 360 }
          ]
        }
      ]
    }
  ],
  shoppingCategories: [
    { code: "all", chipTitle: "Todos (35)", sectionHeader: "Todos los Productos de Agora" },
    { code: "frescos", chipTitle: "Reposición Semanal (S/ 88.60)", sectionHeader: "Compra Semanal (Semanas 2, 3 y 4)" },
    { code: "1", chipTitle: "Carnes y Lácteos (9)", sectionHeader: "1. Carnes, Pescados, Huevos y Lácteos" },
    { code: "2", chipTitle: "Queso, Pan y Despensa (10)", sectionHeader: "2. Queso, Jamón, Panes y Abarrotes" },
    { code: "3", chipTitle: "Frutas (5)", sectionHeader: "3. Frutas en Agora (Plaza Vea)" },
    { code: "4", chipTitle: "Tubérculos y Verduras (11)", sectionHeader: "4. Tubérculos y Verduras Frescas" }
  ],
  shoppingItems: [
    { id: "sh_01", skuLabel: "SKU #1", category: "1", name: "Filete de Pechuga de Pollo SADIA Bolsa 1Kg (o Pechuga Entera Plaza Vea x kg a S/ 13.50)", quantity: "1 Bolsa de 1.0 kg", priceSoles: 14.90, weeklyCostSoles: 14.90, durationNote: "Dura 1 semana (950 g usados)", usageNote: "Almuerzo Lunes (200 g + 70 g pan Mar), Cena Martes (150 g), Desayuno Viernes (80 g), Almuerzo y Cena Sábado (350 g)", isWeeklyReplenishment: true },
    { id: "sh_02", skuLabel: "SKU #2", category: "1", name: "Carne Molida de Pavita SAN FERNANDO Paquete 500g", quantity: "1 Paquete de 500 g (sellado al vacío)", priceSoles: 10.90, weeklyCostSoles: 4.36, durationNote: "Dura 2.5 semanas (usas 200 g el martes)", usageNote: "Almuerzo Martes (Opción 2: 2 medallones caseros a la plancha); congelar 300 g restantes", isWeeklyReplenishment: false },
    { id: "sh_03", skuLabel: "SKU #3", category: "1", name: "Filete de Atún en Agua BELL'S Lata 150g (Paquete 4un S/ 18.50 + 2 latas S/ 4.80 c/u)", quantity: "1 Paquete x 4 unid + 2 Latas sueltas (6 latas total)", priceSoles: 28.10, weeklyCostSoles: 28.10, durationNote: "Dura 1 semana (6 latas semanales)", usageNote: "Lun desayuno (1/2) y cena (1), Mié cena (1), Jue cena (1), Vie almuerzo (1.5) y Dom cena (1). Enjuagar sodio 10 s", isWeeklyReplenishment: true },
    { id: "sh_04", skuLabel: "SKU #4", category: "1", name: "Filete de Basa BELL'S Congelado Bolsa 1Kg (o Basa Refrigerado x kg a S/ 10.50)", quantity: "1 Bolsa de 1.0 kg (5 filetes de 200 g)", priceSoles: 14.50, weeklyCostSoles: 2.90, durationNote: "Dura 5 semanas (usas 200 g el miércoles)", usageNote: "Almuerzo Miércoles (Opción 3: 200 g al vapor/sudado bajo en purinas)", isWeeklyReplenishment: false },
    { id: "sh_05", skuLabel: "SKU #5", category: "1", name: "Hígado de Res EL BUEN CORTE x kg", quantity: "1 Unidad en app (= Presentación 1.0 kg aprox.)", priceSoles: 14.50, weeklyCostSoles: 2.90, durationNote: "Dura 5 semanas (dividir en 5 bolsas de 200 g)", usageNote: "Almuerzo Jueves (Opción 4: 180 g encebollado descartando caldo de cocción)", isWeeklyReplenishment: false },
    { id: "sh_06", skuLabel: "SKU #6", category: "1", name: "Lomito Saltado de Cerdo REDONDOS Empaque 620g (o Chuleta de Lomo 1 kg a S/ 20.90)", quantity: "1 Bandeja de 620 g", priceSoles: 19.90, weeklyCostSoles: 6.63, durationNote: "Dura 3 semanas (usas 200 g el domingo)", usageNote: "Almuerzo Domingo (Opción 7: 200 g de lomo magro a la plancha)", isWeeklyReplenishment: false },
    { id: "sh_07", skuLabel: "SKU #7", category: "1", name: "Huevos Pardos BELL'S Bandeja 30un", quantity: "1 Bandeja de 30 unidades", priceSoles: 18.90, weeklyCostSoles: 4.73, durationNote: "Dura 4 semanas (usas 5 a 7 huevos/sem)", usageNote: "Desayunos Lunes (1 huevo duro), Miércoles (2 huevos duros) y Sábado (2 huevos duros)", isWeeklyReplenishment: false },
    { id: "sh_08", skuLabel: "SKU #8", category: "1", name: "Yogurt GLORIA Slim Triple Zero Botella 1.6Kg (0% grasa, 0% azúcar)", quantity: "1 Botella de 1.6 kg", priceSoles: 10.90, weeklyCostSoles: 8.38, durationNote: "Dura 1.3 semanas (cubre tardes + cena viernes)", usageNote: "Medias Tardes Lun/Mié/Sáb (180 ml), Cena Viernes (250 ml) y aderezo de pan con pollo Mar/Vie", isWeeklyReplenishment: true },
    { id: "sh_09", skuLabel: "SKU #9", category: "1", name: "Leche Light GLORIA Lata 390g (o Leche Evaporada Light BELL'S Lata 410g)", quantity: "1 Lata (390 g – 410 g; rinde los 5 desayunos diluidos)", priceSoles: 4.20, weeklyCostSoles: 4.20, durationNote: "Dura 1 semana (300 ml usados en total)", usageNote: "Desayunos Lun, Mar, Jue, Vie y Dom (60 ml + 180 ml de agua por toma)", isWeeklyReplenishment: true },
    { id: "sh_10", skuLabel: "SKU #10", category: "2", name: "Queso Fresco BELL'S Paquete 300g (o Queso Fresco Light BELL'S a S/ 10.50)", quantity: "1 Paquete cerrado de 300 g", priceSoles: 9.90, weeklyCostSoles: 3.30, durationNote: "Dura 3 semanas (usas 70 g/sem: jue y dom)", usageNote: "Desayuno Jueves (40 g) y Desayuno Domingo (30 g) — pasar 10 s por agua fría", isWeeklyReplenishment: false },
    { id: "sh_11", skuLabel: "SKU #11", category: "2", name: "Jamón de Pavita SAN FERNANDO Paquete 100g", quantity: "1 Paquete cerrado de 100 g", priceSoles: 5.50, weeklyCostSoles: 1.83, durationNote: "Dura 3 semanas (usas 1 a 2 láminas el domingo)", usageNote: "Desayuno Domingo (Opción 7: 1 lámina de 20 g dorada en sartén seca)", isWeeklyReplenishment: false },
    { id: "sh_12", skuLabel: "SKU #12", category: "2", name: "Pan de Molde Integral BELL'S Mediano Bolsa 500g", quantity: "1 Bolsa de 500 g (~20 rebanadas)", priceSoles: 7.50, weeklyCostSoles: 3.75, durationNote: "Dura 2 semanas (usas 10 rebanadas/sem)", usageNote: "Desayunos Lunes, Martes, Jueves, Viernes y Domingo (2 rebanadas tostadas)", isWeeklyReplenishment: false },
    { id: "sh_13", skuLabel: "SKU #13", category: "2", name: "Tortillas BIMBO Rapiditas Integrales Bolsa 10un", quantity: "1 Bolsa (congelar las 9 restantes)", priceSoles: 7.90, weeklyCostSoles: 0.79, durationNote: "Dura 10 semanas (usas 1 unidad el miércoles)", usageNote: "Cena Miércoles (Opción 3: 1 tortilla integral con atún y ensalada)", isWeeklyReplenishment: false },
    { id: "sh_14", skuLabel: "SKU #14", category: "2", name: "Avena GRANO DE ORO Bolsa 500g (o Avena 3 Ositos 540g)", quantity: "1 Bolsa de 500 g", priceSoles: 4.60, weeklyCostSoles: 1.15, durationNote: "Dura 4 semanas (usas 105 g/sem: mié, vie, sáb)", usageNote: "Porridge Miércoles y Sábado (40 g c/u) + Granola casera Viernes (25 g)", isWeeklyReplenishment: false },
    { id: "sh_15", skuLabel: "SKU #15", category: "2", name: "Arroz Integral BELL'S Bolsa 750g", quantity: "1 Bolsa de 750 g", priceSoles: 3.80, weeklyCostSoles: 0.54, durationNote: "Dura 7 semanas (usas 105 g en crudo/sem)", usageNote: "Almuerzo Lunes (55 g crudo) y Almuerzo Sábado a la jardinera (50 g crudo)", isWeeklyReplenishment: false },
    { id: "sh_16", skuLabel: "SKU #16", category: "2", name: "Lenteja Superior BELL'S Bolsa 500g", quantity: "1 Bolsa de 500 g", priceSoles: 5.80, weeklyCostSoles: 0.83, durationNote: "Dura 7 semanas (usas 65 g en crudo el martes)", usageNote: "Almuerzo Martes (Opción 2: remojar 12 h antes y desechar agua de remojo)", isWeeklyReplenishment: false },
    { id: "sh_17", skuLabel: "SKU #17", category: "2", name: "Spaghetti o Tornillo BELL'S Paquete 500g", quantity: "1 Paquete de 500 g", priceSoles: 2.50, weeklyCostSoles: 0.28, durationNote: "Dura 9 semanas (usas 55 g en crudo el domingo)", usageNote: "Almuerzo Domingo (Opción 7: hervir estrictamente 8 min al dente)", isWeeklyReplenishment: false },
    { id: "sh_18", skuLabel: "SKU #18", category: "2", name: "Chía Negra ECOANDINO Doypack 200g", quantity: "1 Doypack de 200 g", priceSoles: 4.99, weeklyCostSoles: 0.62, durationNote: "Dura 8 semanas (usas 25 g/sem)", usageNote: "Desayunos Miércoles y Sábado (10 g c/u) + Granola casera Viernes (5 g)", isWeeklyReplenishment: false },
    { id: "sh_19", skuLabel: "SKU #19", category: "2", name: "Maní Tostado Sin Sal VILLA NATURA Bolsa 200g", quantity: "1 Bolsa de 200 g", priceSoles: 7.50, weeklyCostSoles: 3.40, durationNote: "Dura 2.2 semanas (usas 90 g/sem)", usageNote: "Medias Tardes Mar, Jue, Vie y Dom (20 g) + Granola casera Viernes (10 g)", isWeeklyReplenishment: false },
    { id: "sh_20", skuLabel: "SKU #20", category: "3", name: "Fresa Entera Congelada BELL'S Bolsa 1kg", quantity: "1 Bolsa de 1.0 kg", priceSoles: 14.50, weeklyCostSoles: 4.35, durationNote: "Dura 3.3 semanas (usas 300 g/sem en batidos)", usageNote: "Batidos de desayuno Lunes, Jueves y Viernes (100 g por batido)", isWeeklyReplenishment: false },
    { id: "sh_21", skuLabel: "SKU #21", category: "3", name: "Blueberries (Arándanos) BELL'S FRESCOS Bandeja 125g", quantity: "1 Bandeja de 125 g", priceSoles: 6.90, weeklyCostSoles: 4.60, durationNote: "Dura 1.5 semanas (usas 90 g/sem)", usageNote: "Desayunos Miércoles y Sábado (30 g) + Postre Almuerzo Domingo (30 g)", isWeeklyReplenishment: true },
    { id: "sh_22", skuLabel: "SKU #22", category: "3", name: "Mandarina W MURCOTT x kg (S/ 4.79/kg)", quantity: "Seleccionar 1.2 kg (~10 unidades)", priceSoles: 5.75, weeklyCostSoles: 5.75, durationNote: "Dura 1 semana completa", usageNote: "Desayunos Mar/Jue/Dom, Pre-entreno Mié/Vie/Sáb y Almuerzos Lun/Mar/Jue", isWeeklyReplenishment: true },
    { id: "sh_23", skuLabel: "SKU #23", category: "3", name: "Manzana Israel x kg (S/ 3.99/kg)", quantity: "Seleccionar 1.0 kg (~7 unidades)", priceSoles: 3.99, weeklyCostSoles: 3.99, durationNote: "Dura 1 semana completa", usageNote: "Pre-entreno Lun/Jue/Dom, Avenas Mié/Sáb y Postre Almuerzos Mié/Vie/Sáb", isWeeklyReplenishment: true },
    { id: "sh_24", skuLabel: "SKU #24", category: "3", name: "Plátano de Seda Bolsa 6un (o x kg a S/ 3.89/kg)", quantity: "1 Bolsa de 6 unidades (o 3 unid = 0.75 kg)", priceSoles: 3.70, weeklyCostSoles: 1.85, durationNote: "Dura 2 semanas (usas 1.5 plátanos/sem)", usageNote: "Pre-entreno Martes (1/2 unid) y Avenas Miércoles y Sábado (1/2 unid c/u)", isWeeklyReplenishment: false },
    { id: "sh_25", skuLabel: "SKU #25", category: "4", name: "Choclo Desgranado BELL'S Bolsa 500g", quantity: "1 Bolsa de 500 g", priceSoles: 7.90, weeklyCostSoles: 5.64, durationNote: "Dura 1.4 semanas (usas 360 g/sem)", usageNote: "Cena Martes (120 g), Almuerzo Jueves (140 g), Almuerzo y Cena Sábado (120 g)", isWeeklyReplenishment: true },
    { id: "sh_26a", skuLabel: "SKU #26A", category: "4", name: "Papa Blanca Yungay x kg (S/ 2.59/kg)", quantity: "Seleccionar 1 Und. en app (0.4 kg)", priceSoles: 1.04, weeklyCostSoles: 1.04, durationNote: "Dura 1 semana completa", usageNote: "Cena Lunes (150 g) y Cena Jueves (130 g) — sancochar y refrigerar 12 h antes", isWeeklyReplenishment: true },
    { id: "sh_26b", skuLabel: "SKU #26B", category: "4", name: "Camote Amarillo Procesado x kg (S/ 3.29/kg)", quantity: "Seleccionar 1 Und. en app (0.5 kg)", priceSoles: 1.65, weeklyCostSoles: 1.65, durationNote: "Dura 1 semana completa", usageNote: "Almuerzo Miércoles (160 g) y Almuerzo Viernes al horno (160 g)", isWeeklyReplenishment: true },
    { id: "sh_27a", skuLabel: "SKU #27A", category: "4", name: "Lechuga Americana x und (S/ 2.59 c/u)", quantity: "2 unidades en Agora", priceSoles: 5.18, weeklyCostSoles: 5.18, durationNote: "Dura 1 semana (base de las 14 tazas de ensalada)", usageNote: "Base crujiente obligatoria de las 2 tazas de ensalada de almuerzo y cenas", isWeeklyReplenishment: true },
    { id: "sh_27b", skuLabel: "SKU #27B", category: "4", name: "Pepinillo Fresco x kg (S/ 3.49/kg)", quantity: "Seleccionar 2 unid en app (= 1.0 kg)", priceSoles: 3.49, weeklyCostSoles: 3.49, durationNote: "Dura 1 semana completa", usageNote: "Volumen hidratante y potasio para las 2 tazas diarias de ensalada", isWeeklyReplenishment: true },
    { id: "sh_27c", skuLabel: "SKU #27C", category: "4", name: "Tomate Redondo x kg (S/ 6.50/kg)", quantity: "Seleccionar 3 unid en app (= 0.75 kg)", priceSoles: 4.88, weeklyCostSoles: 4.88, durationNote: "Dura 1 semana completa", usageNote: "Pan con atún, sudado de basa, hígado encebollado, estofado y ensaladas", isWeeklyReplenishment: true },
    { id: "sh_28a", skuLabel: "SKU #28A", category: "4", name: "Vainita Americana Pack x 250g", quantity: "1 Pack de 250 g", priceSoles: 2.22, weeklyCostSoles: 2.22, durationNote: "Dura 1 semana completa", usageNote: "Ensaladas Mié/Jue/Dom, Arroz a la jardinera Sáb y Cena Domingo al vapor (6 min)", isWeeklyReplenishment: true },
    { id: "sh_28b", skuLabel: "SKU #28B", category: "4", name: "Zanahoria Fresca x kg (S/ 4.40/kg)", quantity: "Seleccionar 1 unid en app (= 0.3 kg)", priceSoles: 1.32, weeklyCostSoles: 1.32, durationNote: "Dura 1 semana completa", usageNote: "Lentejas Mar, Ensalada Jue, Estofado Sáb y Cena Domingo al vapor (6 min)", isWeeklyReplenishment: true },
    { id: "sh_28c", skuLabel: "SKU #28C", category: "4", name: "Cebolla Roja x kg (S/ 3.98/kg)", quantity: "Seleccionar 0.5 kg en Agora", priceSoles: 1.99, weeklyCostSoles: 1.99, durationNote: "Dura 1 semana completa", usageNote: "Rica en quercetina anti-ácido úrico: Hígado encebollado Jueves, atún y aderezos", isWeeklyReplenishment: true },
    { id: "sh_28d", skuLabel: "SKU #28D", category: "4", name: "Limón Tahití x kg (S/ 3.80/kg)", quantity: "Seleccionar 0.3 kg en Agora", priceSoles: 1.14, weeklyCostSoles: 1.14, durationNote: "Dura 1 semana completa", usageNote: "Citrato alcalinizante diario para ensaladas, atún y agua con limón del jueves", isWeeklyReplenishment: true },
    { id: "sh_28e", skuLabel: "SKU #28E", category: "4", name: "Palta Hass o Fuerte x und", quantity: "1 unidad mediana (~250 g)", priceSoles: 1.87, weeklyCostSoles: 1.87, durationNote: "Dura 1 semana", usageNote: "Cena Domingo (Opción 7: 1/4 de unidad = 60 g en láminas)", isWeeklyReplenishment: true }
  ]
};
