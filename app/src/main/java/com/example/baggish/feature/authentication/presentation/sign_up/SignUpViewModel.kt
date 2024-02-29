package com.example.baggish.feature.authentication.presentation.sign_up

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baggish.feature.authentication.domain.use_case.ValidateConfirmPassword
import com.example.baggish.feature.authentication.domain.use_case.ValidateEmail
import com.example.baggish.feature.authentication.domain.use_case.ValidateFirstName
import com.example.baggish.feature.authentication.domain.use_case.ValidatePassword
import com.example.baggish.feature.authentication.domain.use_case.ValidateTerms
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val validateFirstName: ValidateFirstName,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateConfirmPassword: ValidateConfirmPassword,
    private val validateTerms: ValidateTerms
) : ViewModel() {

    private var _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: SignUpFormEvent){
        when(event){
            is SignUpFormEvent.FirstNameChanged ->{
                _state.value = _state.value.copy(firstName = event.firstName)
            }
            is SignUpFormEvent.LastNameChanged ->{
                _state.value = _state.value.copy(lastName = event.lastName)
            }
            is SignUpFormEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is SignUpFormEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is SignUpFormEvent.ConfirmPasswordChanged -> {
                _state.value = _state.value.copy(confirmPassword = event.confirmPassword)
            }
            is SignUpFormEvent.AcceptedTerms -> {
                _state.value = _state.value.copy(acceptedTerms = event.isAccepted)
            }
            is SignUpFormEvent.PasswordVisibilityChanged -> {
                _state.value = _state.value.copy(passwordVisible = event.toggle)
            }
            is SignUpFormEvent.ConfirmPasswordVisibilityChanged -> {
                _state.value = _state.value.copy(confirmPasswordVisible = event.toggle)
            }
            is SignUpFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData(){
        val firstNameResult = validateFirstName.execute(state.value.firstName)
        val emailResult = validateEmail.execute(state.value.email)
        val passwordResult = validatePassword.execute(state.value.password)
        val confirmPasswordResult = validateConfirmPassword.execute(state.value.password, state.value.confirmPassword)
        val termsResult = validateTerms.execute(state.value.acceptedTerms)

        val hasError = listOf(
            firstNameResult,
            emailResult,
            passwordResult,
            confirmPasswordResult,
            termsResult
        ).any{
            !it.successful
        }

        if(hasError){
            _state.value = _state.value.copy(
                firstNameError = firstNameResult.errorMessage,
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                confirmPasswordError = confirmPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }
}