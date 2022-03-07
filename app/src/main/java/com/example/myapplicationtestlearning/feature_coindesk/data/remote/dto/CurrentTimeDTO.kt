package com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto

import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.CurrentTimeEntity
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime

data class CurrentTimeDTO(
    val date: String,
    val dateTime: String,
    val day: Int,
    val dayOfWeek: String,
    val dstActive: Boolean,
    val hour: Int,
    val milliSeconds: Int,
    val minute: Int,
    val month: Int,
    val seconds: Int,
    val time: String,
    val timeZone: String,
    val year: Int
) {
    fun toCurrentTimeEntity(): CurrentTimeEntity {
        return CurrentTimeEntity(
            dateTime = dateTime,
            timeZone = timeZone
        )
    }
}