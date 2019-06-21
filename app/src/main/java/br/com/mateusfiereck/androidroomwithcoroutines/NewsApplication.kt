package br.com.mateusfiereck.androidroomwithcoroutines

import android.app.Application
import br.com.mateusfiereck.androidroomwithcoroutines.di.databaseModule
import br.com.mateusfiereck.androidroomwithcoroutines.di.repositoryModule
import br.com.mateusfiereck.androidroomwithcoroutines.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

open class NewsApplication : Application() {

    private val appModules by lazy {
        listOf(databaseModule, repositoryModule, viewModelModule)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@NewsApplication)
            modules(appModules)
        }
    }

}