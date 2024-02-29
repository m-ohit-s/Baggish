package com.example.baggish.feature.authentication.presentation.sign_up

sealed class SignUpFormEvent {
    data class FirstNameChanged(val firstName: String): SignUpFormEvent()
    data class LastNameChanged(val lastName: String): SignUpFormEvent()
    data class EmailChanged(val email: String): SignUpFormEvent()
    data class PasswordChanged(val password: String): SignUpFormEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String): SignUpFormEvent()
    data class AcceptedTerms(val isAccepted: Boolean): SignUpFormEvent()
    data class PasswordVisibilityChanged(val toggle: Boolean): SignUpFormEvent()
    data class ConfirmPasswordVisibilityChanged(val toggle: Boolean): SignUpFormEvent()
    object Submit: SignUpFormEvent()
}