package com.example.myapplicationtestlearning.feature_coindesk.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationtestlearning.feature_coindesk.data.local.entity.ResponseNetworkEntity

@Dao
interface ResponseNetworkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResponseNetwork(responseNetwork: ResponseNetworkEntity)

    @Query("DELETE FROM responsenetwork WHERE chartName='Bitcoin'")
    suspend fun deleteResponseNetwork()

    @Query("SELECT * FROM responsenetwork")
    suspend fun getResponseNetwork(): ResponseNetworkEntity

}