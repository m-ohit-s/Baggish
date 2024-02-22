package com.example.baggish.feature.authentication.presentation.sign_in.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SignInEntryField(
    modifier: Modifier=Modifier,
    text: String,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    onValueChange: (String)-> Unit
){
    TextField(
        value = "",
        onValueChange = onValueChange,
        label = {
            Text(text = text)
        },
        singleLine = true,
        modifier = modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        keyboardOptions = if(isPassword)
            KeyboardOptions(keyboardType = KeyboardType.Password)
        else if(isEmail)
            KeyboardOptions(keyboardType = KeyboardType.Email)
        else
            KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}