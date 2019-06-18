package com.example.samplemvvmcleanarch.ui.movies.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import com.example.samplemvvmcleanarch.domin.models.MovieModel
import javax.inject.Inject

/**
 * MovieAdapter is the movie adapter for movie list.
 */

@ActivityScope
class MovieAdapter
@Inject
constructor() : RecyclerView.Adapter<MovieViewHolder>() {

    private var moviesList: ArrayList<MovieModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount() = moviesList.size

    fun getMovies() = moviesList

    fun setMovies(items: List<MovieModel>?) {
        items?.let {
            moviesList.clear()
            moviesList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clear() {
        moviesList.clear()
        notifyDataSetChanged()
    }

}