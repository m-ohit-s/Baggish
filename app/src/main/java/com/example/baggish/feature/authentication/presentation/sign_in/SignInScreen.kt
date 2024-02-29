package com.example.baggish.feature.authentication.presentation.sign_in

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.baggish.R
import com.example.baggish.core.presentation.components.BrandDesign
import com.example.baggish.feature.authentication.common.TextFieldKeyboardType
import com.example.baggish.feature.authentication.presentation.AuthenticationScreen
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInButton
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInEntryField

@Composable
fun SignInScreen(
    navController: NavController,
    modifier: Modifier=Modifier
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        val signInViewModel = viewModel<SignInViewModel>()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BrandDesign()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                SignInEntryField(
                    label = stringResource(id = R.string.sign_in_email),
                    value = signInViewModel.state.email,
                    onValueChange = {
                        signInViewModel.state = signInViewModel.state.copy(email=it)
                    },
                    textFieldKeyboardType = TextFieldKeyboardType.EMAIL
                )
                SignInEntryField(
                    label = stringResource(id = R.string.sign_in_password),
                    value = signInViewModel.state.password,
                    onValueChange = {
                        signInViewModel.state = signInViewModel.state.copy(password = it)
                    },
                    textFieldKeyboardType = if(signInViewModel.state.passwordVisibility) TextFieldKeyboardType.TEXT else TextFieldKeyboardType.PASSWORD,
                    suffix = {
                        if(signInViewModel.state.passwordVisibility)
                            Icon(
                                imageVector = Icons.Rounded.VisibilityOff,
                                contentDescription = null,
                                Modifier.clickable {
                                    signInViewModel.state = signInViewModel.state.copy(passwordVisibility = !signInViewModel.state.passwordVisibility)
                                }
                            )
                        else
                            Icon(
                                imageVector = Icons.Rounded.Visibility,
                                contentDescription = null,
                                Modifier.clickable {
                                    signInViewModel.state = signInViewModel.state.copy(passwordVisibility = !signInViewModel.state.passwordVisibility)
                                }
                            )
                    }
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
                        modifier = Modifier.clickable {
                            navController.navigate(AuthenticationScreen.SignUpScreen.route){
                                popUpTo(AuthenticationScreen.SignInScreen.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}