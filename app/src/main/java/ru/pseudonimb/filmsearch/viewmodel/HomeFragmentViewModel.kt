package ru.pseudonimb.filmsearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.pseudonimb.filmsearch.domain.Film
import ru.pseudonimb.filmsearch.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData = MutableLiveData<List<Film>>()
    private lateinit var interactor: Interactor
    init {
        //TODO init interactor

        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}