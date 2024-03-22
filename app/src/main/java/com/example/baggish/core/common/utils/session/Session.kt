package com.example.baggish.core.common.utils.session

import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val user: SessionUser = SessionUser(),
    val token: String = "",
)

@Serializable
data class SessionUser(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = ""
)


