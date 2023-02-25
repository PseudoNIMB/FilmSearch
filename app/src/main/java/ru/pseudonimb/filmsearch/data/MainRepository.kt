package ru.pseudonimb.filmsearch.data

import kotlinx.coroutines.flow.Flow
import ru.pseudonimb.filmsearch.data.dao.FilmDao
import ru.pseudonimb.filmsearch.data.entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()
}