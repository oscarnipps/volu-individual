package com.example.volu_individual.ui.authentication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.util.Preconditions;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;

import com.example.volu_individual.HiltTestActivity;
import com.example.volu_individual.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@HiltAndroidTest
public class SignUpFragmentTest {

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    private SignUpFragment testFragment;

    @Before
    public void setUp() {
        hiltRule.inject();
    }

    private void setUpTestFragmentInContainer(Bundle args) {
        Intent intent = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), HiltTestActivity.class));

        intent.putExtra(
                "androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY",
                R.style.FragmentScenarioEmptyFragmentActivityTheme
        );

        ActivityScenario<HiltTestActivity> activityScenario = ActivityScenario.launch(HiltTestActivity.class);

        activityScenario.onActivity(activity -> {

            testFragment = (SignUpFragment) activity.getSupportFragmentManager().getFragmentFactory().instantiate(
                    Preconditions.checkNotNull(SignUpFragment.class.getClassLoader()), SignUpFragment.class.getName()
            );

            testFragment.setArguments(args);

            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.main_nav_container,
                            testFragment,
                            ""
                    )
                    .commitNow();
        });
    }


    @Test
    public void view_is_shown() {
        Bundle args = new Bundle();

        setUpTestFragmentInContainer(args);

        onView(withId(R.id.capture_image)).check(matches(isDisplayed()));
    }
}
