package com.example.samplemvvmcleanarch.di.activity

import com.example.samplemvvmcleanarch.di.view_model.ViewModelModule
import com.example.samplemvvmcleanarch.ui.movies.MoviesActivity
import dagger.Subcomponent

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects
 * (i.e. [ActivityModule]), and the object which expresses a dependency.
 */

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(moviesActivity: MoviesActivity)
}