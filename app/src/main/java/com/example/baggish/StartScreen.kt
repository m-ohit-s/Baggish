package com.example.baggish

import com.example.baggish.feature.authentication.common.AuthenticationConstants

sealed class StartScreen(
    val route: String
) {
    object SplashScreen: StartScreen(AuthenticationConstants.SPLASH_SCREEN_ROUTE)
}