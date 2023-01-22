package ru.pseudonimb.filmsearch

import android.app.Application
import okhttp3.internal.Internal.instance
import ru.pseudonimb.filmsearch.di.AppComponent
import ru.pseudonimb.filmsearch.di.DaggerAppComponent
import ru.pseudonimb.filmsearch.di.modules.DatabaseModule
import ru.pseudonimb.filmsearch.di.modules.DomainModule
import ru.pseudonimb.filmsearch.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }
    }

    companion object {
        lateinit var instance: App
            private set
    }
}