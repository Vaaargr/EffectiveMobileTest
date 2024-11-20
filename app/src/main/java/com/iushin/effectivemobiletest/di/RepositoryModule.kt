package com.iushin.effectivemobiletest.di

import com.iushin.data.repositorys.AuthorizationRepositoryImpl
import com.iushin.domain.api.repositorys.AuthorizationRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory <AuthorizationRepository> {
        AuthorizationRepositoryImpl(get())
    }
}