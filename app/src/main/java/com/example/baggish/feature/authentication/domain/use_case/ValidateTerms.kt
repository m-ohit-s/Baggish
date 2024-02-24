package com.example.baggish.feature.authentication.domain.use_case

import android.content.res.Resources
import android.util.Patterns
import com.example.baggish.R

class ValidateTerms {
    fun execute(acceptedTerms: Boolean): ValidationResult{
        if(!acceptedTerms){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.accept_terms_exception)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
