package com.example.baggish.feature.authentication.presentation.sign_up.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baggish.ui.theme.BaggishTheme

@Composable
fun SignUpEntryField(
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

@Preview
@Composable
fun SignUpEntryFieldPreview(){
    BaggishTheme {
        SignUpEntryField(text = "Test", onValueChange = {})
    }
}