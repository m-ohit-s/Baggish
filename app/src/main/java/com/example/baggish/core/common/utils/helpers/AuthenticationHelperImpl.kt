package com.example.baggish.core.common.utils.helpers

import com.example.baggish.core.common.utils.firebase.FirebaseUtils

class AuthenticationHelperImpl: AuthenticationHelper {
    override fun isAuthenticated(): Authentication {
        val firebaseAuth = FirebaseUtils.FirebaseAuthInstance().getFireBaseAuthInstance()
        if(firebaseAuth.currentUser != null){
            return Authentication.AUTHENTICATED
        }
        return Authentication.UNAUTHENTICATED
    }
}