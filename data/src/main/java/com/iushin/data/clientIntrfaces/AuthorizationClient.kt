package com.iushin.data.clientIntrfaces

import com.iushin.domain.entity.SignUpState
import com.iushin.domain.entity.SignInState

interface AuthorizationClient {
    suspend fun createUser(email: String, password: String, listener: (SignUpState) -> Unit)

    suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit)
}