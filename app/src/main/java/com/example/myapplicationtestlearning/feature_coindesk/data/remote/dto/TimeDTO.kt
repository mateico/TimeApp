package com.example.myapplicationtestlearning.feature_coindesk.data.remote.dto

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time

data class TimeDTO(
    val updated: String,
    val updatedISO: String,
    val updateduk: String
) {
    fun toTime(): Time {
        return Time(
            updated = updated,
            updatedISO = updatedISO,
            updateduk = updateduk
        )
    }
}