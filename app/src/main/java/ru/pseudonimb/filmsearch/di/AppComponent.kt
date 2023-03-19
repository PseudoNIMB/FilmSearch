package ru.pseudonimb.filmsearch.di

import dagger.Component
import ru.pseudonimb.filmsearch.di.modules.DatabaseModule
import ru.pseudonimb.filmsearch.di.modules.DomainModule
import ru.pseudonimb.filmsearch.viewmodel.HomeFragmentViewModel
import ru.pseudonimb.filmsearch.viewmodel.SettingsFragmentViewModel
import ru.pseudonimb.remote_module.RemoteModule
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}