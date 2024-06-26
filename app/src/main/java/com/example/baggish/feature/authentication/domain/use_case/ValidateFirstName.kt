package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.AuthenticationConstants
import javax.inject.Inject

class ValidateFirstName @Inject constructor() {
    fun execute(firstName: String): ValidationResult {
        if (firstName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = AuthenticationConstants.FIRST_NAME_EMPTY_ERROR
            )
        }
        return  ValidationResult(successful = true)
    }
}