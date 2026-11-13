package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.ClinicalCatalog
import com.example.data.ShopCategory
import com.example.data.ShoppingCatalog
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `verify app name and complete clinical and Plaza Vea catalogs`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Plan Dietético", appName)

        // 7 days x 5 meals = 35 clinical recipes
        assertEquals(7, ClinicalCatalog.days.size)
        assertEquals(35, ClinicalCatalog.allMealsFlat.size)

        // Complete 37-item Plaza Vea shopping list from Drive document
        assertEquals(37, ShoppingCatalog.items.size)
        assertEquals(9, ShoppingCatalog.items.count { it.category == ShopCategory.CARNES_LACTEOS })
        assertEquals(10, ShoppingCatalog.items.count { it.category == ShopCategory.ABARROTES_PAN })
        assertEquals(5, ShoppingCatalog.items.count { it.category == ShopCategory.FRUTAS })
        assertEquals(13, ShoppingCatalog.items.count { it.category == ShopCategory.VERDURAS_TUBERCULOS })
        assertTrue(ShoppingCatalog.buildKeepFormattedList(setOf("sh_01")).contains("[x] Pechuga Entera de Pollo Fresca Plaza Vea"))
    }
}
