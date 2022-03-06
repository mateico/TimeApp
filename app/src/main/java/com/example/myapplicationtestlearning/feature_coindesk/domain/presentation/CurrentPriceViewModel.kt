package com.example.myapplicationtestlearning.feature_coindesk.domain.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time
import com.example.myapplicationtestlearning.feature_coindesk.domain.use_case.GetCurrentPrice
import com.example.myapplicationtestlearning.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentPriceViewModel @Inject constructor(
    private val getCurrentPrice: GetCurrentPrice
): ViewModel() {

    private val _state = mutableStateOf(CurrentPriceState())
    val state: State<CurrentPriceState> = _state

    private var job: Job? = null

    fun onGetCurrentPrice(){
        job?.cancel()
        job = viewModelScope.launch {
            getCurrentPrice()
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                currentPrice = result.data ?: ResponseNetwork("", "", Time("", "", "")),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                currentPrice = result.data ?: ResponseNetwork("", "", Time("", "", "")),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                currentPrice = result.data ?: ResponseNetwork("", "", Time("", "", "")),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}