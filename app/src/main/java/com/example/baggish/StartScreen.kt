package com.example.baggish

import com.example.baggish.feature.authentication.common.Constants

sealed class StartScreen(
    val route: String
) {
    object SplashScreen: StartScreen(Constants.SPLASH_SCREEN_ROUTE)
}