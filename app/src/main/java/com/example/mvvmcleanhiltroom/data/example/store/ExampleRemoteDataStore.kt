package com.example.mvvmcleanhiltroom.data.example.store

import com.example.mvvmcleanhiltroom.data.example.repository.ExampleDataStore
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleRemote
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject

class ExampleRemoteDataStore @Inject constructor(
    private val matchDetailsRemote: ExampleRemote
) :
    ExampleDataStore {
    override suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse> {
        return matchDetailsRemote.getIndNzMatchDetails()
    }

    override suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse> {
        return matchDetailsRemote.getSaPakMatchDetails()
    }

    override suspend fun saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse: INDNZMatchDetailsResponse) {
        throw UnsupportedOperationException("Response from Remote is Not Supported")
    }

    override suspend fun getSavedIndNzMatchDetailsResponse(): Result<INDNZMatchDetailsResponse> {
        throw UnsupportedOperationException("Response from Remote is Not Supported")
    }

    override suspend fun getExampleToken(): Result<String> {
        throw UnsupportedOperationException("Response from Remote is Not Supported")
    }

    override suspend fun setExampleToken(token: String) {
        throw UnsupportedOperationException("Response from Remote is Not Supported")
    }

    override suspend fun deleteIndNzMatchDetailsResponse() {
        throw UnsupportedOperationException("Response from Remote is Not Supported")
    }
}