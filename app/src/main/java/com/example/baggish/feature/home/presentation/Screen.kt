package com.example.baggish.feature.home.presentation

import com.example.baggish.feature.home.common.Constants


sealed class Screen(val route: String) {
    object HomeScreen: Screen(Constants.HOME_SCREEN)
}