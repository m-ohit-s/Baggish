package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import javax.inject.Inject

class ValidateTerms @Inject constructor() {
    fun execute(acceptedTerms: Boolean): ValidationResult{
        if(!acceptedTerms){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.TERMS_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
