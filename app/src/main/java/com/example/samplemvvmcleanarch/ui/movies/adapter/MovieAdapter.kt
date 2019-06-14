package com.example.samplemvvmcleanarch.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvmcleanarch.R
import com.example.samplemvvmcleanarch.domin.models.MovieModel
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import javax.inject.Inject

/**
 * MovieAdapter is the movie adapter for movie list.
 */

@ActivityScope
class MovieAdapter
@Inject
constructor()
    : RecyclerView.Adapter<MovieViewHolder>() {

    private var moviesList: ArrayList<MovieModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount() = moviesList.size

    fun getMovies() = moviesList

    fun add(items: List<MovieModel>?) {
        items?.let {
            moviesList.addAll(it)
            val uniqueMoviesList = moviesList.distinctBy { movie ->
                movie.id
            }
            moviesList.clear()
            moviesList.addAll(uniqueMoviesList)
            notifyDataSetChanged()
        }
    }

    fun clear() {
        moviesList.clear()
        notifyDataSetChanged()
    }
}