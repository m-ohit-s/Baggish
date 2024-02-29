package com.example.baggish.feature.authentication.data.repository

import com.example.baggish.feature.authentication.domain.repository.PasswordValidationRepository

object PasswordValidationRepositoryImpl: PasswordValidationRepository {
    override fun validatePasswordPattern(password: String): Boolean {
        return password.any{ it.isLetter() } && password.any{ it.isDigit() }
    }
}