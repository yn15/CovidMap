package com.ehdwn.covidmap

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.odcloud.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService():ApiGet{
        return getRetrofit().create(ApiGet::class.java)
    }
}