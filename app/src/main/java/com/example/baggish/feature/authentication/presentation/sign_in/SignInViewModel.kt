package com.example.baggish.feature.authentication.presentation.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baggish.core.common.utils.Constants
import com.example.baggish.core.common.utils.Resource
import com.example.baggish.feature.authentication.data.model.LoginUser
import com.example.baggish.feature.authentication.domain.model.LoginUserDomain
import com.example.baggish.feature.authentication.domain.use_case.Login
import com.example.baggish.feature.authentication.domain.use_case.ValidateEmail
import com.example.baggish.feature.authentication.domain.use_case.ValidatePasswordSignIn
import com.example.baggish.feature.authentication.presentation.sign_up.ValidationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePasswordSignIn: ValidatePasswordSignIn,
    private val login: Login
) : ViewModel() {
    private var _state = mutableStateOf(SignInState())
    var state: State<SignInState> = _state

    private var _loginState = mutableStateOf(LoginState())
    var loginState: State<LoginState> = _loginState

    private val validationEventChannel = Channel<ValidationEvent>()
    var validationEvents =validationEventChannel.receiveAsFlow()

    fun onEvent(event: SignInFormEvent){
        when(event){
            is SignInFormEvent.EmailChanged -> {
                _state.value = _state.value.copy(email = event.email)
            }
            is SignInFormEvent.PasswordChanged -> {
                _state.value = _state.value.copy(password = event.password)
            }
            is SignInFormEvent.PasswordVisibilityChanged -> {
                _state.value = _state.value.copy(passwordVisible = event.toggle)
            }
            is SignInFormEvent.Login -> {
                submitData()
            }
        }
    }

    fun loginToDB(user: LoginUserDomain){
        login(user).onEach {result->
            when(result){
                is Resource.Success -> {
                    _loginState.value = LoginState(user = result.data ?: LoginUser())
                }
                is Resource.Loading -> {
                    _loginState.value = LoginState(isLoading = true)
                }
                is Resource.Error -> {
                    _loginState.value = LoginState(error = result.message?: Constants.UNEXPECTED_ERROR)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun submitData(){
        val emailResult = validateEmail.execute(state.value.email)
        val passwordResult = validatePasswordSignIn.execute(state.value.password)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any {
            !it.successful
        }

        if(hasError){
            _state.value = _state.value.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }
}