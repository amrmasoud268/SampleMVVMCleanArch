package com.example.samplemvvmcleanarch.data.repositories

import com.example.samplemvvmcleanarch.data.local.MovieDao
import com.example.samplemvvmcleanarch.data.network.MovieAPI
import com.example.samplemvvmcleanarch.domin.models.MovieMapper
import com.example.samplemvvmcleanarch.domin.models.MovieModel
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

@ActivityScope
class MovieRepo
@Inject
constructor(private val movieAPI: MovieAPI, private val movieDao: MovieDao){

    @Inject
    lateinit var movieMapper: MovieMapper

    fun getMovies(pageNumber: Int): Flowable<List<MovieModel>?> {

        val localMovie =
                movieDao.getMovies.map { movieEntityList ->
                    movieEntityList.map { movieEntity ->
                        movieMapper.toMovieModel(movieEntity)
                    }
                }

        val remoteMovie =
                movieAPI.getMovies(pageNumber).map { movieResponses ->
                    movieResponses.results?.map { movieResponse ->
                        if (pageNumber == 1)
                            movieDao.insertMovie(movieMapper.toMovieEntity(movieResponse))
                        movieMapper.toMovieModel(movieResponse)
                    }
                }

        if (pageNumber == 1)
            return Single.concat<List<MovieModel>>(localMovie, remoteMovie)

        return remoteMovie.toFlowable()
    }
}