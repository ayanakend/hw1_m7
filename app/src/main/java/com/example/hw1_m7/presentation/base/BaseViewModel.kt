package com.example.hw1_m7.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw1_m7.domain.utils.Resource
import com.example.hw1_m7.presentation.ui.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            viewModelScope.launch {
                this@collectData.collect() { res ->
                    when (res) {
                        is Resource.Error -> {
                            _state.value = UIState.Error(res.message!!)
                        }

                        is Resource.Loading -> {
                            _state.value = UIState.Loading()
                        }

                        is Resource.Success -> {
                            if (res.data != null)
                                _state.value = UIState.Success(res.data)
                        }
                    }

                }
            }
        }
    }
}