package com.example.samplemvvmcleanarch.utils

import com.example.samplemvvmcleanarch.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object NetworkUtils {
    fun provideHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
//        httpClient.readTimeout(settings.timeout, TimeUnit.MILLISECONDS)
//        httpClient.writeTimeout(settings.timeout, TimeUnit.MILLISECONDS)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(logging)
        httpClient.addInterceptor { chain: Interceptor.Chain ->
            kotlin.run {
                val original = chain.request()
                val originalHttpUrl = original.url()

                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build()

                val requestBuilder = original.newBuilder().url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
        }

        return httpClient.build()
    }
}