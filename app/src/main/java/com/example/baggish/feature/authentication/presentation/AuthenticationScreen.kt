package com.example.baggish.feature.authentication.presentation

import com.example.baggish.feature.authentication.common.AuthenticationConstants

sealed class AuthenticationScreen(val route: String) {
    object SignInScreen: AuthenticationScreen(AuthenticationConstants.SIGN_IN_ROUTE)
    object SignUpScreen: AuthenticationScreen(AuthenticationConstants.SIGN_UP_ROUTE)
}