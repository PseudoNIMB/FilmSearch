package ru.pseudonimb.filmsearch.domain
import ru.pseudonimb.filmsearch.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}