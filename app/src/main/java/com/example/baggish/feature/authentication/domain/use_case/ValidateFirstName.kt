package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import javax.inject.Inject

class ValidateFirstName @Inject constructor() {
    fun execute(firstName: String): ValidationResult {
        if (firstName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = Constants.FIRST_NAME_EMPTY_ERROR
            )
        }
        return  ValidationResult(successful = true)
    }
}