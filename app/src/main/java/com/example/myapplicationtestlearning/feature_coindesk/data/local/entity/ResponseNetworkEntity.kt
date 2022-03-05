package com.example.myapplicationtestlearning.feature_coindesk.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time

@Entity(tableName = "responsenetwork")
data class ResponseNetworkEntity(
    @PrimaryKey val chartName: String,
    val disclaimer: String,
    val time: Time
) {
    fun toResponseNetwork(): ResponseNetwork {
        return ResponseNetwork(
            chartName = chartName,
            disclaimer = disclaimer,
            time = time
        )
    }
}