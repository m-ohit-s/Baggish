package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import javax.inject.Inject

class ValidatePasswordSignIn @Inject constructor() {
    fun execute(password: String): ValidationResult{
        if(password.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.PASSWORD_EMPTY_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}