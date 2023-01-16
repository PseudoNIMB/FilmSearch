package ru.pseudonimb.filmsearch

import android.app.Application
import ru.pseudonimb.filmsearch.di.AppComponent
import ru.pseudonimb.filmsearch.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}