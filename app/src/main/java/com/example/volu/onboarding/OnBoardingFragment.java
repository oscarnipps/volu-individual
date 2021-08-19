package com.example.volu.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.volu.R;
import com.example.volu.databinding.FragmentOnBoardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingFragment extends Fragment {

    private OnBoardingAdapter mOnBoardingAdapter;
    private LinearLayout mOnBoardingIndicator;
    private FragmentOnBoardingBinding mBinding;
    private ViewPager2 mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding, container, false);

        setOnBoardingItem();

        mViewPager = mBinding.onBoardingViewPager;

        mOnBoardingIndicator = mBinding.onBoardingIndicator;

        mViewPager.setAdapter(mOnBoardingAdapter);

        setOnBoardingIndicator();

        setCurrentOnBoardingIndicators(0);

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicators(position);
            }
        });

        mBinding.buttonOnBoardingAction.setOnClickListener(view -> {
            if (mViewPager.getCurrentItem() + 1 < mOnBoardingAdapter.getItemCount()) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                return;
            }

            //todo: go to login /sign up screen
            //startActivity(new Intent(requireActivity(), HomeActivity.class));
        });

        return mBinding.getRoot();
    }

    private void setOnBoardingItem() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem itemFastFood = new OnBoardingItem();
        itemFastFood.setTitle("Choose your meal");
        itemFastFood.setDescription("You can easily choose your meal and take it !");
        itemFastFood.setImage(R.drawable.ic_test);

        OnBoardingItem itemPayOnline = new OnBoardingItem();
        itemPayOnline.setTitle("Choose your payment");
        itemPayOnline.setDescription("You can pay us using any methods, online or offline !");
        itemPayOnline.setImage(R.drawable.ic_test);

        OnBoardingItem itemEatTogether = new OnBoardingItem();
        itemEatTogether.setTitle("Fast delivery");
        itemEatTogether.setDescription("Our delivery partners are too fast, they will not disappoint you !");
        itemEatTogether.setImage(R.drawable.ic_test);

        OnBoardingItem itemDayAndNight = new OnBoardingItem();
        itemDayAndNight.setTitle("Day and Night");
        itemDayAndNight.setDescription("Our service is on day and night !");
        itemDayAndNight.setImage(R.drawable.ic_test);

        onBoardingItems.add(itemFastFood);

        onBoardingItems.add(itemPayOnline);

        onBoardingItems.add(itemEatTogether);

        onBoardingItems.add(itemDayAndNight);

        mOnBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setOnBoardingIndicator() {
        ImageView[] indicators = new ImageView[mOnBoardingAdapter.getItemCount()];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(requireContext());

            indicators[i].setImageDrawable(
                    ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.onboarding_indicator_inactive
                    )
            );

            indicators[i].setLayoutParams(layoutParams);

            mOnBoardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnBoardingIndicators(int index) {
        int childCount = mOnBoardingIndicator.getChildCount();

        for (int i = 0; i < childCount; i++) {

            ImageView imageView = (ImageView) mOnBoardingIndicator.getChildAt(i);

            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.onboarding_indicator_active_two));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.onboarding_indicator_inactive_two));
            }

        }

        if (index == (mOnBoardingAdapter.getItemCount() - 1)) {
            mBinding.buttonOnBoardingAction.setText("Get Started");
        } else {
            mBinding.buttonOnBoardingAction.setText("Next");
        }
    }

}
