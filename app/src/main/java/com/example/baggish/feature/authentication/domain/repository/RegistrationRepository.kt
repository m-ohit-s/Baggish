package com.example.baggish.feature.authentication.domain.repository

import com.example.baggish.feature.authentication.data.model.RegisterUser

interface RegistrationRepository {
    suspend fun register(name: String, email: String, password: String): RegisterUser
}