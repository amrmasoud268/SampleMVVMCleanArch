package com.example.samplemvvmcleanarch.domin.models

/**
 * Movie Response that will be appears in the presentation layer.
 */

data class MovieModels(val networkState: NetworkState, val movieModels: List<MovieModel>? = null)

data class MovieModel(
        val id: Int? = null,
        val overview: String? = null,
        val originalLanguage: String? = null,
        val originalTitle: String? = null,
        val title: String? = null,
        val releaseDate: String? = null,
        val voteAverage: Double? = null,
        val popularity: Double? = null,
        val voteCount: Int? = null,
        val backdropPath: String? = null
)