package com.example.tsdc_vinilos_equipo6

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.tsdc_vinilos_equipo6.ui.MainActivity
import org.hamcrest.Matchers.anything
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Match the last item by matching its text.
    private val FIRST_ITEM_ID = "Chester Bennington"
    private val FIRST_DATE_ID = "1976-03-20"

    @Rule
    @JvmField var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tsdc_vinilos_equipo6", appContext.packageName)
    }


    fun btnMenuUsuarioClick(){
        // click en Menu Usuario
        onView(withId(R.id.MenuUserButton))
            .perform(click())
    }
    fun btnArtistCatalog(){
        // click en Menu Usuario
        onView(withId(R.id.ArtistUserButton)).perform(click())
    }
    fun btnAlbumCatalog(){
        // click en Menu Usuario
        onView(withId(R.id.AlbumUserButton)).perform(click())
    }
    fun btnCollectorCatalog(){
        // click en Menu Usuario
        onView(withId(R.id.ColecctionUserButton)).perform(click())
    }
    @Test
    fun ArtistListTest(){
        // click en Menu Usuario
        btnMenuUsuarioClick()

        //Click Catalogo de Artistas
        btnArtistCatalog()

        onView(withId(R.id.ArtistTitle)).check(matches(withText("Listado de Artistas")))

        onData(anything())
            .atPosition(0)
            .onChildView(allOf(withId(R.id.ArtistName)))
            .check(matches(isDisplayed()));
        onData(anything())
            .atPosition(0)
            .onChildView(allOf(withId(R.id.ArtisDate)))
            .check(matches(isDisplayed()));

        //onView(withId(R.id.ArtistName)).check(matches(isDisplayed()))
        //onView(withId(R.id.ArtisDate)).check(matches(isDisplayed()))


    }


    @Test
    fun AlbumCatalogTest(){
        // click en Menu Usuario
        btnMenuUsuarioClick()

        //Click Catalogo de Artistas
        btnAlbumCatalog()

        onView(withId(R.id.AlbumTitle)).check(matches(withText("Listado de Albumes")))
    }

    /*@Test
    fun CollectorCatalogTest(){
        // click en Menu Usuario
        btnMenuUsuarioClick()

        //Click Catalogo de Artistas
        btnCollectorCatalog()

        onView(withId(R.id.textView2)).check(matches(withText("Haiber H. Galindo")))
    }*/


}
