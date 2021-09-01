package com.example.volu.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.volu.R;
import com.example.volu.databinding.FragmentSignUpBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding mBinding;
    private NavController mNavController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false);

        mBinding.register.setOnClickListener(v -> mNavController.navigate(R.id.navigate_to_main_fragment));

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);

        setUpGenderInputDropDown();

    }

    private void setUpGenderInputDropDown() {
        String[] genderItems = requireActivity().getResources().getStringArray(R.array.gender_list);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(requireContext(),R.layout.gender_list_item,genderItems);

        ((AutoCompleteTextView) mBinding.userInfoLayout.sexContainer.getEditText()).setAdapter(genderAdapter);
    }
}
