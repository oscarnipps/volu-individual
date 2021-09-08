package com.example.volu_individual.ui.onboarding;

import android.content.res.TypedArray;
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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.volu_individual.R;
import com.example.volu_individual.databinding.FragmentOnBoardingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingFragment extends Fragment {

    private OnBoardingAdapter mOnBoardingAdapter;
    private LinearLayout mOnBoardingIndicator;
    private FragmentOnBoardingBinding mBinding;
    private ViewPager2 mViewPager;
    private NavController mNavController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding, container, false);

        mViewPager = mBinding.onBoardingViewPager;

        mOnBoardingIndicator = mBinding.onBoardingIndicator;

        setOnBoardingItems();

        mViewPager.setAdapter(mOnBoardingAdapter);

        setOnBoardingIndicators();

        setCurrentOnBoardingItemIndicator(0);

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingItemIndicator(position);
            }
        });

        mBinding.buttonOnBoardingAction.setOnClickListener(view -> {
            if (mViewPager.getCurrentItem() + 1 < mOnBoardingAdapter.getItemCount()) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                return;
            }

            mNavController.navigate(R.id.navigate_to_login);
        });

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);
    }

    private void setOnBoardingItems() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        String[] onBoardingTitles = getResources().getStringArray(R.array.on_boarding_titles);

        String[] onBoardingDescriptions = getResources().getStringArray(R.array.on_boarding_descriptions);

        TypedArray onBoardingImages = getResources().obtainTypedArray(R.array.on_boarding_images);


        for (int i = 0; i < onBoardingTitles.length; i++) {
            OnBoardingItem item = new OnBoardingItem();

            item.setTitle(onBoardingTitles[i]);

            item.setDescription(onBoardingDescriptions[i]);

            item.setImage(onBoardingImages.getDrawable(i));

            onBoardingItems.add(item);
        }

        mOnBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setOnBoardingIndicators() {
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

    private void setCurrentOnBoardingItemIndicator(int index) {
        int childCount = mOnBoardingIndicator.getChildCount();

        for (int i = 0; i < childCount; i++) {

            ImageView imageView = (ImageView) mOnBoardingIndicator.getChildAt(i);

            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.onboarding_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.onboarding_indicator_inactive));
            }

        }

        mBinding.buttonOnBoardingAction.setText(getResId(index));
    }

    private int getResId(int index) {
        //if it's the last item then use "get started" as the text
        return index == (mOnBoardingAdapter.getItemCount() - 1) ? R.string.get_started : R.string.next;
    }

}
