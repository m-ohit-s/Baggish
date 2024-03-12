package com.example.baggish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baggish.feature.authentication.presentation.AuthenticationScreen
import com.example.baggish.feature.authentication.presentation.sign_in.SignInScreen
import com.example.baggish.feature.authentication.presentation.sign_up.SignUpScreen
import com.example.baggish.feature.home.presentation.HomeScreen
import com.example.baggish.feature.home.presentation.Screen
import com.example.baggish.ui.theme.BaggishTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaggishTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.inversePrimary
                ) {
                    StartApp()
                }
            }
        }
    }
}

@Composable
fun StartApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = StartScreen.SplashScreen.route){
        composable(StartScreen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(AuthenticationScreen.SignInScreen.route){
            SignInScreen(navController = navController)
        }
        composable(AuthenticationScreen.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen()
        }
    }
}