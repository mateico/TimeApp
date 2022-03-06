package com.example.myapplicationtestlearning.feature_coindesk.domain.use_case

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.ResponseNetworkRepository
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow

class GetCurrentPrice(
    private val repository: ResponseNetworkRepository
) {

    operator fun invoke(): Flow<Resource<ResponseNetwork>> {
        return repository.getResponseNetwork()
    }

}