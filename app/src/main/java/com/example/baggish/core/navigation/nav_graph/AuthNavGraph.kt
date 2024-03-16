package com.example.baggish.core.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.baggish.SplashScreen
import com.example.baggish.core.navigation.Graphs
import com.example.baggish.core.navigation.Screens
import com.example.baggish.feature.authentication.presentation.sign_in.SignInScreen
import com.example.baggish.feature.authentication.presentation.sign_up.SignUpScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController){
    navigation(startDestination = Screens.SplashScreen.route, route = Graphs.Auth.route){
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
        composable(Screens.Login.route){
            SignInScreen(navController = navHostController)
        }
        composable(Screens.SignUp.route) {
            SignUpScreen(navController = navHostController)
        }
    }
}