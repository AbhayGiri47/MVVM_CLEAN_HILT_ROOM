package com.example.mvvmcleanhiltroom.di

import com.example.mvvmcleanhiltroom.data.example.impl.ExampleRepositoryImpl
import com.example.mvvmcleanhiltroom.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindsMatchDetailsRepository(matchRepositoryImpl: ExampleRepositoryImpl):ExampleRepository
}