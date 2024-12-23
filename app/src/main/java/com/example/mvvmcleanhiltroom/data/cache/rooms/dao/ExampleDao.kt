package com.example.mvvmcleanhiltroom.data.cache.rooms.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.ExampleEntity

@Dao
interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExampleData(exampleEntity: ExampleEntity)

    @Query("SELECT * FROM table_example")
    suspend fun getExampleData(): ExampleEntity

    @Query("DELETE FROM table_example ")
    suspend fun deleteExampleData()
}