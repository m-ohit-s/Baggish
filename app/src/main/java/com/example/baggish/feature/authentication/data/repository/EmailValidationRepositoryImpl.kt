package com.example.baggish.feature.authentication.data.repository

import android.util.Patterns
import com.example.baggish.feature.authentication.domain.repository.EmailValidationRepository

object EmailValidationRepositoryImpl: EmailValidationRepository {
    override fun validateEmailPattern(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}