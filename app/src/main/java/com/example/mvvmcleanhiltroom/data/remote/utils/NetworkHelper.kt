package com.example.mvvmcleanhiltroom.data.remote.utils

import com.example.mvvmcleanhiltroom.domain.response.base.Result

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.Success(apiCall())
    } catch (e: Exception) {
        Result.Error(e)
    }
}