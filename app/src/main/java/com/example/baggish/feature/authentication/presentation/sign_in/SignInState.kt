package com.example.baggish.feature.authentication.presentation.sign_in

data class SignInState(
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false
)