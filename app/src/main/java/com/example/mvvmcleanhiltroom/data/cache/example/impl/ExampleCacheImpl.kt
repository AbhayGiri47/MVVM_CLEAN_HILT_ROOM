package com.example.mvvmcleanhiltroom.data.cache.example.impl

import com.example.mvvmcleanhiltroom.data.cache.example.datasource.ExampleLocalDataSource
import com.example.mvvmcleanhiltroom.data.cache.example.datasource.SharedPrefLocalDataSource
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.toExampleEntity
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.toINDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleCache
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject

class ExampleCacheImpl @Inject constructor(
    private val exampleLocalDataSource: ExampleLocalDataSource,
    private val sharedPrefLocalDataSource: SharedPrefLocalDataSource
) : ExampleCache {
    override suspend fun saveIndNzMatchDetailsResponse(indNzMatchDetailsResponse: INDNZMatchDetailsResponse) {
        exampleLocalDataSource.saveExampleData(indNzMatchDetailsResponse.toExampleEntity())
    }

    override suspend fun getSavedIndNzMatchDetailsResponse(): Result<INDNZMatchDetailsResponse> {
        return try {
            val data = exampleLocalDataSource.getExampleData().toINDNZMatchDetailsResponse()
            Result.Success(data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun deleteIndNzMatchDetailsResponse() {
        exampleLocalDataSource.deleteExampleData()
    }

    override suspend fun getExampleToken(): Result<String> {
        return try {
            val user = sharedPrefLocalDataSource.exampleToken ?: ""
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun setExampleToken(token:String){
        sharedPrefLocalDataSource.exampleToken = token
    }
}