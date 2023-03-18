package ru.pseudonimb.filmsearch.data

import io.reactivex.rxjava3.core.Observable
import ru.pseudonimb.filmsearch.data.dao.FilmDao
import ru.pseudonimb.filmsearch.data.entity.Film

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()
}