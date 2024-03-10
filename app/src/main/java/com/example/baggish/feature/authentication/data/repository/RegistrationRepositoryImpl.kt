package com.example.baggish.feature.authentication.data.repository

import com.example.baggish.core.presentation.components.common.utils.firebase.FirebaseUtils
import com.example.baggish.feature.authentication.common.Resource
import com.example.baggish.feature.authentication.data.model.RegisterUser
import com.example.baggish.feature.authentication.data.model.toRegisterUser
import com.example.baggish.feature.authentication.domain.repository.RegistrationRepository
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class RegistrationRepositoryImpl: RegistrationRepository {
    val firebaseAuth = FirebaseUtils.FirebaseAuthInstance().getFireBaseAuthInstance()

    override suspend fun register(name: String, email: String, password: String): RegisterUser {
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())
        val registerUser= RegisterUser()
        registerUser.toRegisterUser(result.user!!)
        return registerUser
    }

}