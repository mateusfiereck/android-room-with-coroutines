package br.com.mateusfiereck.androidroomwithcoroutines.di

import br.com.mateusfiereck.androidroomwithcoroutines.data.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabase.build(get()) }
    single { get<AppDatabase>().newsDao() }
}