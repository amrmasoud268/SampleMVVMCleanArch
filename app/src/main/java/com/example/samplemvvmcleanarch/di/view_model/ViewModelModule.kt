package com.example.samplemvvmcleanarch.di.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplemvvmcleanarch.ui.bases.ViewModelFactory
import com.example.samplemvvmcleanarch.presentation.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * ViewModel Module that provides Movie List ViewModel.
 */

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    internal abstract fun bindMoviesViewModel(viewModel: MoviesViewModel): ViewModel

}