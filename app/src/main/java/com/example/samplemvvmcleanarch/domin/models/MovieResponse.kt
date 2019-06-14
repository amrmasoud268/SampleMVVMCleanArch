package com.example.samplemvvmcleanarch.domin.models

import com.google.gson.annotations.SerializedName

class MoviesResponse(
        @field:SerializedName("page")
        val page: Int? = null,

        @field:SerializedName("total_pages")
        val totalPages: Int? = null,

        @field:SerializedName("results")
        val results: List<MovieResponse>? = null,

        @field:SerializedName("total_results")
        val totalResults: Int? = null
)

class MovieResponse(
        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("overview")
        val overview: String? = null,

        @field:SerializedName("original_language")
        val originalLanguage: String? = null,

        @field:SerializedName("original_title")
        val originalTitle: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("release_date")
        val releaseDate: String? = null,

        @field:SerializedName("vote_average")
        val voteAverage: Double? = null,

        @field:SerializedName("popularity")
        val popularity: Double? = null,

        @field:SerializedName("vote_count")
        val voteCount: Int? = null,

        @field:SerializedName("backdrop_path")
        val backdropPath: String? = null
)