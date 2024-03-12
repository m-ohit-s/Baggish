package com.example.baggish.feature.authentication.common

object AuthenticationConstants {
    //routes
    const val SIGN_IN_ROUTE: String = "sign_in"
    const val SIGN_UP_ROUTE: String = "sign_up"
    const val SPLASH_SCREEN_ROUTE: String = "splash_screen"

    //error messages
    const val FIRST_NAME_EMPTY_ERROR = "first name cannot be blank"
    const val EMAIL_EMPTY_ERROR = "the email cannot be blank"
    const val EMAIL_PATTERN_ERROR = "That\'s not a valid email"
    const val PASSWORD_LENGTH_ERROR = "The password length should be greater than 8"
    const val PASSWORD_PATTERN_ERROR = "The password needs to contain at least one letter and one digit"
    const val CONFIRM_PASSWORD_MATCH_ERROR = "The passwords do not match"
    const val TERMS_ERROR = "Please accept the terms"
    const val PASSWORD_EMPTY_ERROR = "the password cannot be blank"

    const val LOGIN_SUCCESS = "Successfully Logged In."
    const val REGISTRATION_SUCCESS = "Welcome to Baggish"

}