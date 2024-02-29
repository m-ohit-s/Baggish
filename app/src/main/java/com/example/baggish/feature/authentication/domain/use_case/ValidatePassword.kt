package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import com.example.baggish.feature.authentication.domain.repository.PasswordValidationRepository
import javax.inject.Inject

class ValidatePassword @Inject constructor(
    val passwordValidationRepository: PasswordValidationRepository
) {
    fun execute(password: String): ValidationResult{
        if(password.length < 8){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.PASSWORD_LENGTH_ERROR
            )
        }
        val passwordPattern = passwordValidationRepository.validatePasswordPattern(password)
        if(!passwordPattern){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.PASSWORD_PATTERN_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
