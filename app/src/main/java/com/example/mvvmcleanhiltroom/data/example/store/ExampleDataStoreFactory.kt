package com.example.mvvmcleanhiltroom.data.example.store

import javax.inject.Inject

class ExampleDataStoreFactory @Inject constructor(
    private val remoteDataStore: ExampleRemoteDataStore,
    private val cacheDataStore: ExampleCacheDataStore
) {
    fun getRemoteDataStore(): ExampleRemoteDataStore = remoteDataStore
    fun getCacheDataStore(): ExampleCacheDataStore = cacheDataStore

}