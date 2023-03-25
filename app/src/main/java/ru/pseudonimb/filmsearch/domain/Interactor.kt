package ru.pseudonimb.filmsearch.domain

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.pseudonimb.filmsearch.data.API
import ru.pseudonimb.filmsearch.data.MainRepository
import ru.pseudonimb.filmsearch.data.entity.Film
import ru.pseudonimb.filmsearch.data.preferences.PreferenceProvider
import ru.pseudonimb.filmsearch.utils.Converter
import ru.pseudonimb.remote_module.TmdbApi

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun getFilmsFromApi(page: Int) {
        //Показываем ProgressBar
        progressBarState.onNext(true)
        //Метод getDefaultCategoryFromPreferences() будет получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .subscribeOn(Schedulers.io())
            .map {
                Converter.convertApiListToDtoList(it.tmdbFilms)
            }
            .subscribeBy(
                onError = {
                    progressBarState.onNext(false)
                },
                onNext = {
                    progressBarState.onNext(false)
                    repo.putToDb(it)
                }
            )
    }

    fun getSearchResultFromApi(search: String): Observable<List<Film>> = retrofitService.getFilmFromSearch(API.KEY, "ru-RU", search, 1)
        .map {
            Converter.convertApiListToDtoList(it.tmdbFilms)
        }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): Observable<List<Film>> = repo.getAllFromDB()
}