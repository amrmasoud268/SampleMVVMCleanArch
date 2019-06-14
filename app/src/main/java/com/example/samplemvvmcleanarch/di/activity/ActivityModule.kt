package com.example.samplemvvmcleanarch.di.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * This class is responsible for providing the requested objects to [ActivityScope] annotated classes
 */

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @ActivityScope
    @Provides
    @ForActivity
    internal fun provideActivityContext(): Context {
        return activity
    }

    @ActivityScope
    @Provides
    internal fun provideFragmentManager(): FragmentManager {
        return (activity as AppCompatActivity).supportFragmentManager
    }

}