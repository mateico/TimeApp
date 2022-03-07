package com.example.myapplicationtestlearning.feature_coindesk.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.CurrentTimeEntity

@Database(
    entities = [CurrentTimeEntity::class],
    version = 1
)

abstract class CurrentTimeDatabase: RoomDatabase() {

    abstract val dao: CurrentTimeDao

}