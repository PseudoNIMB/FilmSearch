package ru.pseudonimb.remote_module

import dagger.Component
import javax.inject.Singleton

interface RemoteComponent {
    @Singleton
    @Component(
        modules = [RemoteModule::class]
    )
    interface RemoteComponent : RemoteProvider
}