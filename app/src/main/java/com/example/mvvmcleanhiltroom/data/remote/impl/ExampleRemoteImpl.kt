package com.example.mvvmcleanhiltroom.data.remote.impl

import com.example.mvvmcleanhiltroom.data.remote.services.ExampleService
import com.example.mvvmcleanhiltroom.data.remote.utils.safeApiCall
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleRemote
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject

class ExampleRemoteImpl @Inject constructor(private val exampleService: ExampleService) :
    ExampleRemote {
    override suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse> {
        return safeApiCall(
            apiCall = {
                exampleService.getINDNZMatchDetails()
            }
        )
    }

    override suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse> {
        return safeApiCall(
            apiCall = {
                exampleService.getSAPAKMatchDetails()
            }
        )
    }

}