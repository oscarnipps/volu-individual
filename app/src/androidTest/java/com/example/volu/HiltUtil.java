package com.example.volu;

public class HiltUtil {

/*    @SuppressWarnings("KotlinInternalInJava")
    public static <T extends Fragment> Fragment launchFragmentInHiltContainer(@Nullable Bundle fragmentArgs,
                                                                              int themeResId,
                                                                              Class<T> frag
    ) {


        *//*Intent intent = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), HiltTestActivity.class));

        intent.putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId);

        ActivityScenario<HiltTestActivity> activityScenario = ActivityScenario.launch(HiltTestActivity.class);

        activityScenario.onActivity(activity -> {
            *//**//*activity.getSupportFragmentManager().setFragmentFactory(fragmentFactory);

            Fragment fragment = activity.getSupportFragmentManager();*//**//*

            activity.getSupportFragmentManager().beginTransaction().add(
                    R.id.main_nav_container,
                    frag,
                    fragmentArgs,
                    "")
                    .commitNow();


        });*//*

        Bundle args = new Bundle();

        Intent intent = Intent.makeMainActivity(new ComponentName(ApplicationProvider.getApplicationContext(), HiltTestActivity.class));

        intent.putExtra("androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY",
                R.style.FragmentScenarioEmptyFragmentActivityTheme);

        ActivityScenario<HiltTestActivity> activityScenario = ActivityScenario.launch(HiltTestActivity.class);

        activityScenario.onActivity(activity -> {

            Fragment fragment = activity.getSupportFragmentManager().getFragmentFactory().instantiate(
                    Preconditions.checkNotNull(frag.getClass().getClassLoader()), frag.getClass().getName()
            );

            fragment.setArguments(args);

            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .add(
                            R.id.main_nav_container,
                            fragment,
                            ""
                    )
                    .commitNow();


            //fragment.setUpGenderInputDropDown();
        });

        return frag;
    }*/
}
