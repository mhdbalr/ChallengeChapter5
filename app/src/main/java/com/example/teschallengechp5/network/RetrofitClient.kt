package com.example.teschallengechp5.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL2 = "https://api.themoviedb.org/3/"

    val instance : ResultApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ResultApi::class.java)
    }
}