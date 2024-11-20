package com.iushin.domain.api.interactors

import com.iushin.domain.entity.SignUpState
import com.iushin.domain.entity.SignInState

interface AuthorizationInteractor {

    fun createUser(email: String, password: String, listener: (SignUpState) -> Unit)

    fun logIn(email: String, password: String, listener: (SignInState) -> Unit)

    fun getCurrentUserMail(): String?
}