package com.example.baggish.feature.authentication.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {
    var localState by mutableStateOf(SignInLocalState())

}