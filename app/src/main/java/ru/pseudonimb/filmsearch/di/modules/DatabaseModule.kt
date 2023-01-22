package ru.pseudonimb.filmsearch.di.modules

import android.content.Context
import ru.pseudonimb.filmsearch.data.DatabaseHelper
import ru.pseudonimb.filmsearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}