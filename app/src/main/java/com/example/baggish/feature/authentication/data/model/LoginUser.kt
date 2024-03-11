package com.example.baggish.feature.authentication.data.model

import com.google.firebase.auth.FirebaseUser

data class LoginUser(
    var name: String? = null,
    var email: String? = null,
)

fun LoginUser.toLoginUser(firebaseUser: FirebaseUser){
    name = firebaseUser.displayName
    email = firebaseUser.email
}