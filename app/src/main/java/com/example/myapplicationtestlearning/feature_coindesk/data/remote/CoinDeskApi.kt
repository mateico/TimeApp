package com.example.myapplicationtestlearning.feature_coindesk.data.remote

import com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto.ResponseNetworkDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoinDeskApi {

    @GET("bpi/currentprice.json")
    suspend fun getCurrentPrice() : ResponseNetworkDTO

    companion object{
        var BASE_URL = "https://api.coindesk.com/v1/"

        fun create() : CoinDeskApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CoinDeskApi::class.java)
        }
    }

}