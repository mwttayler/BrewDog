package com.punk.shared.data.di

import com.punk.shared.data.api.PunkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object PunkApiModule {

    private const val TIMEOUT_DEFAULT = 15L
    private val TIMEOUT_TIME_UNIT = TimeUnit.SECONDS
    private const val BASE_URL = "https://api.punkapi.com/v2/"

    @Provides
    fun providePunkApi(): PunkApi {
        return retrofit().create(PunkApi::class.java)
    }

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
            .readTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
            .writeTimeout(TIMEOUT_DEFAULT, TIMEOUT_TIME_UNIT)
            .addNetworkInterceptor(httpLoggingInterceptor())
            .build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }
}
