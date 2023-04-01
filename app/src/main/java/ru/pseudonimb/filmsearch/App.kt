package ru.pseudonimb.filmsearch

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import ru.pseudonimb.filmsearch.di.AppComponent
import ru.pseudonimb.filmsearch.di.DaggerAppComponent
import ru.pseudonimb.filmsearch.di.modules.DatabaseModule
import ru.pseudonimb.filmsearch.di.modules.DomainModule
import ru.pseudonimb.filmsearch.view.notifications.NotificationConstants.CHANNEL_ID
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

        //Задаем имя, описание и важность канала
        val name = "WatchLaterChannel"
        val descriptionText = "FilmSearch notification Channel"
        val importance = NotificationManager.IMPORTANCE_HIGH
        //Создаем канал, передав в параметры его ID(строка), имя(строка), важность(константа)
        val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
        //Отдельно задаем описание
        mChannel.description = descriptionText
        //Получаем доступ к менеджеру нотификаций
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        //Регистрируем канал
        notificationManager.createNotificationChannel(mChannel)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}