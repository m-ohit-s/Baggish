package com.example.baggish.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baggish.core.navigation.nav_graph.authNavGraph
import com.example.baggish.feature.landing_screen.presentation.main_screen.MainScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Graphs.Auth.route,
        route = Graphs.Root.route
    ) {
        authNavGraph(navHostController)
        composable(route = Graphs.Main.route){
            MainScreen(rootNavHostController = navHostController)
        }
    }
}