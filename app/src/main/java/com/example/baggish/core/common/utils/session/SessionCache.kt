package com.example.baggish.core.common.utils.session

import kotlinx.coroutines.flow.Flow

interface SessionCache {
    suspend fun saveSession(session: Session)
    suspend fun getActiveSession(): Flow<Session>
    suspend fun clearSession()
}