package com.iushin.effectivemobiletest.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.iushin.data.clientIntrfaces.AuthorizationClient
import com.iushin.data.clientIntrfaces.GetCurrentUserNameClient
import com.iushin.data.clientIntrfaces.SignOutClient
import com.iushin.data.clients.AuthorizationClientImpl
import com.iushin.data.clients.GetCurrentUserNameClientImpl
import com.iushin.data.clients.SignOutClientImpl
import org.koin.dsl.module

val dataModule = module {
    single {
        Firebase.auth
    }

    factory<AuthorizationClient> {
        AuthorizationClientImpl(get())
    }

    factory<SignOutClient> {
        SignOutClientImpl(get())
    }

    factory<GetCurrentUserNameClient> {
        GetCurrentUserNameClientImpl(get())
    }
}