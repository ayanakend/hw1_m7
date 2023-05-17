package com.example.hw1_m7.data.base

import com.example.hw1_m7.domain.utils.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository{

    protected fun <T> doRequest(request: suspend () -> T) = flow{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "unknown error"))
        }
    }
}