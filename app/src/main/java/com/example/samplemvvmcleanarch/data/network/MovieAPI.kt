package com.example.samplemvvmcleanarch.data.network

import com.example.samplemvvmcleanarch.domin.models.MovieResponse
import com.example.samplemvvmcleanarch.domin.models.MoviesResponse
import com.example.samplemvvmcleanarch.di.application.ApplicationScope
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * API Endpoints
 */
@ApplicationScope
interface MovieAPI {

    @GET("/3/movie/popular")
    fun getMovies(@Query("page") pageNumber: Int): Single<MoviesResponse>

    @GET("/3/movie/{id}")
    fun getMovie(@Path("id") movieId: Int): Single<MovieResponse>

}