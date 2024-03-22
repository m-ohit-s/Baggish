package com.example.baggish.core.common.utils.helpers

import com.example.baggish.core.common.utils.helpers.Authentication

interface AuthenticationHelper {
    fun isAuthenticated(): Authentication
}