package com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto

data class GbpDTO(
    val code: String,
    val description: String,
    val rate: String,
    val rate_float: Double,
    val symbol: String
)