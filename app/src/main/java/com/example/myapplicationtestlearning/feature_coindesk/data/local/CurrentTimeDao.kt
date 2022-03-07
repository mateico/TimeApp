package com.example.myapplicationtestlearning.feature_coindesk.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.CurrentTimeEntity

@Dao
interface CurrentTimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentTime(currentTime: CurrentTimeEntity)

    @Query("DELETE FROM currenttime")
    suspend fun deleteCurrentTime()

    @Query("SELECT * FROM currenttime")
    suspend fun getCurrentTime(): CurrentTimeEntity

}