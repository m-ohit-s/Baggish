package com.example.baggish.core.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baggish.core.navigation.Graphs
import com.example.baggish.core.navigation.Screens
import com.example.baggish.feature.landing_screen.presentation.cart.CartScreen
import com.example.baggish.feature.landing_screen.presentation.categories.CategoriesScreen
import com.example.baggish.feature.landing_screen.presentation.home.HomeScreen
import com.example.baggish.feature.landing_screen.presentation.profile.ProfileScreen

@Composable
fun MainNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = Screens.Home.route, route= Graphs.Main.route){
        composable(Screens.Home.route){
            HomeScreen()
        }
        composable(Screens.Categories.route){
            CategoriesScreen()
        }
        composable(Screens.Profile.route){
            ProfileScreen()
        }
        composable(Screens.Cart.route){
            CartScreen()
        }
    }
}