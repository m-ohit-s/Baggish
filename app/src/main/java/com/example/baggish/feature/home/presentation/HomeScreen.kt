package com.example.baggish.feature.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Text(text = "Hello Home", modifier=modifier.fillMaxSize())
}