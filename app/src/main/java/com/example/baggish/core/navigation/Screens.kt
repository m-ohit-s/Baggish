package com.example.baggish.core.navigation

import com.example.baggish.core.common.utils.Constants

sealed class Screens(val route: String) {
    object SplashScreen: Screens(Constants.SPLASH_SCREEN_ROUTE)
    object Login: Screens(Constants.SIGN_IN_ROUTE)
    object SignUp: Screens(Constants.SIGN_UP_ROUTE)
    object MainScreen: Screens(Constants.LANDING_SCREEN_ROUTE)

    object Home: Screens(Constants.HOME_ROUTE)
    object Profile: Screens(Constants.PROFILE_ROUTE)
    object Cart: Screens(Constants.SHOPPING_CART_ROUTE)
    object Categories: Screens(Constants.CATEGORIES_ROUTE)
}
