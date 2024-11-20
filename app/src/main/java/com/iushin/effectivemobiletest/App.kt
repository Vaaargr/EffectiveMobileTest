package com.iushin.effectivemobiletest

import android.app.Application
import com.iushin.effectivemobiletest.di.dataModule
import com.iushin.effectivemobiletest.di.domainModule
import com.iushin.effectivemobiletest.di.repositoryModule
import com.iushin.effectivemobiletest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule, dataModule, domainModule, repositoryModule)
        }
    }
}