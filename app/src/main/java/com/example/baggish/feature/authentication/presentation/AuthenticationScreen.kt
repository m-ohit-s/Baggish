package com.example.baggish.feature.authentication.presentation

import com.example.baggish.feature.authentication.common.Constants

sealed class AuthenticationScreen(val route: String) {
    object SignInScreen: AuthenticationScreen(Constants.SIGN_IN_ROUTE)
    object SignUpScreen: AuthenticationScreen(Constants.SIGN_UP_ROUTE)
}