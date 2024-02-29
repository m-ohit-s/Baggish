package com.example.baggish.feature.authentication.presentation.sign_up

import SignUpEntryField
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.baggish.R
import com.example.baggish.core.presentation.components.BrandDesign
import com.example.baggish.feature.authentication.common.TextFieldKeyboardType
import com.example.baggish.feature.authentication.presentation.AuthenticationScreen
import com.example.baggish.feature.authentication.presentation.sign_up.components.ConditionsField
import com.example.baggish.feature.authentication.presentation.sign_up.components.SignUpButton

@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        val state = signUpViewModel.state
        val context = LocalContext.current
        LaunchedEffect(key1 = context){
            signUpViewModel.validationEvents.collect{event->
                when(event){
                    is ValidationEvent.Success -> {
                        Toast.makeText(
                            context,
                            "Registration Successful",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp)
                .verticalScroll(rememberScrollState()),
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
                    label = stringResource(id = R.string.sign_up_first_name),
                    value = state.value.firstName,
                    onValueChange = {
                        signUpViewModel.onEvent(SignUpFormEvent.FirstNameChanged(it))
                    },
                )
                if(state.value.firstNameError != null){
                    Text(
                        text = state.value.firstNameError!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                SignUpEntryField(
                    label = stringResource(id = R.string.sign_up_last_name),
                    value = state.value.lastName,
                    onValueChange = {
                        signUpViewModel.onEvent(SignUpFormEvent.LastNameChanged(it))
                    },
                )
                SignUpEntryField(
                    label = stringResource(id = R.string.sign_up_email),
                    value = state.value.email,
                    onValueChange = { 
                        signUpViewModel.onEvent(SignUpFormEvent.EmailChanged(it)) 
                    },
                    textFieldKeyboardType = TextFieldKeyboardType.EMAIL,
                    
                )
                if(state.value.emailError != null){
                    Text(
                        text = state.value.emailError!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                SignUpEntryField(
                    label = stringResource(id = R.string.sign_up_password),
                    value = state.value.password,
                    onValueChange = { signUpViewModel.onEvent(SignUpFormEvent.PasswordChanged(it)) },
                    textFieldKeyboardType = if(state.value.passwordVisible) TextFieldKeyboardType.PASSWORD else TextFieldKeyboardType.TEXT,
                    suffix = {
                        if(state.value.passwordVisible)
                            Icon(
                                imageVector = Icons.Rounded.VisibilityOff,
                                contentDescription = null,
                                Modifier.clickable {
                                    signUpViewModel.onEvent(SignUpFormEvent.PasswordVisibilityChanged(!state.value.passwordVisible))
                                }
                            )
                        else
                            Icon(
                                imageVector = Icons.Rounded.Visibility,
                                contentDescription = null,
                                Modifier.clickable {
                                    signUpViewModel.onEvent(SignUpFormEvent.PasswordVisibilityChanged(!state.value.passwordVisible))
                                }
                            )
                    }
                )
                if(state.value.passwordError != null){
                    Text(
                        text = state.value.passwordError!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                SignUpEntryField(
                    label = stringResource(id = R.string.sign_up_confirm_password),
                    value = state.value.confirmPassword,
                    onValueChange = { signUpViewModel.onEvent(SignUpFormEvent.ConfirmPasswordChanged(it)) },
                    textFieldKeyboardType = if(state.value.confirmPasswordVisible) TextFieldKeyboardType.PASSWORD else TextFieldKeyboardType.TEXT,
                    suffix = {
                        if(state.value.confirmPasswordVisible)
                            Icon(
                                imageVector = Icons.Rounded.VisibilityOff,
                                contentDescription = null,
                                Modifier.clickable {
                                    signUpViewModel.onEvent(SignUpFormEvent.ConfirmPasswordVisibilityChanged(!state.value.confirmPasswordVisible))
                                }
                            )
                        else
                            Icon(
                                imageVector = Icons.Rounded.Visibility,
                                contentDescription = null,
                                Modifier.clickable {
                                    signUpViewModel.onEvent(SignUpFormEvent.ConfirmPasswordVisibilityChanged(!state.value.confirmPasswordVisible))
                                }
                            )
                    }
                )
                if(state.value.confirmPasswordError != null){
                    Text(
                        text = state.value.confirmPasswordError!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal=16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                ConditionsField(
                    isChecked = state.value.acceptedTerms,
                    onCheckedChange = {signUpViewModel.onEvent(SignUpFormEvent.AcceptedTerms(it)) },
                    text = stringResource(id = R.string.sign_up_terms_text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                )
                if(state.value.termsError != null){
                    Text(
                        text = state.value.termsError!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                        )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Column(modifier = Modifier.padding(80.dp, 30.dp)) {
                    SignUpButton(
                        buttonItem = {
                            Text(
                                text = stringResource(id = R.string.sign_up_button),
                                color = Color.White,
                            )
                        },
                        onClick = {
                                  signUpViewModel.onEvent(SignUpFormEvent.Submit)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row {
                    Text(
                        text = stringResource(id = R.string.move_to_sign_in_text),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = stringResource(id = R.string.move_to_sign_in_button_text),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.clickable {
                            navController.navigate(AuthenticationScreen.SignInScreen.route){
                                popUpTo(AuthenticationScreen.SignUpScreen.route){
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
