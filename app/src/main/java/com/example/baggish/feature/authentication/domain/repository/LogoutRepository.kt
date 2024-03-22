package com.example.baggish.feature.authentication.domain.repository

interface LogoutRepository {
    suspend fun logout()
}