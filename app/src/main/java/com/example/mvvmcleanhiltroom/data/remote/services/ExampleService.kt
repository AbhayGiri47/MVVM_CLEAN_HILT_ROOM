package com.example.mvvmcleanhiltroom.data.remote.services

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import retrofit2.http.GET

interface ExampleService {

    @GET("nzin01312019187360.json")
    suspend fun getINDNZMatchDetails(): INDNZMatchDetailsResponse

    @GET("sapk01222019186652.json")
    suspend fun getSAPAKMatchDetails(): SAPAKMatchDetailsResponse

}