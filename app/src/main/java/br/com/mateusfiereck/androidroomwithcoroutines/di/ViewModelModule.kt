package br.com.mateusfiereck.androidroomwithcoroutines.di

import br.com.mateusfiereck.androidroomwithcoroutines.ui.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
}