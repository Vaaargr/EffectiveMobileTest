package com.iushin.data.clients

import com.google.firebase.auth.FirebaseAuth
import com.iushin.data.clientIntrfaces.AuthorizationClient
import com.iushin.domain.entity.SignUpState
import com.iushin.domain.entity.SignInState

class AuthorizationClientImpl(private val authorizer: FirebaseAuth) : AuthorizationClient {

    override suspend fun createUser(
        email: String,
        password: String,
        listener: (SignUpState) -> Unit
    ) {
        authorizer.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    listener(SignUpState.SignUpSuccessful)
                } else {
                    listener(SignUpState.SignUpUnSuccessful(task.exception?.message))
                }
            }
    }

    override suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit) {
        authorizer.signInWithEmailAndPassword(email, password).addOnCompleteListener { state ->
            if (state.isSuccessful) {
                listener(SignInState.SUCCESSFUL)
            } else {
                listener(SignInState.UNSUCCESSFUL)
            }
        }
    }
}