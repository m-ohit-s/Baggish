package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.AuthenticationConstants
import javax.inject.Inject

class ValidateTerms @Inject constructor() {
    fun execute(acceptedTerms: Boolean): ValidationResult{
        if(!acceptedTerms){
            return ValidationResult(
                successful = false,
                errorMessage = AuthenticationConstants.TERMS_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
