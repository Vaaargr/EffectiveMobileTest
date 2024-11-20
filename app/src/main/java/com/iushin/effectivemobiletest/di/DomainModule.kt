package com.iushin.effectivemobiletest.di

import com.iushin.domain.api.interactors.AuthorizationInteractor
import com.iushin.domain.impl.AuthorizationInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    factory<AuthorizationInteractor> {
        AuthorizationInteractorImpl(get())
    }
}