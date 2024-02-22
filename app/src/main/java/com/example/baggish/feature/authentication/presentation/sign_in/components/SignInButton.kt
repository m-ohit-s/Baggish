package com.example.baggish.feature.authentication.presentation.sign_in.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.Black,
    buttonItem: @Composable ()-> Unit,
    onClick: ()->Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(buttonColor)    ) {
        buttonItem()
    }
}