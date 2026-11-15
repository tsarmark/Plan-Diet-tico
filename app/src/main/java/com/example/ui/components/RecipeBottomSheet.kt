package com.example.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.Meal
import com.example.data.RecipeTimerSpec
import com.example.ui.theme.Amber100
import com.example.ui.theme.Amber500
import com.example.ui.theme.Amber700
import com.example.ui.theme.Emerald100
import com.example.ui.theme.Emerald300
import com.example.ui.theme.Emerald50
import com.example.ui.theme.Emerald600
import com.example.ui.theme.Emerald700
import com.example.ui.theme.Emerald900
import com.example.ui.theme.Emerald950
import com.example.ui.theme.Sky100
import com.example.ui.theme.Sky400
import com.example.ui.theme.Sky600
import com.example.ui.theme.Sky700
import com.example.ui.theme.Slate900
import com.example.ui.theme.Slate950
import java.util.Locale
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeBottomSheet(
    meal: Meal,
    isCompleted: Boolean,
    checkedIngredientKeys: Set<String>,
    onDismiss: () -> Unit,
    onToggleCompleted: () -> Unit,
    onToggleIngredient: (Int) -> Unit,
    onCopyRecipe: () -> Unit,
    onShareRecipe: () -> Unit,
    onNavigatePrev: () -> Unit,
    onNavigateNext: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            // Rich Clinical Modal Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.linearGradient(listOf(Slate900, Emerald950)))
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(44.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.3f))
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${meal.dayName.uppercase()} • OPCIÓN ${meal.dayIndex + 1}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Emerald300,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(Emerald600.copy(alpha = 0.28f))
                                .padding(horizontal = 9.dp, vertical = 3.dp)
                        )
                        Text(
                            text = "${meal.time} • ${meal.slotLabel}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(Color.White.copy(alpha = 0.14f))
                                .padding(horizontal = 9.dp, vertical = 3.dp)
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.14f))
                            .testTag("close_recipe_modal_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.close_modal_cd),
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = meal.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = meal.shortDesc,
                    style = MaterialTheme.typography.bodySmall,
                    color = Emerald100.copy(alpha = 0.9f)
                )

                if (meal.medAlert != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Sky400.copy(alpha = 0.22f))
                            .border(1.dp, Sky400.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 10.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Medication,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = meal.medAlert,
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 5-Macro Fitia Pro Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(Slate950.copy(alpha = 0.55f))
                        .border(1.dp, Color.White.copy(alpha = 0.12f), RoundedCornerShape(14.dp))
                        .padding(vertical = 8.dp, horizontal = 6.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MacroColumn("KCAL", "${meal.macros.kcal}", Color.White)
                    MacroColumn("PROT", "${meal.macros.prot} g", Emerald300)
                    MacroColumn("CARBOS", "${meal.macros.carb} g", Amber500)
                    MacroColumn("GRASAS", "${meal.macros.fat} g", Sky400)
                    MacroColumn("FIBRA", "${meal.macros.fiber} g", Emerald100)
                }
            }

            // Scrollable Recipe Content
            Column(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Interactive Clinical & Cooking Timers
                if (meal.timers.isNotEmpty()) {
                    ClinicalTimerSection(
                        mealId = meal.id,
                        timers = meal.timers
                    )
                }

                // Section 1: Checkable Ingredients
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Emerald100
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Scale,
                                    contentDescription = null,
                                    tint = Emerald900,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(16.dp)
                                )
                            }
                            Text(
                                text = "INGREDIENTES EXACTOS (MARCABLES)",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            TextButton(
                                onClick = onCopyRecipe,
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ContentCopy,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Copiar", style = MaterialTheme.typography.labelMedium)
                            }
                            TextButton(
                                onClick = onShareRecipe,
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Enviar", style = MaterialTheme.typography.labelMedium)
                            }
                        }
                    }

                    meal.ingredients.forEachIndexed { idx, ing ->
                        val key = "${meal.id}_$idx"
                        val isIngChecked = checkedIngredientKeys.contains(key)
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = if (isIngChecked) Emerald50.copy(alpha = 0.6f) else MaterialTheme.colorScheme.surfaceVariant,
                            border = BorderStroke(
                                1.dp,
                                if (isIngChecked) Emerald600.copy(alpha = 0.5f) else MaterialTheme.colorScheme.outline
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .clickable { onToggleIngredient(idx) }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = isIngChecked,
                                    onCheckedChange = { onToggleIngredient(idx) },
                                    colors = CheckboxDefaults.colors(checkedColor = Emerald600)
                                )
                                Text(
                                    text = ing,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (isIngChecked) {
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    },
                                    textDecoration = if (isIngChecked) TextDecoration.LineThrough else TextDecoration.None,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }

                // Section 2: Step-by-step Preparation
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Amber100
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.MenuBook,
                                contentDescription = null,
                                tint = Amber700,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .size(16.dp)
                            )
                        }
                        Text(
                            text = "RECETA CLÍNICA PASO A PASO",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    meal.steps.forEachIndexed { idx, step ->
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.surface,
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Slate900),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White
                                    )
                                }
                                Text(
                                    text = step,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }

                // Section 3: Clinical Metabolic Protection Note
                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = Emerald50,
                    border = BorderStroke(1.dp, Emerald600.copy(alpha = 0.35f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Emerald600),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.HealthAndSafety,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(17.dp)
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "PROTECCIÓN METABÓLICA (INSULINA 39.0 | ÚRICO 6.65)",
                                style = MaterialTheme.typography.labelSmall,
                                color = Emerald950
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = meal.clinicalNote,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF1E293B)
                            )
                        }
                    }
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline)

            // Bottom Navigation & Complete Action Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedIconButton(
                    onClick = onNavigatePrev,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = stringResource(R.string.prev_meal_cd)
                    )
                }

                OutlinedIconButton(
                    onClick = onNavigateNext,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = stringResource(R.string.next_meal_cd)
                    )
                }

                Button(
                    onClick = onToggleCompleted,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("modal_complete_meal_btn"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isCompleted) Emerald100 else Emerald600,
                        contentColor = if (isCompleted) Emerald950 else Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isCompleted) "Completada (Desmarcar)" else "Marcar Comida Lista",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
private fun ClinicalTimerSection(
    mealId: String,
    timers: List<RecipeTimerSpec>
) {
    var selectedIdx by remember(mealId) { mutableIntStateOf(0) }
    val activeSpec = timers.getOrElse(selectedIdx) { timers.first() }
    var remainingSeconds by remember(mealId, selectedIdx) { mutableIntStateOf(activeSpec.durationSeconds) }
    var isRunning by remember(mealId, selectedIdx) { mutableStateOf(false) }

    LaunchedEffect(mealId, selectedIdx, isRunning) {
        while (isRunning && remainingSeconds > 0) {
            delay(1000L)
            remainingSeconds -= 1
            if (remainingSeconds <= 0) {
                isRunning = false
            }
        }
    }

    val mins = remainingSeconds / 60
    val secs = remainingSeconds % 60
    val formattedTime = String.format(Locale.US, "%02d:%02d", mins, secs)
    val timerProgress by animateFloatAsState(
        targetValue = if (activeSpec.durationSeconds > 0) {
            remainingSeconds.toFloat() / activeSpec.durationSeconds
        } else 0f,
        label = "timerBar"
    )

    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Sky100.copy(alpha = 0.45f),
        border = BorderStroke(1.dp, Sky600.copy(alpha = 0.35f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Sky600
                ) {
                    Icon(
                        imageVector = Icons.Filled.Timer,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(15.dp)
                    )
                }
                Text(
                    text = "CRONÓMETRO CLÍNICO Y DE COCCIÓN",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Sky700
                )
            }

            if (timers.size > 1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    timers.forEachIndexed { idx, spec ->
                        FilterChip(
                            selected = idx == selectedIdx,
                            onClick = { selectedIdx = idx },
                            label = {
                                Text(
                                    text = spec.label,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Sky700,
                                selectedLabelColor = Color.White,
                                containerColor = Color.White
                            )
                        )
                    }
                }
            } else {
                Text(
                    text = activeSpec.label,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF0C4A6E)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = if (remainingSeconds == 0) "¡Tiempo cumplido!" else formattedTime,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (remainingSeconds == 0) Emerald700 else Color(0xFF0F172A)
                    )
                    Text(
                        text = if (isRunning) "Contando en vivo…" else "Listo para iniciar",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF475569)
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = {
                            if (remainingSeconds == 0) {
                                remainingSeconds = activeSpec.durationSeconds
                                isRunning = true
                            } else {
                                isRunning = !isRunning
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isRunning) Amber700 else Sky700,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.testTag("recipe_timer_play_btn")
                    ) {
                        Icon(
                            imageVector = if (isRunning) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isRunning) "Pausar" else "Iniciar",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }

                    OutlinedButton(
                        onClick = {
                            isRunning = false
                            remainingSeconds = activeSpec.durationSeconds
                        },
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Sky700)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.RestartAlt,
                            contentDescription = "Reiniciar cronómetro",
                            tint = Sky700,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            LinearProgressIndicator(
                progress = { timerProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(50)),
                color = if (remainingSeconds == 0) Emerald600 else Sky600,
                trackColor = Color.White
            )
        }
    }
}

@Composable
private fun MacroColumn(label: String, value: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.ExtraBold,
            color = valueColor
        )
    }
}
