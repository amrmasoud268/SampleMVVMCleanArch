package com.example.samplemvvmcleanarch.di.application

import com.example.samplemvvmcleanarch.base.MoviesApplication
import com.example.samplemvvmcleanarch.di.activity.ActivityComponent
import com.example.samplemvvmcleanarch.di.activity.ActivityModule
import com.example.samplemvvmcleanarch.di.view_model.ViewModelModule
import dagger.Component

/**
 * This interface is used by dagger to generate the code that defines the connection between the provider of objects
 * (i.e. [AppModule]), and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(moviesApplication: MoviesApplication)

    operator fun plus(activityModule: ActivityModule): ActivityComponent

}