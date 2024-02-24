package com.example.baggish.feature.authentication.domain.use_case

import android.content.res.Resources
import android.util.Patterns
import com.example.baggish.R

class ValidateEmail {
    fun execute(email: String): ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.local_email_validation_empty_email)
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.local_email_validation_wrong_email_format)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
