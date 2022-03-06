package com.example.myapplicationtestlearning.feature_coindesk.domain.presentation

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time

data class CurrentPriceState(
    val currentPrice: ResponseNetwork = ResponseNetwork("", "", Time("", "", "")),
    val isLoading: Boolean = false
)