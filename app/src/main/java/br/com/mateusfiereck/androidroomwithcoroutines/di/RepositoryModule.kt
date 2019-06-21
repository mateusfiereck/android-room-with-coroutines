package br.com.mateusfiereck.androidroomwithcoroutines.di

import br.com.mateusfiereck.androidroomwithcoroutines.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { NewsRepository(get()) }
}