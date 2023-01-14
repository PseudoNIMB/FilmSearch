package ru.pseudonimb.filmsearch.di

import dagger.Component
import ru.pseudonimb.filmsearch.di.modules.DatabaseModule
import ru.pseudonimb.filmsearch.di.modules.DomainModule
import ru.pseudonimb.filmsearch.di.modules.RemoteModule
import ru.pseudonimb.filmsearch.viewmodel.HomeFragmentViewModel
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
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}