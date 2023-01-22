package ru.pseudonimb.filmsearch.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.pseudonimb.filmsearch.data.DatabaseHelper
import ru.pseudonimb.filmsearch.data.MainRepository
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}