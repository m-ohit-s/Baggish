package com.example.baggish.feature.authentication.presentation.sign_in

sealed class SignInFormEvent {
    data class EmailChanged(val email: String): SignInFormEvent()
    data class PasswordChanged(val password: String): SignInFormEvent()
    data class PasswordVisibilityChanged(val toggle: Boolean): SignInFormEvent()
    object Login: SignInFormEvent()
}