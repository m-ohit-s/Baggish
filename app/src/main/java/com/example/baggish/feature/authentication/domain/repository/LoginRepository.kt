package com.example.baggish.feature.authentication.domain.repository

import com.example.baggish.feature.authentication.data.model.LoginUser

interface LoginRepository {
    suspend fun login(email: String, password: String): LoginUser
}