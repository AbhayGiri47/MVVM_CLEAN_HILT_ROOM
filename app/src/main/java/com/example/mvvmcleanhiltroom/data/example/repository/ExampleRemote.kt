package com.example.mvvmcleanhiltroom.data.example.repository

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.response.base.Result

interface ExampleRemote {

    suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse>
    suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse>
}