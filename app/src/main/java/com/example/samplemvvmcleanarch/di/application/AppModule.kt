package com.example.samplemvvmcleanarch.di.application

import android.app.Application
import android.content.Context
import com.example.samplemvvmcleanarch.data.local.DatabaseManager
import com.example.samplemvvmcleanarch.data.network.ServiceBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * This class is responsible for providing the requested objects to [ApplicationScope] annotated classes
 */

@Module
class AppModule(private val application: Application) {

    @ApplicationScope
    @Provides
    internal fun providesApplication(): Application {
        return application
    }

    @ApplicationScope
    @Provides
    @ForApplication
    internal fun providesApplicationContext(): Context {
        return application
    }


    @Provides
    internal fun providesMovieAPI() = ServiceBuilder().movieAPI


    @Provides
    internal fun providesMovieDao() = DatabaseManager.getInstance(application).movieDao()

    @Provides
    internal fun providesCompositeDisposable() = CompositeDisposable()
}