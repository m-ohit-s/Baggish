package com.example.baggish.feature.landing_screen.presentation.main_screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import com.example.baggish.core.navigation.Screens
import com.example.baggish.feature.landing_screen.common.MainScreenConstants

sealed class NavigationItem(val route: String, val tabItem: TabItem) {
    object Home: NavigationItem(
        Screens.Home.route,
        TabItem(MainScreenConstants.HOME_TITLE, Icons.Outlined.Home, Icons.Filled.Home)
    )

    object Categories: NavigationItem(
        Screens.Categories.route,
        TabItem(MainScreenConstants.CATEGORIES_TITLE, Icons.Outlined.Category, Icons.Filled.Category)
    )

    object Profile: NavigationItem(
        Screens.Profile.route,
        TabItem(MainScreenConstants.PROFILE_TITLE, Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle)
    )
    object ShoppingCart: NavigationItem(
        Screens.Cart.route,
        TabItem(MainScreenConstants.SHOPPING_CART_TITLE, Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart)
    )
}