package com.example.mvvmcleanhiltroom.presentation.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanhiltroom.data.response.INDNZMatchDetailsResponse
import com.example.mvvmcleanhiltroom.data.response.SAPAKMatchDetailsResponse
import com.example.mvvmcleanhiltroom.domain.CoroutinesDispatcherProvider
import com.example.mvvmcleanhiltroom.domain.response.base.Result
import com.example.mvvmcleanhiltroom.domain.usecase.ExampleUseCase
import com.example.mvvmcleanhiltroom.presentation.states.Resource
import com.example.mvvmcleanhiltroom.presentation.states.ResourceState
import com.example.mvvmcleanhiltroom.utils.getErrorDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val dispatcher: CoroutinesDispatcherProvider,
    private val exampleUseCase: ExampleUseCase
) : ViewModel() {

    private val _indNzMatchDetails =
        MutableStateFlow<Resource<INDNZMatchDetailsResponse>?>(null)
    val indNzMatchDetails get() = _indNzMatchDetails.asStateFlow()

    private val _saPakMatchDetails =
        MutableStateFlow<Resource<SAPAKMatchDetailsResponse>?>(null)
    val saPakMatchDetails get() = _saPakMatchDetails.asStateFlow()

    private val _exampleToken =MutableStateFlow<Resource<String>?>(null)
    val exampleToken get() = _exampleToken.asStateFlow()


    fun getIndNzMatchDetails() = viewModelScope.launch {
        _indNzMatchDetails.value = Resource(ResourceState.LOADING)
        val result = withContext(dispatcher.io) {
            return@withContext exampleUseCase.getIndNzMatchDetails()
        }
        when (result) {
            is Result.Success -> {
                _indNzMatchDetails.value = Resource(ResourceState.SUCCESS, data = result.data)
            }

            is Result.Error -> {
                _indNzMatchDetails.value =
                    Resource(ResourceState.ERROR, error = result.exception.getErrorDetails())
            }
        }
    }

    fun getSaPakMatchDetails() = viewModelScope.launch(dispatcher.io) {
        _saPakMatchDetails.value = Resource(ResourceState.LOADING)
        val result = withContext(dispatcher.io) {
            return@withContext exampleUseCase.getSaPakMatchDetails()
        }
        when (result) {
            is Result.Success -> {
                _saPakMatchDetails.value = Resource(ResourceState.SUCCESS, data = result.data)

            }

            is Result.Error -> {
                _saPakMatchDetails.value =
                    Resource(ResourceState.ERROR, error = result.exception.getErrorDetails())
            }
        }
    }

    fun getExampleToken() = viewModelScope.launch(dispatcher.io) {
        _exampleToken.value = Resource(ResourceState.LOADING)
        val result = withContext(dispatcher.io) {
            return@withContext exampleUseCase.getExampleToken()
        }
        when (result) {
            is Result.Success -> {
                _exampleToken.value = Resource(ResourceState.SUCCESS, data = result.data)
            }
            is Result.Error -> {
                _exampleToken.value =
                    Resource(ResourceState.ERROR, error = result.exception.getErrorDetails())
            }

        }

    }

    fun setExampleToken(token:String) = viewModelScope.launch(dispatcher.io) {
        exampleUseCase.setExampleToken(token)
    }


}