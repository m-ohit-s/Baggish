package com.example.baggish.feature.authentication.domain.use_case

import android.content.res.Resources
import android.util.Patterns
import com.example.baggish.R

class ValidatePassword {
    fun execute(password: String): ValidationResult{
        if(password.length < 8){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.local_password_validation_short_length)
            )
        }
        val containLetterAndDigit = password.any{ it.isLetter() } && password.any{ it.isDigit() }
        if(!containLetterAndDigit){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.local_password_validation_wrong_password_format)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
