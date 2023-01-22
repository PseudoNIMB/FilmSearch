package ru.pseudonimb.filmsearch.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.pseudonimb.filmsearch.data.MainRepository
import ru.pseudonimb.filmsearch.data.PreferenceProvider
import ru.pseudonimb.filmsearch.data.TmdbApi
import ru.pseudonimb.filmsearch.domain.Interactor
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}