package com.example.samplemvvmcleanarch.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmcleanarch.R
import com.example.samplemvvmcleanarch.databinding.ItemMovieBinding
import com.example.samplemvvmcleanarch.domin.models.MovieModel

class MovieViewHolder(private val parent: ViewGroup,
                      private val binding: ItemMovieBinding = DataBindingUtil.inflate(
                              LayoutInflater.from(parent.context),
                              R.layout.item_movie,
                              parent,
                              false
                      )) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieModel?) {
        movie.let {
            binding.movie = it
        }
    }
}