package com.example.baggish.feature.authentication.domain.use_case

import android.content.res.Resources
import com.example.baggish.R

class ValidateConfirmPassword {
    fun execute(password: String, confirmPassword: String): ValidationResult{
        if(!password.equals(confirmPassword)){
            return ValidationResult(
                successful = false,
                errorMessage = Resources.getSystem().getString(R.string.local_confirm_password_match_validation)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
