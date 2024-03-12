package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.AuthenticationConstants
import javax.inject.Inject

class ValidatePasswordSignIn @Inject constructor() {
    fun execute(password: String): ValidationResult{
        if(password.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = AuthenticationConstants.PASSWORD_EMPTY_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}