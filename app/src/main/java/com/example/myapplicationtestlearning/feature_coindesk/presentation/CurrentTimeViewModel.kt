package com.example.myapplicationtestlearning.feature_coindesk.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime
import com.example.myapplicationtestlearning.feature_coindesk.domain.use_case.GetCurrentTimeUseCase
import com.example.myapplicationtestlearning.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentTimeViewModel @Inject constructor(
    private val getCurrentTimeUseCase: GetCurrentTimeUseCase
): ViewModel() {

    private val _state = mutableStateOf(CurrentTimeState())
    val state: State<CurrentTimeState> = _state

    private var job: Job? = null

    fun onGetCurrentTime(){
        job?.cancel()
        job = viewModelScope.launch {
            getCurrentTimeUseCase()
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                currentTime = result.data ?: CurrentTime(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                currentTime = result.data ?: CurrentTime(),
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                currentTime = result.data ?: CurrentTime(),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}