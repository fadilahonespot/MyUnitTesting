package com.fadilahone.myunittesting

import android.content.Intent
import android.os.Bundle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyVolume = "504.0"
    private val dummyCircumfreperent = "396.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.o"
    private val dummyHeigth = "6.0"
    private val dummyWidth = "7.0"
    private val emptyInput = ""
    private val fieldEmpty = "Kolom ini tidak boleh kosong"

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java, false, true)

    @Test
    fun assertGetCircumference() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeigth), closeSoftKeyboard())
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calcu_circum_preferenc)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calcu_circum_preferenc)).perform(click())

        onView(withId(R.id.text_result)).check(matches(isDisplayed()))
        onView(withId(R.id.text_result)).check(matches(withText(dummyCircumfreperent)))
    }

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeigth), closeSoftKeyboard())
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calcu_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calcu_volume)).perform(click())

        onView(withId(R.id.text_result)).check(matches(isDisplayed()))
        onView(withId(R.id.text_result)).check(matches(withText(dummyVolume)))
    }

    @Test
    fun assertSurfaceArea() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeigth), closeSoftKeyboard())
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calcu_surface_area)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calcu_surface_area)).perform(click())

        onView(withId(R.id.text_result)).check(matches(isDisplayed()))
        onView(withId(R.id.text_result)).check(matches(withText(dummySurfaceArea)))
    }
}