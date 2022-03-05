package com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto

import androidx.room.Ignore
import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.ResponseNetworkEntity
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork

data class ResponseNetworkDTO(
    val bpi: BpiDTO,
    val chartName: String,
    val disclaimer: String,
    val time: TimeDTO
) {
    fun toResponseNetworkEntity(): ResponseNetworkEntity {
        return ResponseNetworkEntity(
            chartName = chartName,
            disclaimer = disclaimer,
            time = time.toTime()
        )
    }
}