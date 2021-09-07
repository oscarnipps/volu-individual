package com.example.volu.ui.authentication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.volu.R;
import com.example.volu.data.Constants;
import com.example.volu.data.Resource;
import com.example.volu.data.SingleLiveEvent;
import com.example.volu.data.ValidationStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import timber.log.Timber;

@HiltViewModel
public class AuthViewModel extends ViewModel {

    private MutableLiveData<Resource<String>> mRegistrationStatus = new MutableLiveData<>();
    private SingleLiveEvent<Map<ValidationStatus, Integer>> mValidationStatus = new SingleLiveEvent<>();
    private Map<ValidationStatus, Integer> mValidationStatusMap = new HashMap<>();


    @Inject
    public AuthViewModel() {
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void validateInputs(Map<Integer, Object> inputsMap) {

        if (inputsMap.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.empty_inputs_error);

            mValidationStatus.setValue(mValidationStatusMap);
            return;
        }

        validateFirstName(inputsMap.get(R.string.first_name));

        validateLastName(inputsMap.get(R.string.last_name));

        validateSex(inputsMap.get(R.string.sex));

        validatePhoneNumber(inputsMap.get(R.string.phone_number));

        validateEmail(inputsMap.get(R.string.email));

        validatePasswords(inputsMap.get(R.string.password), inputsMap.get(R.string.confirm_password));

        setValidationStatus();
    }

    private void setValidationStatus() {
        if (mValidationStatusMap.containsKey(ValidationStatus.ERROR)) {
            mValidationStatus.setValue(mValidationStatusMap);
            return;
        }

        mValidationStatusMap.clear();

        mValidationStatusMap.put(ValidationStatus.SUCCESS, R.string.inputs_validation_success);

        mValidationStatus.setValue(mValidationStatusMap);
    }

    private void validatePasswords(Object passwordValue, Object confirmPasswordValue) {
        String password = (String) passwordValue;

        String confirmPassword = (String) confirmPasswordValue;

        if (password.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.password_input_error);
            return;
        }

        if (confirmPassword.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.confirm_password_input_error);
            return;
        }

        if (!password.equals(confirmPassword)) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.password_mismatch_error);
        }
    }

    private void validateEmail(Object value) {
        String email = (String) value;

        Timber.d("email : %s ", email);

        if (email.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.email_input_error);
            return;
        }

        if (!Pattern.matches(Constants.EMAIL_PATTERN,email)) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.invalid_email_input_error);
        }
    }

    private void validatePhoneNumber(Object value) {
        String phone = (String) value;

        Timber.d("phone : %s ", phone);

        if (phone.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.phone_input_error);
        }
    }

    private void validateSex(Object value) {
        String gender = (String) value;

        Timber.d("selected gender : %s ", gender);

        if (gender.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.sex_input_error);
        }
    }

    private void validateFirstName(Object value) {
        String firstName = (String) value;

        Timber.d("first name is : %s ", firstName);

        if (firstName.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.first_name_input_error);
        }
    }

    private void validateLastName(Object value) {
        String lastName = (String) value;

        Timber.d("last name is : %s ", lastName);

        if (lastName.isEmpty()) {
            mValidationStatusMap.put(ValidationStatus.ERROR, R.string.last_name_input_error);
        }
    }

    public LiveData<Resource<String>> registrationStatus() {
        return mRegistrationStatus;
    }

    public SingleLiveEvent<Map<ValidationStatus, Integer>> validationStatus() {
        return mValidationStatus;
    }
}
