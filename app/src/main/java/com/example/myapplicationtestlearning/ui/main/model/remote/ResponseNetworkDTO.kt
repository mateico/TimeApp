package com.example.myapplicationtestlearning.ui.main.model.remote

data class ResponseNetworkDTO(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)