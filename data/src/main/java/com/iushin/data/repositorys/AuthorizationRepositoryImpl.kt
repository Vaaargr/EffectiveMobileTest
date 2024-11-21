package com.iushin.data.repositorys

import com.iushin.data.clientIntrfaces.AuthorizationClient
import com.iushin.domain.api.repositorys.AuthorizationRepository
import com.iushin.domain.entity.SignUpState
import com.iushin.domain.entity.SignInState

class AuthorizationRepositoryImpl(private val client: AuthorizationClient) :
    AuthorizationRepository {

    override suspend fun createUser(
        email: String,
        password: String,
        listener: (SignUpState) -> Unit
    ) {
        client.createUser(email = email, password = password, listener = listener)
    }

    override suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit) {
        client.logIn(email = email, password = password, listener = listener)
    }
}