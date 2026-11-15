package com.example

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.AppTab
import com.example.data.ClinicalCatalog
import com.example.data.ShoppingCatalog
import com.example.data.local.PlanRepository
import com.example.ui.PlanUiState
import com.example.ui.PlanViewModel
import com.example.ui.components.ClinicalHeader
import com.example.ui.components.RecipeBottomSheet
import com.example.ui.screens.HealthScreen
import com.example.ui.screens.PlanScreen
import com.example.ui.screens.ShoppingScreen
import com.example.ui.theme.Emerald100
import com.example.ui.theme.Emerald700
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )
        super.onCreate(savedInstanceState)

        val repository = PlanRepository(applicationContext)

        setContent {
            MyApplicationTheme {
                val viewModel: PlanViewModel = viewModel(
                    factory = PlanViewModel.provideFactory(repository)
                )
                PlanDieteticoApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun PlanDieteticoApp(viewModel: PlanViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    // Return to main Plan tab on system back when in secondary tabs
    BackHandler(enabled = uiState.activeTab != AppTab.PLAN && uiState.activeModalMeal == null) {
        viewModel.selectTab(AppTab.PLAN)
    }

    LaunchedEffect(viewModel) {
        viewModel.snackbarEvents.collect { msg ->
            snackbarHostState.showSnackbar(msg)
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useNavRail = maxWidth >= 640.dp

        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                if (!useNavRail) {
                    PlanBottomBar(
                        activeTab = uiState.activeTab,
                        pendingShopCount = (uiState.shoppingItems.size - uiState.checkedShopCount).coerceAtLeast(0),
                        onSelectTab = viewModel::selectTab
                    )
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (useNavRail) {
                    PlanSideRail(
                        activeTab = uiState.activeTab,
                        pendingShopCount = (uiState.shoppingItems.size - uiState.checkedShopCount).coerceAtLeast(0),
                        onSelectTab = viewModel::selectTab
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    ClinicalHeader(
                        completedMealsCount = uiState.completedMealsCount,
                        currentWeightKg = uiState.currentWeightKg,
                        customBiomarkers = uiState.customBiomarkers
                    )

                    Box(modifier = Modifier.weight(1f)) {
                        ActiveTabContent(
                            uiState = uiState,
                            viewModel = viewModel,
                            context = context
                        )
                    }
                }
            }
        }
    }

    val modalMeal = uiState.activeModalMeal
    if (modalMeal != null) {
        RecipeBottomSheet(
            meal = modalMeal,
            isCompleted = uiState.completedMealIds.contains(modalMeal.id),
            checkedIngredientKeys = uiState.checkedIngredientKeys,
            onDismiss = viewModel::closeRecipe,
            onToggleCompleted = { viewModel.toggleMealCompleted(modalMeal.id) },
            onToggleIngredient = { index -> viewModel.toggleIngredientChecked(modalMeal.id, index) },
            onCopyRecipe = {
                val text = ClinicalCatalog.formatRecipeForSharing(modalMeal)
                copyToClipboard(context, "Receta Plan Dietético", text)
                viewModel.notifyMessage("Receta copiada al portapapeles")
            },
            onShareRecipe = {
                val text = ClinicalCatalog.formatRecipeForSharing(modalMeal)
                sharePlainText(context, "Receta — ${modalMeal.title}", text)
            },
            onNavigatePrev = { viewModel.navigateModalMeal(-1) },
            onNavigateNext = { viewModel.navigateModalMeal(1) }
        )
    }
}

@Composable
private fun ActiveTabContent(
    uiState: PlanUiState,
    viewModel: PlanViewModel,
    context: Context
) {
    when (uiState.activeTab) {
        AppTab.PLAN -> PlanScreen(
            uiState = uiState,
            onSelectDay = viewModel::selectDay,
            onToggleShowAllWeek = viewModel::toggleShowAllWeek,
            onSelectSlot = viewModel::setSlotFilter,
            onSearchQueryChange = viewModel::setMealSearchQuery,
            onToggleMealCompleted = viewModel::toggleMealCompleted,
            onOpenRecipe = viewModel::openRecipe,
            onToggleIrbesartan = viewModel::toggleIrbesartan,
            onToggleBisoprolol = viewModel::toggleBisoprolol,
            onToggleWorkout = viewModel::toggleWorkout,
            onIncrementWater = viewModel::incrementWater
        )

        AppTab.SHOP -> ShoppingScreen(
            uiState = uiState,
            onSelectCategory = viewModel::setShopCategory,
            onSearchQueryChange = viewModel::setShopSearchQuery,
            onToggleHideChecked = viewModel::toggleHideCheckedShopItems,
            onToggleItem = viewModel::toggleShoppingItem,
            onToggleCategoryAll = viewModel::toggleShoppingCategoryAll,
            onClearAllChecks = viewModel::clearAllShoppingChecks,
            onCopyKeepList = {
                val text = ShoppingCatalog.buildKeepFormattedList(uiState.checkedShoppingIds)
                copyToClipboard(context, "Compras Agora Plaza Vea", text)
                viewModel.notifyMessage("Lista Agora Plaza Vea copiada para Google Keep")
            },
            onShareList = {
                val text = ShoppingCatalog.buildKeepFormattedList(uiState.checkedShoppingIds)
                sharePlainText(context, "Compras Agora Plaza Vea (S/ 264.31)", text)
            }
        )

        AppTab.HEALTH -> HealthScreen(
            uiState = uiState,
            onSelectDay = viewModel::selectDay,
            onSetWaterGlasses = viewModel::setWaterGlasses,
            onAdjustWater = viewModel::adjustWater,
            onToggleIrbesartan = viewModel::toggleIrbesartan,
            onToggleBisoprolol = viewModel::toggleBisoprolol,
            onToggleWorkout = viewModel::toggleWorkout,
            onUpdateWeight = viewModel::updateWeight,
            onUpdateBiomarker = viewModel::updateBiomarker,
            onOpenGoogleFit = {
                openAppOrPlayStore(
                    context = context,
                    packages = listOf("com.google.android.apps.fitness"),
                    fallbackUrl = "https://play.google.com/store/apps/details?id=com.google.android.apps.fitness"
                )
            },
            onOpenXiaomiScale = {
                openAppOrPlayStore(
                    context = context,
                    packages = listOf("com.xiaomi.smarthome", "com.xiaomi.hm.health", "com.xiaomi.wearable"),
                    fallbackUrl = "https://play.google.com/store/apps/details?id=com.xiaomi.smarthome"
                )
            },
            onOpenFitia = {
                openAppOrPlayStore(
                    context = context,
                    packages = listOf("com.fitia.app"),
                    fallbackUrl = "https://play.google.com/store/apps/details?id=com.fitia.app"
                )
            },
            onResetWeek = viewModel::resetWeeklyProgress,
            onCheckUpdate = {
                openExternalUrl(
                    context = context,
                    url = "https://github.com/tsarmark/Plan-Diet-tico/releases/latest",
                    onFailure = { viewModel.notifyMessage("No se pudo abrir el navegador") }
                )
            }
        )
    }
}

@Composable
private fun PlanBottomBar(
    activeTab: AppTab,
    pendingShopCount: Int,
    onSelectTab: (AppTab) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        NavigationBarItem(
            selected = activeTab == AppTab.PLAN,
            onClick = { onSelectTab(AppTab.PLAN) },
            icon = {
                Icon(
                    imageVector = if (activeTab == AppTab.PLAN) Icons.Filled.CalendarMonth else Icons.Outlined.CalendarMonth,
                    contentDescription = stringResource(R.string.nav_plan)
                )
            },
            label = { Text(stringResource(R.string.nav_plan)) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Emerald700,
                selectedTextColor = Emerald700,
                indicatorColor = Emerald100
            ),
            modifier = Modifier.testTag("nav_tab_plan")
        )

        NavigationBarItem(
            selected = activeTab == AppTab.SHOP,
            onClick = { onSelectTab(AppTab.SHOP) },
            icon = {
                BadgedBox(
                    badge = {
                        if (pendingShopCount > 0) {
                            Badge(
                                containerColor = Emerald700,
                                contentColor = Color.White
                            ) {
                                Text("$pendingShopCount")
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (activeTab == AppTab.SHOP) Icons.Filled.ShoppingBag else Icons.Outlined.ShoppingBag,
                        contentDescription = stringResource(R.string.nav_shop)
                    )
                }
            },
            label = { Text("Compras") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Emerald700,
                selectedTextColor = Emerald700,
                indicatorColor = Emerald100
            ),
            modifier = Modifier.testTag("nav_tab_shop")
        )

        NavigationBarItem(
            selected = activeTab == AppTab.HEALTH,
            onClick = { onSelectTab(AppTab.HEALTH) },
            icon = {
                Icon(
                    imageVector = if (activeTab == AppTab.HEALTH) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = stringResource(R.string.nav_health)
                )
            },
            label = { Text(stringResource(R.string.nav_health)) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Emerald700,
                selectedTextColor = Emerald700,
                indicatorColor = Emerald100
            ),
            modifier = Modifier.testTag("nav_tab_health")
        )
    }
}

@Composable
private fun PlanSideRail(
    activeTab: AppTab,
    pendingShopCount: Int,
    onSelectTab: (AppTab) -> Unit
) {
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationRailItem(
            selected = activeTab == AppTab.PLAN,
            onClick = { onSelectTab(AppTab.PLAN) },
            icon = {
                Icon(
                    imageVector = if (activeTab == AppTab.PLAN) Icons.Filled.CalendarMonth else Icons.Outlined.CalendarMonth,
                    contentDescription = stringResource(R.string.nav_plan)
                )
            },
            label = { Text(stringResource(R.string.nav_plan)) },
            modifier = Modifier.testTag("rail_tab_plan")
        )
        NavigationRailItem(
            selected = activeTab == AppTab.SHOP,
            onClick = { onSelectTab(AppTab.SHOP) },
            icon = {
                BadgedBox(
                    badge = {
                        if (pendingShopCount > 0) {
                            Badge(containerColor = Emerald700, contentColor = Color.White) {
                                Text("$pendingShopCount")
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (activeTab == AppTab.SHOP) Icons.Filled.ShoppingBag else Icons.Outlined.ShoppingBag,
                        contentDescription = stringResource(R.string.nav_shop)
                    )
                }
            },
            label = { Text("Compras") },
            modifier = Modifier.testTag("rail_tab_shop")
        )
        NavigationRailItem(
            selected = activeTab == AppTab.HEALTH,
            onClick = { onSelectTab(AppTab.HEALTH) },
            icon = {
                Icon(
                    imageVector = if (activeTab == AppTab.HEALTH) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = stringResource(R.string.nav_health)
                )
            },
            label = { Text(stringResource(R.string.nav_health)) },
            modifier = Modifier.testTag("rail_tab_health")
        )
    }
}

private fun copyToClipboard(context: Context, label: String, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
    clipboard?.setPrimaryClip(ClipData.newPlainText(label, text))
}

private fun sharePlainText(context: Context, subject: String, text: String) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(Intent.createChooser(sendIntent, subject))
}

private fun openAppOrPlayStore(
    context: Context,
    packages: List<String>,
    fallbackUrl: String
) {
    val pm = context.packageManager
    for (pkg in packages) {
        val launchIntent = pm.getLaunchIntentForPackage(pkg)
        if (launchIntent != null) {
            try {
                context.startActivity(launchIntent)
                return
            } catch (_: Exception) {
                // continue to next package or fallback
            }
        }
    }
    openExternalUrl(context, fallbackUrl) {}
}

private fun openExternalUrl(context: Context, url: String, onFailure: () -> Unit) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (_: Exception) {
        onFailure()
    }
}
