package ru.pseudonimb.filmsearch.di.modules

import dagger.Module
import dagger.Provides
import ru.pseudonimb.filmsearch.data.MainRepository
import ru.pseudonimb.filmsearch.data.TmdbApi
import ru.pseudonimb.filmsearch.domain.Interactor
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}