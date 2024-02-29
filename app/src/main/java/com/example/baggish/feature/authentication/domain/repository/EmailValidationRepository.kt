package com.example.baggish.feature.authentication.domain.repository

interface EmailValidationRepository {
    fun validateEmailPattern(email: String): Boolean
}