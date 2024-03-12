package com.example.baggish.feature.authentication.data.repository

import com.example.baggish.core.common.utils.firebase.FirebaseUtils
import com.example.baggish.feature.authentication.data.model.LoginUser
import com.example.baggish.feature.authentication.data.model.toLoginUser
import com.example.baggish.feature.authentication.domain.repository.LoginRepository
import kotlinx.coroutines.tasks.await

class LoginRepositoryImpl: LoginRepository {

    private val firebaseAuth = FirebaseUtils.FirebaseAuthInstance().getFireBaseAuthInstance()

    override suspend fun login(email: String, password: String): LoginUser {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        val loginUser = LoginUser()
        loginUser.toLoginUser(result.user!!)
        return loginUser
    }
}