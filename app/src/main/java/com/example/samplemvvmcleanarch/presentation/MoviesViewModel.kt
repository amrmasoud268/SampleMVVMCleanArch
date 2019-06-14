package com.example.samplemvvmcleanarch.presentation

import androidx.lifecycle.ViewModel
import com.example.samplemvvmcleanarch.domin.ues_cases.MovieUseCase
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import javax.inject.Inject

@ActivityScope
class MoviesViewModel
@Inject
constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    var moviesLiveData = movieUseCase.moviesLiveData()

    fun fetchMovies(pageNumber: Int) = movieUseCase.getMovies(pageNumber)

    override fun onCleared() {
        super.onCleared()
        movieUseCase.unSubscribe()
    }
}