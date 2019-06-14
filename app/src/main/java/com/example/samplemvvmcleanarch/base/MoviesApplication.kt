package com.example.samplemvvmcleanarch.base

import android.app.Application
import com.example.samplemvvmcleanarch.di.application.AppComponent
import com.example.samplemvvmcleanarch.di.application.AppModule
import com.example.samplemvvmcleanarch.di.application.DaggerAppComponent

/**
 * MoviesApplication is the base application class of the app that we initialize inside it Timper, LeakCanary and Dagger Modules.
 */

class MoviesApplication : Application() {

    lateinit var applicationComponent: AppComponent

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

}