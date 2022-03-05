package com.example.myapplicationtestlearning.feature_coindesk.domain.repository

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow

interface ResponseNetworkRepository {

    fun getResponseNetwork(response: String): Flow<Resource<ResponseNetwork>>
}