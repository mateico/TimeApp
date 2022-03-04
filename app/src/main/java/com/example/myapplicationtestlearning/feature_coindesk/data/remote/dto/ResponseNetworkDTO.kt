package com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto

data class ResponseNetworkDTO(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)