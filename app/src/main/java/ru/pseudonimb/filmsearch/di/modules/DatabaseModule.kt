package ru.pseudonimb.filmsearch.di.modules

import dagger.Module
import dagger.Provides
import ru.pseudonimb.filmsearch.data.MainRepository
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}