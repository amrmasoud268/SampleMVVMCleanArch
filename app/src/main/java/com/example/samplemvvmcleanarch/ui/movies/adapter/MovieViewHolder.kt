package com.example.samplemvvmcleanarch.ui.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmcleanarch.R
import com.example.samplemvvmcleanarch.domin.models.MovieModel
import com.example.samplemvvmcleanarch.utils.loadImage
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: MovieModel?) {
        itemView.tvTitle.text = movie?.title
        itemView.tvRelease.text = String.format(itemView.context.resources.getString(R.string.release_on), movie?.releaseDate)
        itemView.tvVotes.text = String.format(itemView.context.resources.getString(R.string.total_vote), movie?.voteCount)
        itemView.tvRatings.rating = (movie?.voteAverage?.toFloat() ?: 1F / 2)
        movie?.backdropPath?.let { itemView.ivMovie.loadImage(it) }
    }
}