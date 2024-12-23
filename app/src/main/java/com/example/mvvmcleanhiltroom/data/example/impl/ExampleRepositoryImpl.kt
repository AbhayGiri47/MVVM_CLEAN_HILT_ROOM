package com.example.mvvmcleanhiltroom.data.example.impl

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.example.store.ExampleDataStoreFactory
import com.example.mvvmcleanhiltroom.domain.repository.ExampleRepository
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject


class ExampleRepositoryImpl @Inject constructor(
    private val exampleDataStoreFactory: ExampleDataStoreFactory
) : ExampleRepository {

    override suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse>{
        return when (val result =
            exampleDataStoreFactory.getRemoteDataStore().getIndNzMatchDetails()){
            is Result.Success-> {
                with(exampleDataStoreFactory.getCacheDataStore()) {
                    saveIndNzMatchDetailsResponse(result.data)
                }
                Result.Success(result.data)
            }
            else -> Result.Error(java.lang.Exception())
        }
    }

    override suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse> {
        return exampleDataStoreFactory.getRemoteDataStore().getSaPakMatchDetails()
    }

    override suspend fun getSavedIndNzMatchDetailsResponse(): Result<INDNZMatchDetailsResponse> {
        return exampleDataStoreFactory.getCacheDataStore().getSavedIndNzMatchDetailsResponse()
    }

    override suspend fun deleteIndNzMatchDetailsResponse() {
        exampleDataStoreFactory.getCacheDataStore().deleteIndNzMatchDetailsResponse()
    }

    override suspend fun getExampleToken(): Result<String> {
        return exampleDataStoreFactory.getCacheDataStore().getExampleToken()
    }

    override suspend fun setExampleToken(token: String) {
        exampleDataStoreFactory.getCacheDataStore().setExampleToken(token)
    }
}