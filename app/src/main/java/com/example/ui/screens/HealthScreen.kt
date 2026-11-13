package com.example.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.BiomarkerTarget
import com.example.data.BiomarkerTone
import com.example.data.ClinicalCatalog
import com.example.ui.PlanUiState
import com.example.ui.theme.Amber100
import com.example.ui.theme.Amber50
import com.example.ui.theme.Amber700
import com.example.ui.theme.Emerald100
import com.example.ui.theme.Emerald50
import com.example.ui.theme.Emerald600
import com.example.ui.theme.Emerald700
import com.example.ui.theme.Indigo100
import com.example.ui.theme.Indigo700
import com.example.ui.theme.Rose100
import com.example.ui.theme.Rose50
import com.example.ui.theme.Rose700
import com.example.ui.theme.Sky100
import com.example.ui.theme.Sky50
import com.example.ui.theme.Sky600
import com.example.ui.theme.Sky700
import java.util.Locale

@Composable
fun HealthScreen(
    uiState: PlanUiState,
    onSelectDay: (Int) -> Unit,
    onSetWaterGlasses: (Int, Int) -> Unit,
    onAdjustWater: (Int, Int) -> Unit,
    onToggleIrbesartan: (Int) -> Unit,
    onToggleBisoprolol: (Int) -> Unit,
    onToggleWorkout: (Int) -> Unit,
    onResetWeek: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showResetDialog by remember { mutableStateOf(false) }

    val selectedDay = uiState.selectedDay
    val health = uiState.selectedDayHealth
    val waterGlasses = health.waterGlasses
    val liters = String.format(Locale.US, "%.2f", waterGlasses * 0.25)
    val waterProgress by animateFloatAsState(
        targetValue = (waterGlasses / 13f).coerceIn(0f, 1f),
        label = "waterProgress"
    )

    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = { Text("¿Reiniciar progreso semanal?") },
            text = {
                Text("Se pondrán en cero las comidas completadas, los vasos de agua y las tomas de medicación de la semana. Tu lista de compras se mantendrá intacta.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showResetDialog = false
                        onResetWeek()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Rose700)
                ) {
                    Text("Reiniciar semana")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 700.dp)
                .testTag("health_screen_list"),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Compact Day Selector for Health Tracking
            item(key = "health_day_selector") {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "REGISTRO DIARIO DE HIDRATACIÓN Y MEDICACIÓN",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            uiState.days.forEachIndexed { idx, day ->
                                val isSelected = idx == uiState.selectedDayIndex
                                val dayHealth = uiState.dailyHealthByDay[idx]
                                val glassesDone = dayHealth?.waterGlasses ?: 0
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .minimumInteractiveComponentSize()
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            if (isSelected) Sky600 else MaterialTheme.colorScheme.surfaceVariant
                                        )
                                        .clickable { onSelectDay(idx) }
                                        .padding(vertical = 7.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = day.shortName,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "${glassesDone}/13",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = if (isSelected) Sky100 else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 1. 13-Glass Renal Hydration Card (3.25 Liters)
            item(key = "hydration_13_glasses_card") {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(Sky100),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.WaterDrop,
                                        contentDescription = null,
                                        tint = Sky700,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                                Column {
                                    Text(
                                        text = "Hidratación Renal (${selectedDay.dayName})",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Text(
                                        text = "Meta: 13 vasos de 250 ml = 3.25 Litros",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "$liters L",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Sky700
                                )
                                Text(
                                    text = "$waterGlasses / 13 vasos",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        LinearProgressIndicator(
                            progress = { waterProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(50)),
                            color = Sky600,
                            trackColor = Sky100
                        )

                        // 13 Interactive Glasses Grid (Row 1: 7 glasses, Row 2: 6 glasses + quick controls)
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                (1..7).forEach { glassNum ->
                                    WaterGlassButton(
                                        glassNumber = glassNum,
                                        isActive = glassNum <= waterGlasses,
                                        onClick = { onSetWaterGlasses(uiState.selectedDayIndex, glassNum) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                (8..13).forEach { glassNum ->
                                    WaterGlassButton(
                                        glassNumber = glassNum,
                                        isActive = glassNum <= waterGlasses,
                                        onClick = { onSetWaterGlasses(uiState.selectedDayIndex, glassNum) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                // Quick -1 / +1 stepper in 7th slot or row below
                                OutlinedIconButton(
                                    onClick = { onAdjustWater(uiState.selectedDayIndex, 1) },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(48.dp)
                                        .testTag("water_plus_step_btn")
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "Sumar vaso de agua",
                                        tint = Sky700
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(
                                onClick = { onAdjustWater(uiState.selectedDayIndex, -1) },
                                enabled = waterGlasses > 0
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Remove,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text("Restar 1 vaso (250 ml)")
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = Sky50,
                            border = BorderStroke(1.dp, Sky600.copy(alpha = 0.25f))
                        ) {
                            Text(
                                text = "Por qué 3.25 L: Diluye tu creatinina urinaria (267 mg/dL), normaliza la microalbuminuria (27 mg/L) y arrastra el ácido úrico (6.65 mg/dL) sin sobrecargar el riñón.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF0C4A6E),
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
            }

            // 2. Daily Medication & Training Synchronization Card
            item(key = "meds_and_workout_card") {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Indigo100),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Medication,
                                    contentDescription = null,
                                    tint = Indigo700,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Medicación y Entreno (${selectedDay.dayName})",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    text = "Sincronizado con tus horarios clínicos (08:00, 11:00 y 14:00)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        HealthChecklistTile(
                            title = "08:00 AM — Irbesartán 150 mg",
                            subtitle = "Tomar inmediatamente después del desayuno + 12 min caminata estática",
                            isDone = health.irbesartanTaken,
                            icon = Icons.Filled.Medication,
                            accentBg = Sky100,
                            accentTint = Sky700,
                            onClick = { onToggleIrbesartan(uiState.selectedDayIndex) },
                            testTag = "health_med_irb_btn"
                        )

                        HealthChecklistTile(
                            title = "11:00 a 13:00 — Ventana de Entreno (2x2 m)",
                            subtitle = "Después de tu fruta de las 10:30 AM (activa receptores musculares GLUT-4)",
                            isDone = health.workoutDone,
                            icon = Icons.Filled.FitnessCenter,
                            accentBg = Emerald100,
                            accentTint = Emerald700,
                            onClick = { onToggleWorkout(uiState.selectedDayIndex) },
                            testTag = "health_workout_btn"
                        )

                        HealthChecklistTile(
                            title = "14:00 (2:00 PM) — Bisoprolol fumarato 2.5 mg",
                            subtitle = "Tomar inmediatamente al terminar tu almuerzo principal",
                            isDone = health.bisoprololTaken,
                            icon = Icons.Filled.Medication,
                            accentBg = Indigo100,
                            accentTint = Indigo700,
                            onClick = { onToggleBisoprolol(uiState.selectedDayIndex) },
                            testTag = "health_med_bis_btn"
                        )
                    }
                }
            }

            // 3. Clinical Biomarkers & Reversal Targets
            item(key = "biomarkers_card") {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Emerald100),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.MonitorHeart,
                                    contentDescription = null,
                                    tint = Emerald700,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Tus Marcadores Clínicos y Metas",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Text(
                                    text = "Basal (04/11/2026) vs. Objetivo de Reversión",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        ClinicalCatalog.biomarkers.chunked(2).forEach { pair ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                pair.forEach { marker ->
                                    BiomarkerTile(
                                        marker = marker,
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 4. Clinical Golden Rules + Reset Week Button
            item(key = "golden_rules_and_reset") {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.VerifiedUser,
                                contentDescription = null,
                                tint = Emerald700,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "4 Reglas Clínicas de Oro del Plan",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        ClinicalCatalog.goldenRules.forEach { rule ->
                            Surface(
                                shape = RoundedCornerShape(14.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(3.dp)
                                ) {
                                    Text(
                                        text = rule.title,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Emerald700
                                    )
                                    Text(
                                        text = rule.detail,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Reiniciar marcas al iniciar nueva semana:",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Surface(
                                onClick = { showResetDialog = true },
                                shape = RoundedCornerShape(12.dp),
                                color = Rose50,
                                border = BorderStroke(1.dp, Rose700.copy(alpha = 0.3f)),
                                modifier = Modifier
                                    .minimumInteractiveComponentSize()
                                    .testTag("reset_week_btn")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.RestartAlt,
                                        contentDescription = null,
                                        tint = Rose700,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = stringResource(R.string.reset_week_btn),
                                        style = MaterialTheme.typography.labelMedium,
                                        color = Rose700
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun WaterGlassButton(
    glassNumber: Int,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(if (isActive) Sky600 else MaterialTheme.colorScheme.surfaceVariant)
            .border(
                1.dp,
                if (isActive) Sky700 else MaterialTheme.colorScheme.outline,
                RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
            .testTag("water_glass_$glassNumber"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.LocalDrink,
            contentDescription = "Vaso $glassNumber",
            tint = if (isActive) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(15.dp)
        )
        Text(
            text = "$glassNumber",
            style = MaterialTheme.typography.labelSmall,
            color = if (isActive) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun HealthChecklistTile(
    title: String,
    subtitle: String,
    isDone: Boolean,
    icon: ImageVector,
    accentBg: Color,
    accentTint: Color,
    onClick: () -> Unit,
    testTag: String
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        color = if (isDone) Emerald50 else MaterialTheme.colorScheme.surfaceVariant,
        border = BorderStroke(
            1.dp,
            if (isDone) Emerald600 else MaterialTheme.colorScheme.outline
        ),
        modifier = Modifier
            .fillMaxWidth()
            .minimumInteractiveComponentSize()
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isDone) Emerald600 else accentBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isDone) Icons.Filled.Check else icon,
                    contentDescription = null,
                    tint = if (isDone) Color.White else accentTint,
                    modifier = Modifier.size(18.dp)
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isDone) Color(0xFF064E3B) else MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isDone) Color(0xFF047857) else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = if (isDone) "Listo" else "Pendiente",
                style = MaterialTheme.typography.labelMedium,
                color = if (isDone) Emerald700 else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun BiomarkerTile(
    marker: BiomarkerTarget,
    modifier: Modifier = Modifier
) {
    val (bg, border, labelColor) = when (marker.tone) {
        BiomarkerTone.AMBER -> Triple(Amber50, Amber100, Amber700)
        BiomarkerTone.ROSE -> Triple(Rose50, Rose100, Rose700)
        BiomarkerTone.SKY -> Triple(Sky50, Sky100, Sky700)
        BiomarkerTone.EMERALD -> Triple(Emerald50, Emerald100, Emerald700)
    }

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = bg,
        border = BorderStroke(1.dp, border),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = marker.label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = labelColor
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = marker.valueText,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF0F172A)
                )
                Text(
                    text = marker.subUnit,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF475569)
                )
            }
            Text(
                text = marker.targetText,
                style = MaterialTheme.typography.labelSmall,
                color = Emerald700
            )
        }
    }
}
