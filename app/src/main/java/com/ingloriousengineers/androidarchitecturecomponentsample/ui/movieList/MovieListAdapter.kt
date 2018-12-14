package com.ingloriousengineers.androidarchitecturecomponentsample.ui.movieList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ingloriousengineers.androidarchitecturecomponentsample.BR
import com.ingloriousengineers.androidarchitecturecomponentsample.R
import com.ingloriousengineers.androidarchitecturecomponentsample.data.Result

class MovieListAdapter(val movieList: List<Result>, val onClickListener: (Result, Int) -> Unit) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.layout_movie_row, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(movieList[position])
        viewHolder.itemView.setOnClickListener { onClickListener(movieList.get(position), position) }
    }

    class ViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Any) {
            binding.setVariable(BR.movie, movie)
            binding.executePendingBindings()
        }

    }

}