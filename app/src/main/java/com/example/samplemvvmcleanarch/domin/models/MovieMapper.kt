package com.example.samplemvvmcleanarch.domin.models

import javax.inject.Inject

class MovieMapper
@Inject
constructor(){

    fun toMovieEntity(movieResponse: MovieResponse) = MovieEntity(
            movieResponse.id,
            movieResponse.overview,
            movieResponse.originalLanguage,
            movieResponse.originalTitle,
            movieResponse.title,
            movieResponse.releaseDate,
            movieResponse.voteAverage,
            movieResponse.popularity,
            movieResponse.voteCount,
            movieResponse.backdropPath
    )

    fun toMovieModel(movieResponse: MovieResponse) = MovieModel(
            movieResponse.id,
            movieResponse.overview,
            movieResponse.originalLanguage,
            movieResponse.originalTitle,
            movieResponse.title,
            movieResponse.releaseDate,
            movieResponse.voteAverage,
            movieResponse.popularity,
            movieResponse.voteCount,
            movieResponse.backdropPath
    )

    fun toMovieModel(movieResponse: MovieEntity) = MovieModel (
            movieResponse.id,
            movieResponse.overview,
            movieResponse.originalLanguage,
            movieResponse.originalTitle,
            movieResponse.title,
            movieResponse.releaseDate,
            movieResponse.voteAverage,
            movieResponse.popularity,
            movieResponse.voteCount,
            movieResponse.backdropPath
    )

    fun toMovieEntities(movieResponses: List<MovieResponse>) = movieResponses.map { toMovieEntity(it) }

    fun toMovieModels(movieResponses: List<MovieResponse>) = movieResponses.map { toMovieModel(it) }
}