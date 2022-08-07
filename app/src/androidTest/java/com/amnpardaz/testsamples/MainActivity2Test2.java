package com.amnpardaz.testsamples;


import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.FailureHandler;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class MainActivity2Test2 {

    @Rule
    public ActivityTestRule<MainActivity2> rule  = new  ActivityTestRule<>(MainActivity2.class);


    @Test
    public void spinner(){

        onData(anything()).inAdapterView(withId(R.id.spinner)).atPosition(5).perform(click());
    }

    @Test
    public void testActionBarOverflow() {

        onView(withId(R.id.menu_download)).perform(click())
                .inRoot(isPlatformPopup())
                .inRoot(isDialog());
    }

    @Test
    public void testDailog() {
      /*  Espresso.onView(withId(R.id.button1))
                .perform(click()).
                check(matches(isEnabled()));*/

        onView(withText("Yes")).inRoot(isDialog()).withFailureHandler(new FailureHandler() {
            @Override
            public void handle(Throwable error, Matcher<View> viewMatcher){

            }
        }).check(matches(isDisplayed())).perform(click());
    }


}
