package com.example.baggish.core.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.baggish.SplashScreen
import com.example.baggish.core.navigation.Graphs
import com.example.baggish.core.navigation.Screens

fun NavGraphBuilder.splashNavGraph(navHostController: NavHostController){
    navigation(startDestination = Screens.SplashScreen.route, route = Graphs.Splash.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
    }
}