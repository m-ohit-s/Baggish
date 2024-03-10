package com.example.baggish.feature.authentication.presentation.sign_up

import com.example.baggish.feature.authentication.data.model.RegisterUser

data class RegistrationState(
    val isLoading: Boolean = false,
    val user: RegisterUser = RegisterUser(),
    val error: String = ""
)
