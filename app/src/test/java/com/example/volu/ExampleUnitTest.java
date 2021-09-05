/*
package com.example.volu.ui.authentication;

import android.util.Patterns;

import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.volu.R;
import com.example.volu.data.Resource;
import com.example.volu.data.SingleLiveEvent;
import com.example.volu.data.ValidationStatus;

import java.util.HashMap;
import java.util.Map;

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


    //empty inputs validation failed with error message
    //valid inputs validated successfully
    //invalid inputs validation failed with error message
    public void validateInputs(Map<Integer, Object> inputsMap) {

        if (inputsMap.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.empty_inputs_error);
            return;
        }

        for (Map.Entry<Integer, Object> inputEntry : inputsMap.entrySet()) {

            switch (inputEntry.getKey()) {

                case R.string.first_name:
                    validateFirstName(inputsMap.get(R.string.first_name));
                    break;

                case R.string.last_name:
                    validateLastName(inputsMap.get(R.string.last_name));
                    break;

                case R.string.sex:
                    validateSex(inputsMap.get(R.string.sex));
                    break;

                case R.string.phone_number:
                    validatePhoneNumber(inputsMap.get(R.string.phone_number));
                    break;

                case R.string.email:
                    validateEmail(inputsMap.get(R.string.email));
                    break;

                case R.string.password:

                case R.string.confirm_password:
                    validatePasswords(inputsMap.get(R.string.password), inputsMap.get(R.string.confirm_password));
                    break;
            }
        }

        if (!mValidationStatusMap.containsKey(ValidationStatus.ERROR)) {
            Timber.d("validation success");

            setValidationStatus(ValidationStatus.SUCCESS, R.string.inputs_validation_success);
        }
    }

    private void validatePasswords(Object passwordValue, Object confirmPasswordValue) {
        String password = (String) passwordValue;

        Timber.d("password : %s ", password);

        String confirmPassword = (String) confirmPasswordValue;

        Timber.d("confirm password : %s ", confirmPassword);

        if (password.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.password_input_error);
            return;
        }

        if (confirmPassword.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.confirm_password_input_error);
            return;
        }

        if (!password.equals(confirmPassword)) {
            setValidationStatus(ValidationStatus.ERROR, R.string.password_mismatch_error);
        }
    }

    private void validateEmail(Object value) {
        String email = (String) value;

        Timber.d("email : %s ", email);

        if (email.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.email_input_error);
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.invalid_email_input_error);
        }
    }

    private void validatePhoneNumber(Object value) {
        String phone = (String) value;

        Timber.d("phone : %s ", phone);

        if (phone.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.phone_input_error);
        }
    }

    private void validateSex(Object value) {
        String gender = (String) value;

        Timber.d("selected gender : %s ", gender);

        if (gender.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.sex_input_error);
        }
    }

    private void validateFirstName(Object value) {
        String firstName = (String) value;

        Timber.d("first name is : %s ", firstName);

        if (firstName.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.first_name_input_error);
        }
    }

    private void validateLastName(Object value) {
        String lastName = (String) value;

        Timber.d("last name is : %s ", lastName);

        if (lastName.isEmpty()) {
            setValidationStatus(ValidationStatus.ERROR, R.string.last_name_input_error);
        }
    }


*/
/*    private boolean isPhoneInputValid(Object value) {
        String phone = (String) value;

        Timber.d("phone : %s ", phone);

        return !phone.isEmpty();
    }

    private boolean isSexInputValid(Object value) {
        String gender = (String) value;

        Timber.d("selected gender : %s ", gender);

        return !gender.isEmpty();
    }

    private boolean isLastNameValid(Object value) {
        String lastName = (String) value;

        Timber.d("last name : %s ", lastName);

        return !lastName.isEmpty();
    }

    private boolean isFirstNameValid(Object value) {
        String firstName = (String) value;

        Timber.d("first name is : %s ", firstName);

        return !firstName.isEmpty();
    }*//*


    private void setValidationStatus(ValidationStatus status, @StringRes int messageResId) {
        mValidationStatusMap.clear();

        Timber.d("input field map updated");

        mValidationStatusMap.put(status, messageResId);

        mValidationStatus.setValue(mValidationStatusMap);
    }

    public LiveData<Resource<String>> registrationStatus() {
        return mRegistrationStatus;
    }

    public SingleLiveEvent<Map<ValidationStatus, Integer>> validationStatus() {
        return mValidationStatus;
    }
}
*/
