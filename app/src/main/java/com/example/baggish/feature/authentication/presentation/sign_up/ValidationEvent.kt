package com.example.baggish.feature.authentication.presentation.sign_up

sealed class ValidationEvent{
    object Success: ValidationEvent()
}