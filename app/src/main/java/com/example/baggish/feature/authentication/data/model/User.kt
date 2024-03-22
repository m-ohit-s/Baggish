package com.example.baggish.feature.authentication.data.model

data class User(
    var firstName: String? = "",
    var lastName: String? = "",
    var email: String? = ""
)

fun User.registerUserToUser(registerUser: RegisterUser){
    val name = registerUser.name?.split("")
    firstName = name?.get(0)
    name?.let {
        for(i in 1..name.size){
            lastName += name[i]
        }
    }
    email = registerUser.email
}