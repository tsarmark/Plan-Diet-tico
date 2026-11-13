package com.example

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.data.ClinicalCatalog
import com.example.data.ShopCategory
import com.example.data.ShoppingCatalog
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun `verify app name and complete clinical and Plaza Vea catalogs`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Plan Dietético", appName)

        assertEquals(7, ClinicalCatalog.days.size)
        assertEquals(35, ClinicalCatalog.allMealsFlat.size)
        assertEquals(37, ShoppingCatalog.items.size)
        assertEquals(9, ShoppingCatalog.items.count { it.category == ShopCategory.CARNES_LACTEOS })
        assertEquals(10, ShoppingCatalog.items.count { it.category == ShopCategory.ABARROTES_PAN })
        assertEquals(5, ShoppingCatalog.items.count { it.category == ShopCategory.FRUTAS })
        assertEquals(13, ShoppingCatalog.items.count { it.category == ShopCategory.VERDURAS_TUBERCULOS })
        assertTrue(ShoppingCatalog.buildKeepFormattedList(setOf("sh_01")).contains("[x] Pechuga Entera de Pollo Fresca Plaza Vea"))
    }

    @Test
    fun `launch main activity and navigate tabs without crashing`() {
        composeTestRule.onNodeWithTag("plan_meals_list").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_shop").performClick()
        composeTestRule.onNodeWithTag("shopping_list_column").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_health").performClick()
        composeTestRule.onNodeWithTag("health_screen_list").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_plan").performClick()
        composeTestRule.onNodeWithTag("plan_meals_list").assertIsDisplayed()
    }
}
