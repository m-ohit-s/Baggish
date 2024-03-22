package com.example.baggish.core.navigation

import com.example.baggish.core.common.utils.Constants

sealed class Graphs(val route: String) {
    object Root: Graphs(Constants.ROOT)
    object Auth: Graphs(Constants.AUTH)
    object Main: Graphs(Constants.APP)
    object Splash: Graphs(Constants.SPLASH)
}