package com.example.baggish.feature.authentication.data.repository

import com.example.baggish.core.common.utils.firebase.FirebaseUtils
import com.example.baggish.feature.authentication.domain.repository.LogoutRepository

class LogoutRepositoryImpl: LogoutRepository {
    private val firebaseAuth = FirebaseUtils.FirebaseAuthInstance().getFireBaseAuthInstance()
    override suspend fun logout() {
        firebaseAuth.signOut()
    }
}