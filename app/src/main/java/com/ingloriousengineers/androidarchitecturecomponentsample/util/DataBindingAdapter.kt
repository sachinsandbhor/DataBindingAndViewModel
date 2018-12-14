package com.ingloriousengineers.androidarchitecturecomponentsample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ingloriousengineers.androidarchitecturecomponentsample.MovieListApplication.Companion.IMAGE_URL_BASE_PATH
import com.squareup.picasso.Picasso

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String?) {
        val url: String = IMAGE_URL_BASE_PATH + imageUrl
        Picasso.get().load(url).fit().into(imageView)
    }
}
