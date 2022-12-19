package ru.pseudonimb.filmsearch.data

import ru.pseudonimb.filmsearch.R
import ru.pseudonimb.filmsearch.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film("Flash", R.drawable.flash, "Description", 7.7f),
        Film("Ghost Busters!", R.drawable.ghostbusters, "Description", 6.3f),
        Film("Back to the Future", R.drawable.backtothefuture, "Description", 5.2f),
        Film("Jaws", R.drawable.jaws, "Description", 9.2f),
        Film("Jurassic Park", R.drawable.jurassic, "Description", 8.3f),
        Film("Raiders", R.drawable.raiders, "Description", 7.2f),
        Film("Top Gun", R.drawable.topgun, "Description", 5.8f),
        Film("WandaVision", R.drawable.wandavision, "Description", 8.8f),
    )
}