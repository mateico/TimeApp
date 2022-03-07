package com.example.myapplicationtestlearning.feature_coindesk.domain.use_case

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.CurrentTimeRepository
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow

class GetCurrentTime(
    private val repository: CurrentTimeRepository
) {

    operator fun invoke(): Flow<Resource<CurrentTime>> {
        return repository.getCurrentTime()
    }

}