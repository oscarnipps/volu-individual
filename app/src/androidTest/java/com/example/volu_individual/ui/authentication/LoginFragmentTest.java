package com.example.volu_individual.ui.authentication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.util.Preconditions;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.action.ViewActions;

import com.example.volu_individual.HiltTestActivity;
import com.example.volu_individual.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@HiltAndroidTest
public class LoginFragmentTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    private LoginFragment  testFragment;

    @Before
    public void setUp() {
        hiltRule.inject();
    }


    private void setUpTestFragmentInContainer(Bundle args , Class<?> testFrag) {
        Intent intent = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), HiltTestActivity.class));

        intent.putExtra(
                "androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY",
                R.style.FragmentScenarioEmptyFragmentActivityTheme
        );

        ActivityScenario<HiltTestActivity> activityScenario = ActivityScenario.launch(HiltTestActivity.class);

        activityScenario.onActivity(activity -> {

            testFragment = (LoginFragment) activity.getSupportFragmentManager().getFragmentFactory().instantiate(
                    Preconditions.checkNotNull(testFrag.getClassLoader()), testFrag.getName()
            );

            testFragment.setArguments(args);

            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            android.R.id.content,
                            testFragment,
                            ""
                    )
                    .commitNow();

            TestNavHostController navController = new TestNavHostController(ApplicationProvider.getApplicationContext());

            navController.setGraph(R.navigation.main_nav_graph);

            Navigation.setViewNavController(testFragment.requireView(),navController);

        });
    }


    @Test
    public void login_view_is_visible() {
        TestNavHostController navController = new TestNavHostController(ApplicationProvider.getApplicationContext());

        //Bundle args = new Bundle();

        setUpTestFragmentInContainer(null,LoginFragment.class);

        //navController.setGraph(R.navigation.main_nav_graph);

        Navigation.setViewNavController(testFragment.requireView(),navController);

        onView(withId(R.id.sign_up)).perform(ViewActions.click());

        //onView(withId(R.id.title)).check(matches(isDisplayed()));
    }

}