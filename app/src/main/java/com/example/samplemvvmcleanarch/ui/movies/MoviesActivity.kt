package com.example.samplemvvmcleanarch.ui.movies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplemvvmcleanarch.R
import com.example.samplemvvmcleanarch.base.MoviesApplication
import com.example.samplemvvmcleanarch.di.activity.ActivityModule
import com.example.samplemvvmcleanarch.domin.models.NetworkState
import com.example.samplemvvmcleanarch.presentation.MoviesViewModel
import com.example.samplemvvmcleanarch.ui.bases.BaseActivity
import com.example.samplemvvmcleanarch.ui.movies.adapter.MovieAdapter
import com.example.samplemvvmcleanarch.utils.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_movies.*
import javax.inject.Inject

class MoviesActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MoviesViewModel

    @Inject
    lateinit var adapter: MovieAdapter

    override fun injectActivity() {
        (application as? MoviesApplication)?.applicationComponent?.plus(ActivityModule(this))?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MoviesViewModel::class.java]

        initAdapter()
        initSwipeToRefresh()
        observeMoviesList()
        fetchMovies()

    }

    private fun initAdapter() {
        rvMovies.adapter = adapter
        rvMovies.addOnScrollListener(object : EndlessRecyclerViewScrollListener(rvMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                fetchMovies(page)
            }
        })
    }

    private fun initSwipeToRefresh() {
        movies_swipe_refresh_layout.setOnRefreshListener {
            fetchMovies()
        }
    }

    private fun observeMoviesList() {
        viewModel.moviesLiveData.observe(this, Observer { moviesLiveData ->
            movies_swipe_refresh_layout.post {
                movies_swipe_refresh_layout.isRefreshing =
                        moviesLiveData.networkState.status == NetworkState.LOADING.status
            }
            when (moviesLiveData.networkState) {
                NetworkState.Success -> {
                    adapter.add(moviesLiveData?.movieModels)
                    showEmptyList(moviesLiveData.movieModels?.isEmpty() ?: false)
                }
                NetworkState.LOADING -> {
                    // Loading
                }
                else -> {
                    showEmptyList(moviesLiveData.networkState.message != null, moviesLiveData.networkState.message)
                }
            }
        })
    }

    private fun fetchMovies(pageNumber: Int = 1) {
        viewModel.fetchMovies(pageNumber)
        if (pageNumber == 1)
            adapter.clear()
    }

    private fun showEmptyList(show: Boolean, message: String? = null) {
        message?.let {
            tvEmptyView.text = it
        }
        if (show && adapter.getMovies().isEmpty()) {
            tvEmptyView.visibility = View.VISIBLE
            rvMovies.visibility = View.GONE
        } else {
            tvEmptyView.visibility = View.GONE
            rvMovies.visibility = View.VISIBLE
        }
    }
}
