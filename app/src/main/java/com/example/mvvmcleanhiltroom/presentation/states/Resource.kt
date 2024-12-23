package com.example.mvvmcleanhiltroom.presentation.states

import com.example.mvvmcleanhiltroom.domain.ErrorDetails

class Resource<T>(
    val status: ResourceState,
    val data: T? = null,
    val error: ErrorDetails? = null,
)
