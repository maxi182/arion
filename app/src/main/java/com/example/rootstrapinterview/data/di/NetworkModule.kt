package com.example.rootstrapinterview.data.di

import com.example.rootstrapinterview.BuildConfig
import com.example.rootstrapinterview.api.ApiEndpoints
import com.example.rootstrapinterview.api.ResponseHandler

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Maxi
 * since 19/12/2020
 */

private const val BASE_URL = "https://rickandmortyapi.com/api/"

val NetworkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        val client = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG) {
            client.addInterceptor(get<HttpLoggingInterceptor>())
        }
        client.build()
    }

    single {
        get<Retrofit>().create(ApiEndpoints::class.java)
    }

    factory { ResponseHandler() }

}
