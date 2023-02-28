package com.bignerdranch.android.criminalintent

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.*

class CrimeListFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

//    private lateinit var viewModel: CrimeListViewModel
    private lateinit var scenario:ActivityScenario<MainActivity>
    val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)

    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testView() {
        onView(withId(R.id.crime_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun rotatedList() {
        device.setOrientationLeft()
        device.setOrientationNatural()
    }

    @Test
    fun testLaunchActivity() {
        Assert.assertNotNull(scenario)
    }

}