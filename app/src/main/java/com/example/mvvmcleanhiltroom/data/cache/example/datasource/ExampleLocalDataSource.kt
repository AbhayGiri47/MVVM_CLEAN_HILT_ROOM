package com.example.mvvmcleanhiltroom.data.cache.example.datasource

import com.example.mvvmcleanhiltroom.data.cache.rooms.dao.ExampleDao
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.ExampleEntity
import javax.inject.Inject

class ExampleLocalDataSource @Inject constructor(private val exampleDao: ExampleDao) {

    suspend fun getExampleData(): ExampleEntity = exampleDao.getExampleData()

    suspend fun saveExampleData(exampleEntity: ExampleEntity) = exampleDao.insertExampleData(exampleEntity)

    suspend fun deleteExampleData() = exampleDao.deleteExampleData()
}