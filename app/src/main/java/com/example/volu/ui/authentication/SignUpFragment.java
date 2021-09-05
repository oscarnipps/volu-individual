package com.example.volu.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.volu.R;
import com.example.volu.data.Resource;
import com.example.volu.data.ValidationStatus;
import com.example.volu.databinding.FragmentSignUpBinding;

import java.util.HashMap;
import java.util.Map;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding mBinding;
    private NavController mNavController;
    private AuthViewModel authViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        mBinding.register.setOnClickListener(v -> mNavController.navigate(R.id.navigate_to_main_fragment));

        mBinding.register.setOnClickListener(v -> validateUserInputs());

        return mBinding.getRoot();
    }

    private void validateUserInputs() {
        authViewModel.validateInputs(getTheInputs());
    }

    private Map<Integer, Object> getTheInputs() {
        Map<Integer, Object> inputsMap = new HashMap<>();

        String firstName = mBinding.userInfoLayout.firstName.getText().toString().trim();

        String lastName = mBinding.userInfoLayout.lastName.getText().toString().trim();

        String sex = mBinding.userInfoLayout.sex.getText().toString().trim();

        String email = mBinding.userInfoLayout.email.getText().toString().trim();

        String phone = mBinding.userInfoLayout.phone.getText().toString().trim();

        String password = mBinding.userInfoLayout.password.getText().toString().trim();

        String confirmPassword = mBinding.userInfoLayout.confirmPassword.getText().toString().trim();

        inputsMap.put(R.string.first_name, firstName);

        inputsMap.put(R.string.last_name, lastName);

        inputsMap.put(R.string.sex, sex);

        inputsMap.put(R.string.email, email);

        inputsMap.put(R.string.phone_number, phone);

        inputsMap.put(R.string.password, password);

        inputsMap.put(R.string.confirm_password, confirmPassword);

        return inputsMap;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);

        setUpGenderInputDropDown();

        authViewModel.registrationStatus().observe(getViewLifecycleOwner(), this::registrationStatusObserver);

        authViewModel.validationStatus().observe(getViewLifecycleOwner(), this::validationStatusObserver);

    }

    private void setUpGenderInputDropDown() {
        String[] genderItems = requireActivity().getResources().getStringArray(R.array.gender_list);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(requireContext(), R.layout.gender_list_item, genderItems);

        ((AutoCompleteTextView) mBinding.userInfoLayout.sexContainer.getEditText()).setAdapter(genderAdapter);
    }

    private void registrationStatusObserver(Resource<String> result) {
        switch (result.status) {
            case LOADING:

                break;

            case ERROR:

                break;

            case SUCCESS:
                //todo: show successful registration dialog which navigate to the preference list fragment
                break;
        }
    }

    private void validationStatusObserver(Map<ValidationStatus, Integer> status) {
        if (status.containsKey(ValidationStatus.SUCCESS)) {

            Timber.d("input validation successful");

            //todo: api call to register user

            return;
        }


        Integer messageResId = status.get(ValidationStatus.ERROR);

        String message = getString(messageResId);

        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();

        Timber.d("validation not successful with message : %s ", message);

/*        if (status.containsKey(ValidationStatus.ERROR)) {

            Integer messageResId = status.get(ValidationStatus.ERROR);

            String message = getString(messageResId);

            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();

            Timber.d("validation not successful with message : %s ", message);

            return;
        }

        Timber.d("input validation successful");
        //todo: api call to register user*/
    }
}
