package com.example.mvvmcleanhiltroom.data.example.repository

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result

interface ExampleCache {

    suspend fun saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse:INDNZMatchDetailsResponse)
    suspend fun getSavedIndNzMatchDetailsResponse(): Result<INDNZMatchDetailsResponse>
    suspend fun deleteIndNzMatchDetailsResponse()

    suspend fun getExampleToken(): Result<String>
    suspend fun setExampleToken(token:String)

}