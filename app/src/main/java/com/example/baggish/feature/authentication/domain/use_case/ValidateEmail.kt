package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import com.example.baggish.feature.authentication.domain.repository.EmailValidationRepository
import javax.inject.Inject

class ValidateEmail @Inject constructor(
    private val emailValidationRepository: EmailValidationRepository
) {
    fun execute(email: String): ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.EMAIL_EMPTY_ERROR
            )
        }
        if(!emailValidationRepository.validateEmailPattern(email)){
            return ValidationResult(
                successful = false,
                errorMessage = Constants.EMAIL_PATTERN_ERROR
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
