package com.example.samplemvvmcleanarch.domin.ues_cases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.samplemvvmcleanarch.domin.models.MovieModels
import com.example.samplemvvmcleanarch.domin.models.NetworkState
import com.example.samplemvvmcleanarch.data.repositories.MovieRepo
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MovieUseCase
@Inject
constructor(private val movieRepo: MovieRepo){

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private val moviesResponseResult: MutableLiveData<MovieModels> = MutableLiveData()

    fun getMovies(pageNumber: Int) {
        compositeDisposable.add(movieRepo.getMovies(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe
                {
                    moviesResponseResult.postValue(MovieModels(NetworkState.LOADING))
                }
                .subscribe(
                        { moviesList ->
                            moviesList?.let {
                                moviesResponseResult.postValue(MovieModels(NetworkState.Success, it))
                            } ?: run {
                                //logic Error
                                moviesResponseResult.postValue(MovieModels(NetworkState.Error("data is finished!")))
                            }
                        },
                        { throwable ->
                            moviesResponseResult.postValue(MovieModels(NetworkState.Error(
                                    throwable.message ?: "Something Went Wrong!")))
                        }
                )
        )
    }

    fun moviesLiveData(): LiveData<MovieModels> = moviesResponseResult

    fun unSubscribe() {
        compositeDisposable.clear()
    }
}