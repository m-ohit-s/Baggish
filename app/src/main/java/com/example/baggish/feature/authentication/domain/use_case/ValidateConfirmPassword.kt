package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.AuthenticationConstants
import javax.inject.Inject

class ValidateConfirmPassword @Inject constructor() {
    fun execute(password: String, confirmPassword: String): ValidationResult{
        if(password != confirmPassword){
            return ValidationResult(
                successful = false,
                errorMessage = AuthenticationConstants.CONFIRM_PASSWORD_MATCH_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
