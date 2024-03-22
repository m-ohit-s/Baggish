package com.example.baggish.feature.landing_screen.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Logout
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.baggish.R
import com.example.baggish.core.common.utils.session.Session
import com.example.baggish.core.navigation.Graphs
import com.example.baggish.core.navigation.nav_graph.MainNavGraph
import com.example.baggish.feature.landing_screen.presentation.main_screen.components.BottomNavBar
import com.example.baggish.feature.landing_screen.presentation.main_screen.components.LogoutBottomSheet
import com.example.baggish.feature.landing_screen.presentation.main_screen.components.NavDrawerHeaderWithAuth
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
){
    val session = mainViewModel.session.collectAsState(Session())
    mainViewModel.getActiveSession()
    val navHostController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    if(mainViewModel.sessionState.value.destroySession){
        rootNavHostController.navigate(Graphs.Auth.route){
            popUpTo(rootNavHostController.graph.id){
                inclusive = true
            }
            popUpTo(navHostController.graph.id){
                inclusive = true
            }
        }
    }
    if(isSheetOpen){
        LogoutBottomSheet(
            modifier = Modifier.height(200.dp),
            onDismiss = { isSheetOpen = false },
            onYes = {
                mainViewModel.clearSession()
                mainViewModel.logout()
            },
            onNo = { isSheetOpen = false},
            sheetState = sheetState
        )
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavDrawerHeaderWithAuth(name = session.value.user.firstName)
                NavigationDrawerItem(
                    label = {
                        Text(text = "Logout")
                            },
                    selected = false,
                    onClick = {
                              isSheetOpen = true
                    },
                    icon= {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.Logout,
                            contentDescription = null
                        )
                    }
                )
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.inversePrimary),
                    title = {
                        Icon(
                            imageVector = Icons.Filled.LocalMall,
                            contentDescription = stringResource(
                                id = R.string.brand_logo_description
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch {
                            drawerState.open()
                        } }) {
                            Icon(
                                imageVector = Icons.Filled.ClearAll,
                                contentDescription = stringResource(
                                    id = R.string.menu_icon_desc
                                )
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = stringResource(
                                    id = R.string.search_icon_desc
                                )
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = stringResource(
                                    id = R.string.notification_icon_desc
                                )
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Rounded.FavoriteBorder,
                                contentDescription = stringResource(
                                    id = R.string.wishlist_icon_desc
                                )
                            )
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    BottomNavBar(navController = navHostController)
                }
            },
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(
                        PaddingValues(
                            0.dp,
                            0.dp,
                            0.dp,
                            it.calculateBottomPadding()
                        )
                    )
            ) {
                MainNavGraph(navHostController = navHostController)
            }
        }
    }
}