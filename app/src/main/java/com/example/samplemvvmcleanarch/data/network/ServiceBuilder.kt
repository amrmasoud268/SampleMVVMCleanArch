package com.example.samplemvvmcleanarch.data.network

import com.example.samplemvvmcleanarch.BuildConfig
import com.example.samplemvvmcleanarch.di.activity.ActivityScope
import com.example.samplemvvmcleanarch.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@ActivityScope
class ServiceBuilder
@Inject
constructor() {

    val movieAPI = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(provideHttpClient())
        .build()
        .create(MovieAPI::class.java)

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
