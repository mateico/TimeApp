package com.example.myapplicationtestlearning.feature_coindesk.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime

@Entity(tableName = "currenttime")
data class CurrentTimeEntity(
        @PrimaryKey val dateTime: String,
        val timeZone: String
) {
    fun toCurrentTime(): CurrentTime {
        return CurrentTime(
            dateTime = dateTime,
            timeZone = timeZone
        )
    }
}