package com.example.baggish.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baggish.core.navigation.nav_graph.authNavGraph
import com.example.baggish.core.navigation.nav_graph.splashNavGraph
import com.example.baggish.feature.landing_screen.presentation.main_screen.MainScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Graphs.Splash.route,
        route = Graphs.Root.route
    ) {
        splashNavGraph(navHostController)
        authNavGraph(navHostController)
        composable(route = Graphs.Main.route){
            MainScreen(rootNavHostController = navHostController)
        }
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(
    navHostController: NavHostController
): T{
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(key1 = this) {
        navHostController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}