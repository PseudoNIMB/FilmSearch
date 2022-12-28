package ru.pseudonimb.filmsearch.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.pseudonimb.filmsearch.data.API
import ru.pseudonimb.filmsearch.data.Entity.TmdbResultsDto
import ru.pseudonimb.filmsearch.data.MainRepository
import ru.pseudonimb.filmsearch.data.TmdbApi
import ru.pseudonimb.filmsearch.utils.Converter
import ru.pseudonimb.filmsearch.viewmodel.HomeFragmentViewModel

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
}