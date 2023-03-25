package ru.pseudonimb.remote_module

interface RemoteProvider {
    fun provideRemote(): TmdbApi
}