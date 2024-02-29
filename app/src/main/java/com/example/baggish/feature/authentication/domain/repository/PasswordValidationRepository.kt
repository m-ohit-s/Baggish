package com.example.baggish.feature.authentication.domain.repository

interface PasswordValidationRepository {
    fun validatePasswordPattern(password: String): Boolean
}