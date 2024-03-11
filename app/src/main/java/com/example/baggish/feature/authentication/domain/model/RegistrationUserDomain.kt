package com.example.baggish.feature.authentication.domain.model

data class RegistrationUserDomain(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
