package com.example.volu_individual.authentication;

import androidx.annotation.StringRes;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.volu_individual.LiveDataTestUtil;
import com.example.volu_individual.R;
import com.example.volu_individual.data.ValidationStatus;
import com.example.volu_individual.ui.authentication.AuthViewModel;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthViewModelTest {

    private AuthViewModel authViewModel;

    private Map<Integer,Object> inputsMap;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    @Before
    public void setUp() {
        authViewModel = new AuthViewModel();
        inputsMap = getInputMap();
    }

    @After
    public void cleanUp() {
        inputsMap.clear();
    }

    @NotNull
    private Map<Integer, Object> getInputMap() {
        Map<Integer, Object> inputsMap = new HashMap<>();

        inputsMap.put(R.string.first_name, "oscar");

        inputsMap.put(R.string.last_name, "ekesiobi");

        inputsMap.put(R.string.sex, "male");

        inputsMap.put(R.string.email, "oscar@gmail.com");

        inputsMap.put(R.string.phone_number, "09090356771");

        inputsMap.put(R.string.password, "12345");

        inputsMap.put(R.string.confirm_password, "12345");

        return inputsMap;
    }

    @Test
    public void empty_inputs_show_validation_error_message() throws InterruptedException {
        Map<Integer, Object> emptyInputMap = new HashMap<>();

        authViewModel.validateInputs(emptyInputMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.empty_inputs_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_first_name_show_validation_error_message() throws InterruptedException {
        inputsMap.put(R.string.first_name,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.first_name_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_last_name_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.last_name,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.last_name_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_sex_input_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.sex,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.sex_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_phone_number_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.phone_number,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.phone_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_email_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.email,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.email_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_password_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.password,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.password_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

    @Test
    public void invalid_confirm_password_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.confirm_password,"");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.confirm_password_input_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }


    @Test
    public void password_mismatch_show_validation_error_message() throws InterruptedException {
        inputsMap.replace(R.string.password,"1234");

        inputsMap.replace(R.string.confirm_password,"4321");

        authViewModel.validateInputs(inputsMap);

        Map<ValidationStatus, Integer> validationInputMap = LiveDataTestUtil.getOrAwaitValue(authViewModel.validationStatus());

        @StringRes Integer expectedMessageResId = R.string.password_mismatch_error;

        @StringRes Integer actualMessageResId = validationInputMap.get(ValidationStatus.ERROR);

        assertEquals(expectedMessageResId, actualMessageResId);
    }

}
