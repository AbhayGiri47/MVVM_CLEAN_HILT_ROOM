package com.example.mvvmcleanhiltroom.domain.usecase

import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.repository.ExampleRepository
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import javax.inject.Inject

class ExampleUseCase @Inject constructor(private val exampleRepository: ExampleRepository) {
    suspend fun getIndNzMatchDetails(): Result<INDNZMatchDetailsResponse> {
        return exampleRepository.getIndNzMatchDetails()
    }

    suspend fun getSaPakMatchDetails(): Result<SAPAKMatchDetailsResponse> {
        return exampleRepository.getSaPakMatchDetails()
    }

    suspend fun getExampleToken(): Result<String> {
        return exampleRepository.getExampleToken()
    }

    suspend fun setExampleToken(token:String){
        exampleRepository.setExampleToken(token)
    }
}