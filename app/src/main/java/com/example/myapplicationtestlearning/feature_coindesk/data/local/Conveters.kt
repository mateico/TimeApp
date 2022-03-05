package com.example.myapplicationtestlearning.feature_coindesk.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.myapplicationtestlearning.feature_coindesk.data.utils.JsonParser
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromTimeJson(json:String): Time {
        return (jsonParser.fromJson<Time>(
            json,
            object: TypeToken<Time>(){}.type
        )?: null) as Time
    }

    @TypeConverter
    fun toTimeJson(time: Time): String {
        return jsonParser.toJson(
            time,
            object: TypeToken<Time>(){}.type
        ) ?: "[]"
    }
}