package ru.pseudonimb.filmsearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.pseudonimb.filmsearch.data.dao.FilmDao
import ru.pseudonimb.filmsearch.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}