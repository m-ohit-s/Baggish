package com.example.baggish.feature.authentication.presentation.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baggish.R
import com.example.baggish.core.presentation.components.BrandDesign
import com.example.baggish.feature.authentication.presentation.sign_up.components.SignUpButton
import com.example.baggish.feature.authentication.presentation.sign_up.components.SignUpEntryField
import com.example.baggish.ui.theme.BaggishTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BrandDesign()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SignUpEntryField(
                    text = stringResource(id = R.string.sign_up_first_name),
                    onValueChange = {}
                )
                SignUpEntryField(
                    text = stringResource(id = R.string.sign_up_last_name),
                    onValueChange = {}
                )
                SignUpEntryField(
                    text = stringResource(id = R.string.sign_up_email),
                    onValueChange = {},
                    isEmail = true
                )
                SignUpEntryField(
                    text = stringResource(id = R.string.sign_up_password),
                    onValueChange = {},
                    isPassword = true
                )
                SignUpEntryField(
                    text = stringResource(id = R.string.sign_up_confirm_password),
                    onValueChange = {},
                    isPassword = true
                )
                Column(modifier = Modifier.padding(80.dp, 30.dp)) {
                    SignUpButton(
                        buttonItem = {
                            Text(
                                text = stringResource(id = R.string.sign_up_button),
                                color = Color.White,
                            )
                        },
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Text(
                    text = stringResource(id = R.string.move_to_sign_in),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreviewWithoutTheme(){
        SignUpScreen()
}

@Preview
@Composable
fun SignUpScreenPreviewWithTheme(){
    BaggishTheme {
        SignUpScreen()
    }
}