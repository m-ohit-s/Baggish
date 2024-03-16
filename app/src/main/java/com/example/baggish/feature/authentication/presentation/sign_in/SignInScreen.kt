package com.example.baggish.feature.authentication.presentation.sign_in

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
import com.example.baggish.core.navigation.Graphs
import com.example.baggish.core.navigation.Screens
import com.example.baggish.core.presentation.components.BrandDesign
import com.example.baggish.core.presentation.components.LoadingAnimation
import com.example.baggish.feature.authentication.common.AuthenticationConstants
import com.example.baggish.feature.authentication.common.enums.TextFieldKeyboardType
import com.example.baggish.feature.authentication.domain.model.LoginUserDomain
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInButton
import com.example.baggish.feature.authentication.presentation.sign_in.components.SignInEntryField
import com.example.baggish.feature.authentication.presentation.sign_up.ValidationEvent
import kotlinx.coroutines.delay

@Composable
fun SignInScreen(
    navController: NavController,
    modifier: Modifier=Modifier,
    signInViewModel: SignInViewModel = hiltViewModel()
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        val state = signInViewModel.state
        val loginState = signInViewModel.loginState
        val context = LocalContext.current

        LaunchedEffect(key1 = context){
            signInViewModel.validationEvents.collect{event->
                when(event){
                    is ValidationEvent.Success -> {
                        val user = LoginUserDomain(
                            state.value.email,
                            state.value.password
                        )
                        signInViewModel.loginToDB(user)
                        Log.d("TAG", "${loginState.value.user}")
                    }
                }
            }
        }
        LaunchedEffect(key1 = loginState.value.isLoading){
            delay(1000)
        }
        if(loginState.value.isLoading){
            LoadingAnimation(modifier.fillMaxSize())
        }
        else{
            if(loginState.value.error.isNotBlank()){
                LaunchedEffect(key1 = context){
                    Toast.makeText(context, loginState.value.error, Toast.LENGTH_SHORT).show()
                }
            }
            if(!loginState.value.user.email.isNullOrBlank()){
                LaunchedEffect(key1 = context){
                    Toast.makeText(
                        context,
                        AuthenticationConstants.LOGIN_SUCCESS,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                navController.navigate(Graphs.Main.route){
                    popUpTo(Graphs.Auth.route){
                        inclusive = true
                    }
//                    popUpTo(AuthenticationScreen.SignInScreen.route){
//                        inclusive = true
//                    }
                }
            }
            else{
                ScreenUI(navController = navController, signInViewModel = signInViewModel)
            }
        }
    }
}

@Composable
fun ScreenUI(
    navController: NavController,
    modifier: Modifier=Modifier,
    signInViewModel: SignInViewModel = hiltViewModel()
){
    Column(
        modifier = modifier
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
        ) {
            SignInEntryField(
                label = stringResource(id = R.string.sign_in_email),
                value = signInViewModel.state.value.email,
                onValueChange = {
                    signInViewModel.onEvent(SignInFormEvent.EmailChanged(it))
                },
                textFieldKeyboardType = TextFieldKeyboardType.EMAIL
            )
            if (signInViewModel.state.value.emailError != null) {
                Text(
                    text = signInViewModel.state.value.emailError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)

                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            SignInEntryField(
                label = stringResource(id = R.string.sign_in_password),
                value = signInViewModel.state.value.password,
                onValueChange = {
                    signInViewModel.onEvent(SignInFormEvent.PasswordChanged(it))
                },
                textFieldKeyboardType = if (signInViewModel.state.value.passwordVisible) TextFieldKeyboardType.TEXT else TextFieldKeyboardType.PASSWORD,
                suffix = {
                    if (signInViewModel.state.value.passwordVisible)
                        Icon(
                            imageVector = Icons.Rounded.VisibilityOff,
                            contentDescription = null,
                            Modifier.clickable {
                                signInViewModel.onEvent(
                                    SignInFormEvent.PasswordVisibilityChanged(!signInViewModel.state.value.passwordVisible)
                                )
                            }
                        )
                    else
                        Icon(
                            imageVector = Icons.Rounded.Visibility,
                            contentDescription = null,
                            Modifier.clickable {
                                signInViewModel.onEvent(
                                    SignInFormEvent.PasswordVisibilityChanged(!signInViewModel.state.value.passwordVisible)
                                )
                            }
                        )
                }
            )
            if (signInViewModel.state.value.passwordError != null) {
                Text(
                    text = signInViewModel.state.value.passwordError!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)

                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Column(modifier = Modifier.padding(80.dp, 30.dp)) {
                SignInButton(
                    buttonItem = {
                        Text(
                            text = stringResource(id = R.string.sign_in_button),
                            color = Color.White,
                        )
                    },
                    onClick = {
                        signInViewModel.onEvent(SignInFormEvent.Login)
                    },
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
                        navController.navigate(Screens.SignUp.route) {
                            popUpTo(Screens.Login.route){
                                inclusive = true
                            }
//                            popUpTo(AuthenticationScreen.SignInScreen.route) {
//                                inclusive = true
//                            }
                        }
                    }
                )
            }
        }
    }
}