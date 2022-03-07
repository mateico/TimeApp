package com.example.myapplicationtestlearning.feature_coindesk.domain.repository

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow

interface CurrentTimeRepository {

    fun getCurrentTime(): Flow<Resource<CurrentTime>>
}