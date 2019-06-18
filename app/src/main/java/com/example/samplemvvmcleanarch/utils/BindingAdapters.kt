package com.example.samplemvvmcleanarch.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmcleanarch.R
import com.example.samplemvvmcleanarch.domin.models.MovieModel
import com.example.samplemvvmcleanarch.ui.movies.adapter.MovieAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("items")
    fun RecyclerView.items(items: List<MovieModel>) {
        val adapter = this.adapter as MovieAdapter
        adapter.setMovies(items)
    }

    @JvmStatic
    @BindingAdapter("load")
    fun ImageView.loadImage(url: String) {
        Picasso.get().load("https://image.tmdb.org/t/p/w200/$url").placeholder(R.mipmap.ic_launcher).into(this)
    }
}