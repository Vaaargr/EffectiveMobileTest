package com.iushin.data.clients

import com.google.firebase.auth.FirebaseAuth
import com.iushin.data.clientIntrfaces.SignOutClient

class SignOutClientImpl(private val authorizer: FirebaseAuth): SignOutClient {
    override suspend fun execute() {
        authorizer.signOut()
    }
}