package com.example.baggish.feature.landing_screen.presentation.main_screen.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(modifier: Modifier=Modifier, navController: NavHostController){
    val selectedTebIndex = remember {
       mutableIntStateOf(0)
    }
    val currentTabRoute = remember {
        mutableStateOf(NavigationItem.Home.route)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()


    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Categories,
        NavigationItem.ShoppingCart,
        NavigationItem.Profile
    )

    NavigationBar(modifier = modifier) {
        items.forEachIndexed{ index, item->
            println("nav back stack" + navBackStackEntry?.destination?.route)
            NavigationBarItem(
                selected = item.route == navBackStackEntry?.destination?.route,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                icon = {
                    if(selectedTebIndex.intValue == index){
                        Icon(imageVector = item.tabItem.selectedIcon, contentDescription = null)
                    }
                    else{
                        Icon(imageVector = item.tabItem.unSelectedIcon, contentDescription = null)
                    }
                },
                alwaysShowLabel = true,
                label = { Text(text = item.tabItem.title) }
            )
        }
    }
}