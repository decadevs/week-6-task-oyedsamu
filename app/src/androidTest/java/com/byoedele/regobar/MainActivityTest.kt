package com.byoedele.regobar

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith (AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainConst)).check(matches(isDisplayed()))
    }

    @Test
    fun test_AllVisibleViews(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.name)).check(matches(isDisplayed()))
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
        onView(withId(R.id.reg_button)).check(matches(isDisplayed()))
        onView(withId(R.id.sextext)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))
        onView(withId(R.id.phoneNum)).check(matches(isDisplayed()))
        onView(withId(R.id.emailad)).check(matches(isDisplayed()))
    }

//
}