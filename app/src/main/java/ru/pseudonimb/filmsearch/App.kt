package ru.pseudonimb.filmsearch

import android.app.Application
import ru.pseudonimb.filmsearch.di.AppComponent
import ru.pseudonimb.filmsearch.di.DaggerAppComponent
import ru.pseudonimb.filmsearch.di.modules.DatabaseModule
import ru.pseudonimb.filmsearch.di.modules.DomainModule
import ru.pseudonimb.remote_module.DaggerRemoteComponent


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}