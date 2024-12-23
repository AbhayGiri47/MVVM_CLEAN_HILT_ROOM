package com.example.mvvmcleanhiltroom.data.cache.rooms.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcleanhiltroom.data.cache.rooms.dao.ExampleDao
import com.example.mvvmcleanhiltroom.data.cache.rooms.entity.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class ExampleDatabase :RoomDatabase() {

    abstract fun exampleDao(): ExampleDao
}