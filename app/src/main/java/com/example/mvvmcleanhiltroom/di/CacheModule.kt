package com.example.mvvmcleanhiltroom.di

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvmcleanhiltroom.data.cache.example.impl.ExampleCacheImpl
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleCache
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val CONSUMER_PREFS = "example_preferences"

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    companion object {
        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
            return context.getSharedPreferences(CONSUMER_PREFS, Context.MODE_PRIVATE)
        }

        @Provides
        fun provideGson(): Gson {
            return Gson()
        }
    }

    @Binds
    abstract fun bindsExampleCache(exampleCacheImpl: ExampleCacheImpl): ExampleCache

}