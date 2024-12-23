package com.example.mvvmcleanhiltroom.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmcleanhiltroom.data.cache.rooms.dao.ExampleDao
import com.example.mvvmcleanhiltroom.data.cache.rooms.db.ExampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val APP_DB_NAME = "example_database"

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): ExampleDatabase {
        return Room.databaseBuilder(
            context,
            ExampleDatabase::class.java,
            APP_DB_NAME
        ).build()
    }

    @Provides
    fun providesUserDao(database: ExampleDatabase): ExampleDao {
        return database.exampleDao()
    }
}