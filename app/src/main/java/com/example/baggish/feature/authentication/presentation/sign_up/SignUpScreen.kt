package com.example.baggish.feature.authentication.presentation.sign_up

import SignUpEntryField
import android.util.Log
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
import com.example.baggish.core.presentation.components.LoadingAnimation
import com.example.baggish.feature.authentication.common.AuthenticationConstants
import com.example.baggish.feature.authentication.common.enums.TextFieldKeyboardType
import com.example.baggish.feature.authentication.domain.model.RegistrationUserDomain
import com.example.baggish.feature.authentication.presentation.AuthenticationScreen
import com.example.baggish.feature.authentication.presentation.sign_up.components.ConditionsField
import com.example.baggish.feature.authentication.presentation.sign_up.components.SignUpButton
import com.example.baggish.feature.home.presentation.Screen
import kotlinx.coroutines.delay

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
        val registrationState = signUpViewModel.registrationState
        val context = LocalContext.current
        LaunchedEffect(key1 = context){
            signUpViewModel.validationEvents.collect{event->
                when(event){
                    is ValidationEvent.Success -> {
                        val user = RegistrationUserDomain(
                            state.value.firstName,
                            state.value.lastName,
                            state.value.email,
                            state.value.password
                        )
                        signUpViewModel.registerToDB(user)
                    }
                }
            }
        }
        LaunchedEffect(key1 = registrationState.value.isLoading){
            delay(1000L)
        }
        if(registrationState.value.isLoading){
            LoadingAnimation(modifier.fillMaxSize())
        }
        else{
            if(registrationState.value.error.isNotBlank()){
                LaunchedEffect(key1 = context){
                    Toast.makeText(
                        context,
                        registrationState.value.error,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            if(!registrationState.value.user.name.isNullOrBlank() && !registrationState.value.user.email.isNullOrBlank()){
                LaunchedEffect(key1 = context){
                    Toast.makeText(
                        context,
                        AuthenticationConstants.REGISTRATION_SUCCESS,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(AuthenticationScreen.SignUpScreen.route){
                        inclusive = true
                    }
                }
            }
            else{
                ScreenUI(navController = navController, signUpViewModel = signUpViewModel)
            }
        }
    }
}

@Composable
fun ScreenUI(
    navController: NavController,
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel = hiltViewModel()
){
    Column(
        modifier = modifier
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

            //First Name
            SignUpEntryField(
                label = stringResource(id = R.string.sign_up_first_name),
                value = signUpViewModel.state.value.firstName,
                onValueChange = {
                    signUpViewModel.onEvent(SignUpFormEvent.FirstNameChanged(it))
                },
            )
            if (signUpViewModel.state.value.firstNameError != null) {
                Text(
                    text = signUpViewModel.state.value.firstNameError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)

                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            //Last Name
            SignUpEntryField(
                label = stringResource(id = R.string.sign_up_last_name),
                value = signUpViewModel.state.value.lastName,
                onValueChange = {
                    signUpViewModel.onEvent(SignUpFormEvent.LastNameChanged(it))
                },
            )

            //Email
            SignUpEntryField(
                label = stringResource(id = R.string.sign_up_email),
                value = signUpViewModel.state.value.email,
                onValueChange = {
                    signUpViewModel.onEvent(SignUpFormEvent.EmailChanged(it))
                },
                textFieldKeyboardType = TextFieldKeyboardType.EMAIL,

                )
            if (signUpViewModel.state.value.emailError != null) {
                Text(
                    text = signUpViewModel.state.value.emailError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            //Password
            SignUpEntryField(
                label = stringResource(id = R.string.sign_up_password),
                value = signUpViewModel.state.value.password,
                onValueChange = { signUpViewModel.onEvent(SignUpFormEvent.PasswordChanged(it)) },
                textFieldKeyboardType = if (!signUpViewModel.state.value.passwordVisible) TextFieldKeyboardType.PASSWORD else TextFieldKeyboardType.TEXT,
                suffix = {
                    if (!signUpViewModel.state.value.passwordVisible)
                        Icon(
                            imageVector = Icons.Rounded.Visibility,
                            contentDescription = null,
                            Modifier.clickable {
                                signUpViewModel.onEvent(
                                    SignUpFormEvent.PasswordVisibilityChanged(
                                        !signUpViewModel.state.value.passwordVisible
                                    )
                                )
                            }
                        )
                    else
                        Icon(
                            imageVector = Icons.Rounded.VisibilityOff,
                            contentDescription = null,
                            Modifier.clickable {
                                signUpViewModel.onEvent(
                                    SignUpFormEvent.PasswordVisibilityChanged(!signUpViewModel.state.value.passwordVisible)
                                )
                            }
                        )
                }
            )
            if (signUpViewModel.state.value.passwordError != null) {
                Text(
                    text = signUpViewModel.state.value.passwordError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            //Confirm Password
            SignUpEntryField(
                label = stringResource(id = R.string.sign_up_confirm_password),
                value = signUpViewModel.state.value.confirmPassword,
                onValueChange = {
                    signUpViewModel.onEvent(
                        SignUpFormEvent.ConfirmPasswordChanged(
                            it
                        )
                    )
                },
                textFieldKeyboardType = if (!signUpViewModel.state.value.confirmPasswordVisible) TextFieldKeyboardType.PASSWORD else TextFieldKeyboardType.TEXT,
                suffix = {
                    if (!signUpViewModel.state.value.confirmPasswordVisible)
                        Icon(
                            imageVector = Icons.Rounded.Visibility,
                            contentDescription = null,
                            Modifier.clickable {
                                signUpViewModel.onEvent(
                                    SignUpFormEvent.ConfirmPasswordVisibilityChanged(
                                        !signUpViewModel.state.value.confirmPasswordVisible
                                    )
                                )
                            }
                        )
                    else
                        Icon(
                            imageVector = Icons.Rounded.VisibilityOff,
                            contentDescription = null,
                            Modifier.clickable {
                                signUpViewModel.onEvent(
                                    SignUpFormEvent.ConfirmPasswordVisibilityChanged(
                                        !signUpViewModel.state.value.confirmPasswordVisible
                                    )
                                )
                            }
                        )
                }
            )
            if (signUpViewModel.state.value.confirmPasswordError != null) {
                Text(
                    text = signUpViewModel.state.value.confirmPasswordError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            //Terms
            ConditionsField(
                isChecked = signUpViewModel.state.value.acceptedTerms,
                onCheckedChange = { signUpViewModel.onEvent(SignUpFormEvent.AcceptedTerms(it)) },
                text = stringResource(id = R.string.sign_up_terms_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            )
            if (signUpViewModel.state.value.termsError != null) {
                Text(
                    text = signUpViewModel.state.value.termsError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            //Button
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

            //Move to sign in - navigation
            Row {
                Text(
                    text = stringResource(id = R.string.move_to_sign_in_text),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(id = R.string.move_to_sign_in_button_text),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable {
                        navController.navigate(AuthenticationScreen.SignInScreen.route) {
                            popUpTo(AuthenticationScreen.SignUpScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}
