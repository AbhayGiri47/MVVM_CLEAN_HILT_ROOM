package com.example.mvvmcleanhiltroom.data.example.repository

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result

interface ExampleDataStore {

    suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse>
    suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse>

    suspend fun saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse:INDNZMatchDetailsResponse)
    suspend fun getSavedIndNzMatchDetailsResponse(): Result<INDNZMatchDetailsResponse>
    suspend fun deleteIndNzMatchDetailsResponse()

    suspend fun getExampleToken(): Result<String>
    suspend fun setExampleToken(token:String)
}