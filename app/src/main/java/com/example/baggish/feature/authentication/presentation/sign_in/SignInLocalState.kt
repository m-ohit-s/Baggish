package com.example.baggish.feature.authentication.presentation.sign_in

data class SignInLocalState(
    val firstName: String = "",
    val firstNameError: String? = null,
    val lastName: String = "",
    val lastNameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String ?= null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val acceptedTerms: Boolean = false,
    val termsError: Boolean? = null,
)