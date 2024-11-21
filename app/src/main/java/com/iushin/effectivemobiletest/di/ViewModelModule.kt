package com.iushin.effectivemobiletest.di

import com.iushin.effectivemobiletest.presentation.viewModel.AuthorizationViewModel
import com.iushin.effectivemobiletest.presentation.viewModel.MainActivityViewModel
import com.iushin.effectivemobiletest.presentation.viewModel.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AuthorizationViewModel(get())
    }

    viewModel{
        MainActivityViewModel(get())
    }

    viewModel {
        MainFragmentViewModel(get())
    }
}