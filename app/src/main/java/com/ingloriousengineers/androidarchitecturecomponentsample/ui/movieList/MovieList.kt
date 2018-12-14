package com.ingloriousengineers.androidarchitecturecomponentsample.ui.movieList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ingloriousengineers.androidarchitecturecomponentsample.R
import com.ingloriousengineers.androidarchitecturecomponentsample.data.Result


class MovieList : AppCompatActivity() {

    lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)

        initMovieList()
    }

    private fun initMovieList() {
        val recyclerView: RecyclerView = findViewById(R.id.movie_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        movieListViewModel.getMovies().observe(this, Observer {
            recyclerView.adapter = MovieListAdapter(it) {movie: Result, position: Int ->
                Toast.makeText(this, movie.title, Toast.LENGTH_LONG).show()
            }
        })
    }
}
