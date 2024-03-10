package com.example.baggish.feature.authentication.presentation.sign_in

data class SignInState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val passwordVisible: Boolean = false
)