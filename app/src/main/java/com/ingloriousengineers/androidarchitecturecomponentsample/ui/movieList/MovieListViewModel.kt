package com.ingloriousengineers.androidarchitecturecomponentsample.ui.movieList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.ingloriousengineers.androidarchitecturecomponentsample.data.Movie
import com.ingloriousengineers.androidarchitecturecomponentsample.data.Result

class MovieListViewModel(val app: Application): AndroidViewModel(app){

    var movie: MutableLiveData<List<Result>>? = null

    fun getMovies(): LiveData<List<Result>> {
        if(movie == null) {
            movie = MutableLiveData()
            val result =  Gson().fromJson(loadDataFromJson(), Movie::class.java).results as List<Result>
            movie!!.setValue(result)
        }
        return movie as MutableLiveData<List<Result>>
    }

    private fun loadDataFromJson(): String {
        val response: String = app.assets.open("Movies.json").bufferedReader().use {
            it.readText()
        }
        return response
    }

}