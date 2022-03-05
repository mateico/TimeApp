package com.example.myapplicationtestlearning.feature_coindesk.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.ResponseNetworkEntity

@Database(
    entities = [ResponseNetworkEntity::class],
    version = 2
)

@TypeConverters(Converters::class)
abstract class ResponseNetworkDatabase: RoomDatabase() {

    abstract val dao: ResponseNetworkDao

}