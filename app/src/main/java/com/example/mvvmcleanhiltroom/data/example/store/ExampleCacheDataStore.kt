package com.example.mvvmcleanhiltroom.data.example.store

import com.example.mvvmcleanhiltroom.data.example.repository.ExampleCache
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleDataStore
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject

class ExampleCacheDataStore @Inject constructor(private val exampleCache: ExampleCache) : ExampleDataStore {
    override suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse> {
        throw UnsupportedOperationException("Response from Cache is Not Supported")
    }

    override suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse> {
        throw UnsupportedOperationException("Response from Cache is Not Supported")
    }

    override suspend fun saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse: INDNZMatchDetailsResponse) {
       exampleCache.saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse)
    }

    override suspend fun getSavedIndNzMatchDetailsResponse():Result<INDNZMatchDetailsResponse> {
        return exampleCache.getSavedIndNzMatchDetailsResponse()
    }

    override suspend fun deleteIndNzMatchDetailsResponse() {
        exampleCache.deleteIndNzMatchDetailsResponse()
    }

    override suspend fun getExampleToken(): Result<String> {
        return exampleCache.getExampleToken()
    }

    override suspend fun setExampleToken(token: String) {
       exampleCache.setExampleToken(token)
    }

}