package com.example.myapplicationtestlearning.feature_coindesk.data.remote

import com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto.CurrentTimeDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TimeApi {

    @GET("Time/current/zone?timeZone=Europe/Amsterdam")
    suspend fun getCurrentTime() : CurrentTimeDTO

    companion object{
        var BASE_URL = "https://www.timeapi.io/api/"

        fun create() : TimeApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(TimeApi::class.java)
        }
    }

}