package com.example.baggish.feature.authentication.domain.use_case

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String?=null
)
