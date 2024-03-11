package com.example.baggish.feature.authentication.presentation.sign_in

import com.example.baggish.feature.authentication.data.model.LoginUser

data class LoginState(
    val isLoading: Boolean = false,
    val user: LoginUser = LoginUser(),
    val error: String = ""
)