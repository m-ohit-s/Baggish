package com.example.baggish.feature.authentication.presentation.sign_in

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baggish.R
import com.example.baggish.core.presentation.components.BrandDesign
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInButton
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInEntryField
import com.example.baggish.feature.authentication.presentation.sign_up.components.SignUpButton
import com.example.baggish.ui.theme.BaggishTheme

@Composable
fun SignInScreen(
    modifier: Modifier=Modifier
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BrandDesign()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                SignInEntryField(
                    text = stringResource(id = R.string.sign_in_email),
                    onValueChange = {},
                    isEmail = true
                )
                SignInEntryField(
                    text = stringResource(id = R.string.sign_in_password),
                    onValueChange = {},
                    isPassword = true
                )
                Column(modifier = Modifier.padding(80.dp, 30.dp)) {
                    SignInButton(
                        buttonItem = {
                            Text(
                                text = stringResource(id = R.string.sign_in_button),
                                color = Color.White,
                            )
                        },
                        onClick = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row {
                    Text(
                        text = stringResource(id = R.string.move_to_sign_up_text),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = stringResource(id = R.string.move_to_sign_up_button_text),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.clickable {  }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreviewWithoutTheme(){
    SignInScreen()
}
@Preview
@Composable
fun SignInScreenPreviewWithTheme(){
    BaggishTheme {
        SignInScreen()
    }
}