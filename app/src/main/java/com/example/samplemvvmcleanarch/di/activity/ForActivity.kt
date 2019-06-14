package com.example.samplemvvmcleanarch.di.activity

import javax.inject.Qualifier

/**
 * This qualifier is used for distinguishing between similar objects during a dependency injection.
 * (i.e. Activity context and App context), acts like [javax.inject.Named]
 */

@Qualifier
annotation class ForActivity