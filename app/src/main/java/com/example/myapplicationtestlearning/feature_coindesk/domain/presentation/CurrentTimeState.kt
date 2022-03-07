package com.example.myapplicationtestlearning.feature_coindesk.domain.presentation

import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time

data class CurrentTimeState(
    val currentTime: CurrentTime = CurrentTime("", ""),
    val isLoading: Boolean = false
)