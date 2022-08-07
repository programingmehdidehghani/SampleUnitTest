package com.amnpardaz.testsamples;

import android.content.Context;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest
{
    private String mName = "tony";
    private final static int ITEMPOSITION =0;



    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);



    @Before
    public void setUp()throws Exception{

    }


    @Test
    public void ensureListViewIsPresent() throws Exception {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(mName));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(mName)));
    }

    @Test
    public void button() throws Exception {
        onView(withId(R.id.button))
                .perform(click()).
                check(matches(isEnabled()));
    }

    @Test
    public void clickItem()  {
   /*     final ViewInteraction check = onView(withId(R.id.tvAnimalName))
                .check(matches((Matcher<? super View>) not((Validator) isDisplayed())));*/
        onView(withId(R.id.rvAnimals))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,
                        click()));
       /* Espresso.onView(withId(R.id.tvAnimalName))
                .check(matches(withText("2")))
                .check(matches(isDisplayed()));*/

    }

    @Test
    public void testScroll(){
        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.rvAnimals);
        Button button = rule.getActivity().findViewById(R.id.button);
        int itemTimeout = recyclerView.getAdapter().getItemCount();
        onView(withId(R.id.rvAnimals)).perform(RecyclerViewActions.scrollToPosition(itemTimeout-1));
    }
    @Test
    public void testScroll23(){
        onView(ViewMatchers.withId(R.id.rvAnimals)).perform(RecyclerViewActions.actionOnItemAtPosition(ITEMPOSITION,click()));
        String itemVal = "Android";
        onView(withText(itemVal)).check(matches(isDisplayed()));
    }

    @Test
    public void testIntent(){
        onView(withId(R.id.button)).perform(click());

    }
}