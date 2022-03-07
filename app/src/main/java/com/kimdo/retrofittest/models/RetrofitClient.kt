package com.kimdo.retrofittest.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val  baseurl = "https://jsonplaceholder.typicode.com"
    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val instance: RetrofitApiService by lazy {
        retrofit.build().create(RetrofitApiService::class.java)
    }
}