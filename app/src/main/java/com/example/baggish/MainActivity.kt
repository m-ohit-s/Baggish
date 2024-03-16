package com.example.baggish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.baggish.core.navigation.NavGraph
import com.example.baggish.feature.landing_screen.presentation.main_screen.MainScreen
import com.example.baggish.ui.theme.BaggishTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaggishTheme {
                window.statusBarColor = MaterialTheme.colorScheme.inversePrimary.toArgb()
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
    NavGraph(navHostController = navController)
}