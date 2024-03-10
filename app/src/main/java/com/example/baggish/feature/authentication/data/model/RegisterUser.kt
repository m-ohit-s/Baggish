package com.example.baggish.feature.authentication.data.model

import com.google.firebase.auth.FirebaseUser

data class RegisterUser(
    var name: String? = null,
    var email: String? = null,
)


fun RegisterUser.toRegisterUser(firebaseUser: FirebaseUser){
    name = firebaseUser.displayName
    email = firebaseUser.email
}
