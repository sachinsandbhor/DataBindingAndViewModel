package com.ingloriousengineers.androidarchitecturecomponentsample

import android.app.Application

class MovieListApplication: Application() {

    companion object {
       const val IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342"
    }
    override fun onCreate() {
        super.onCreate()
    }
}