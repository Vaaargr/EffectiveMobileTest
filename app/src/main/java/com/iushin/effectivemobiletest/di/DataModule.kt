package com.iushin.effectivemobiletest.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.iushin.data.clientIntrfaces.AuthorizationClient
import com.iushin.data.clients.AuthorizationClientImpl
import org.koin.dsl.module

val dataModule = module {
    single {
        Firebase.auth
    }

    factory<AuthorizationClient> {
        AuthorizationClientImpl(get())
    }
}