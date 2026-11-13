package com.example.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.ShopCategory
import com.example.data.ShoppingCatalog
import com.example.data.ShoppingItem
import com.example.ui.PlanUiState
import com.example.ui.theme.Amber100
import com.example.ui.theme.Amber50
import com.example.ui.theme.Amber700
import com.example.ui.theme.Emerald300
import com.example.ui.theme.Emerald50
import com.example.ui.theme.Emerald600
import com.example.ui.theme.Emerald700
import com.example.ui.theme.Rose50
import com.example.ui.theme.Rose700
import com.example.ui.theme.Slate900
import java.util.Locale

@Composable
fun ShoppingScreen(
    uiState: PlanUiState,
    onSelectCategory: (ShopCategory) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onToggleHideChecked: () -> Unit,
    onToggleItem: (String) -> Unit,
    onToggleCategoryAll: (ShopCategory) -> Unit,
    onClearAllChecks: () -> Unit,
    onCopyKeepList: () -> Unit,
    onShareList: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showClearConfirm by remember { mutableStateOf(false) }

    val query = uiState.shopSearchQuery.trim().lowercase(Locale.getDefault())
    val filteredItems = uiState.shoppingItems.filter { item ->
        val catOk = uiState.shopCategory == ShopCategory.ALL || item.category == uiState.shopCategory
        val hideOk = !uiState.hideCheckedShopItems || !uiState.checkedShoppingIds.contains(item.id)
        val queryOk = query.isEmpty() ||
            item.name.lowercase(Locale.getDefault()).contains(query) ||
            item.quantity.lowercase(Locale.getDefault()).contains(query) ||
            item.usageNote.lowercase(Locale.getDefault()).contains(query)
        catOk && hideOk && queryOk
    }

    val groupedCategories = listOf(
        ShopCategory.CARNES_LACTEOS,
        ShopCategory.ABARROTES_PAN,
        ShopCategory.FRUTAS,
        ShopCategory.VERDURAS_TUBERCULOS
    ).mapNotNull { cat ->
        val list = filteredItems.filter { it.category == cat }
        if (list.isEmpty()) null else cat to list
    }

    if (showClearConfirm) {
        AlertDialog(
            onDismissRequest = { showClearConfirm = false },
            title = { Text("¿Desmarcar todos los insumos?") },
            text = {
                Text("Se limpiarán las casillas marcadas en la lista de compras de Plaza Vea para iniciar una nueva compra.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showClearConfirm = false
                        onClearAllChecks()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Rose700)
                ) {
                    Text("Desmarcar todo")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearConfirm = false }) {
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
                .testTag("shopping_list_column"),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "shop_budget_hero") {
                ShoppingHeroCard(
                    checkedCount = uiState.checkedShopCount,
                    totalCount = uiState.shoppingItems.size,
                    checkedSoles = uiState.checkedShopSoles,
                    pendingSoles = uiState.pendingShopSoles,
                    totalSoles = ShoppingCatalog.totalBudgetSoles,
                    hideChecked = uiState.hideCheckedShopItems,
                    onToggleHideChecked = onToggleHideChecked,
                    onCopyKeepList = onCopyKeepList,
                    onShareList = onShareList
                )
            }

            item(key = "shop_search_and_filters") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = uiState.shopSearchQuery,
                        onValueChange = onSearchQueryChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("shop_search_input"),
                        placeholder = {
                            Text(
                                text = stringResource(R.string.search_shop_hint),
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        },
                        trailingIcon = {
                            if (uiState.shopSearchQuery.isNotEmpty()) {
                                IconButton(onClick = { onSearchQueryChange("") }) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = stringResource(R.string.clear_search_cd),
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(18.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface
                        )
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        ShopCategory.entries.forEach { cat ->
                            val isSelected = uiState.shopCategory == cat
                            FilterChip(
                                selected = isSelected,
                                onClick = { onSelectCategory(cat) },
                                label = {
                                    Text(
                                        text = cat.chipTitle,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                },
                                shape = RoundedCornerShape(12.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = MaterialTheme.colorScheme.onBackground,
                                    selectedLabelColor = MaterialTheme.colorScheme.background,
                                    containerColor = MaterialTheme.colorScheme.surface
                                ),
                                modifier = Modifier.testTag("shop_cat_${cat.code}")
                            )
                        }
                    }
                }
            }

            if (groupedCategories.isEmpty()) {
                item(key = "empty_shop_state") {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCartCheckout,
                                contentDescription = null,
                                tint = Emerald600,
                                modifier = Modifier.size(34.dp)
                            )
                            Text(
                                text = if (uiState.hideCheckedShopItems && uiState.checkedShopCount == uiState.shoppingItems.size) {
                                    "¡Compraste los 37 insumos de la semana!"
                                } else {
                                    "No hay insumos que coincidan con el filtro."
                                },
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            } else {
                groupedCategories.forEach { (category, itemsInCat) ->
                    item(key = "shop_group_${category.code}") {
                        ShopCategoryCard(
                            category = category,
                            items = itemsInCat,
                            checkedIds = uiState.checkedShoppingIds,
                            onToggleItem = onToggleItem,
                            onToggleCategoryAll = { onToggleCategoryAll(category) }
                        )
                    }
                }
            }

            if (uiState.checkedShopCount > 0) {
                item(key = "reset_shopping_footer") {
                    Surface(
                        shape = RoundedCornerShape(18.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Insumos marcados: ${uiState.checkedShopCount} de ${uiState.shoppingItems.size}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Surface(
                                onClick = { showClearConfirm = true },
                                shape = RoundedCornerShape(12.dp),
                                color = Rose50,
                                border = BorderStroke(1.dp, Rose700.copy(alpha = 0.25f)),
                                modifier = Modifier.testTag("reset_shopping_btn")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
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
                                        text = stringResource(R.string.reset_shop_btn),
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
private fun ShoppingHeroCard(
    checkedCount: Int,
    totalCount: Int,
    checkedSoles: Double,
    pendingSoles: Double,
    totalSoles: Double,
    hideChecked: Boolean,
    onToggleHideChecked: () -> Unit,
    onCopyKeepList: () -> Unit,
    onShareList: () -> Unit
) {
    val progressTarget = if (totalSoles > 0) (checkedSoles / totalSoles).toFloat().coerceIn(0f, 1f) else 0f
    val animatedProgress by animateFloatAsState(targetValue = progressTarget, label = "shopBudgetBar")

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, Amber700.copy(alpha = 0.28f)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        listOf(
                            Amber50.copy(alpha = 0.85f),
                            Color.White,
                            Emerald50.copy(alpha = 0.85f)
                        )
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Amber100
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Storefront,
                            contentDescription = null,
                            tint = Amber700,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "PLAZA VEA • 37 INSUMOS EXACTOS",
                            style = MaterialTheme.typography.labelSmall,
                            color = Amber700
                        )
                    }
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = "Compras Semanales Exactas — Plan Lic. Isabel Ríos",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF0F172A)
                )
                Text(
                    text = "Toca cada insumo para marcarlo en tu carrito mientras compras. Incluye cantidades exactas, precios referenciales y el uso clínico en tu menú.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF475569)
                )
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "En tu carrito ($checkedCount/$totalCount ítems):",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(0xFF334155)
                        )
                        Text(
                            text = "S/ ${String.format(Locale.US, "%.2f", checkedSoles)} / S/ ${String.format(Locale.US, "%.2f", totalSoles)}",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = Emerald700
                        )
                    }

                    LinearProgressIndicator(
                        progress = { animatedProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(9.dp)
                            .clip(RoundedCornerShape(50)),
                        color = Emerald600,
                        trackColor = Color(0xFFE2E8F0)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Pendiente por comprar: S/ ${String.format(Locale.US, "%.2f", pendingSoles)}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF64748B)
                        )
                        Text(
                            text = "${(animatedProgress * 100).toInt()}% listo",
                            style = MaterialTheme.typography.labelSmall,
                            color = Emerald700
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onCopyKeepList,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("copy_keep_list_btn"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Slate900,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.ContentCopy,
                        contentDescription = null,
                        tint = Emerald300,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.copy_keep_btn),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                OutlinedButton(
                    onClick = onShareList,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("share_keep_list_btn"),
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, Emerald700)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = null,
                        tint = Emerald700,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.share_list_btn),
                        style = MaterialTheme.typography.labelMedium,
                        color = Emerald700
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(alpha = 0.75f))
                    .clickable { onToggleHideChecked() }
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ocultar insumos ya marcados en carrito",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF1E293B)
                )
                Switch(
                    checked = hideChecked,
                    onCheckedChange = { onToggleHideChecked() },
                    modifier = Modifier.testTag("hide_checked_shop_switch")
                )
            }
        }
    }
}

@Composable
private fun ShopCategoryCard(
    category: ShopCategory,
    items: List<ShoppingItem>,
    checkedIds: Set<String>,
    onToggleItem: (String) -> Unit,
    onToggleCategoryAll: () -> Unit
) {
    val categoryTotal = items.sumOf { it.priceSoles }
    val checkedInCategory = items.count { checkedIds.contains(it.id) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Slate900)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = category.sectionHeader,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "$checkedInCategory/${items.size} marcados • Subtotal S/ ${String.format(Locale.US, "%.2f", categoryTotal)}",
                        style = MaterialTheme.typography.labelSmall,
                        color = Emerald300
                    )
                }

                IconButton(
                    onClick = onToggleCategoryAll,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.DoneAll,
                        contentDescription = "Marcar o desmarcar sección",
                        tint = Emerald300,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            items.forEachIndexed { idx, item ->
                val isChecked = checkedIds.contains(item.id)
                ShoppingItemRow(
                    item = item,
                    isChecked = isChecked,
                    onToggle = { onToggleItem(item.id) }
                )
                if (idx < items.lastIndex) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                }
            }
        }
    }
}

@Composable
private fun ShoppingItemRow(
    item: ShoppingItem,
    isChecked: Boolean,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .minimumInteractiveComponentSize()
            .background(
                if (isChecked) {
                    Emerald50.copy(alpha = 0.45f)
                } else {
                    Color.Transparent
                }
            )
            .clickable { onToggle() }
            .padding(horizontal = 12.dp, vertical = 11.dp)
            .testTag("shop_item_${item.id}"),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onToggle() },
            colors = CheckboxDefaults.colors(
                checkedColor = Emerald600,
                checkmarkColor = Color.White
            ),
            modifier = Modifier.testTag("shop_checkbox_${item.id}")
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isChecked) {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        },
                        textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None
                    )
                    Text(
                        text = item.quantity,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (isChecked) {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        } else {
                            Emerald700
                        }
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(horizontalAlignment = Alignment.End) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isChecked) Emerald50 else MaterialTheme.colorScheme.surfaceVariant,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Text(
                            text = "S/ ${String.format(Locale.US, "%.2f", item.priceSoles)}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    if (item.unitPriceRef != null) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = item.unitPriceRef,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Text(
                text = "Uso: ${item.usageNote}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
