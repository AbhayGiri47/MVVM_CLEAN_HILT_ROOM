package com.example.mvvmcleanhiltroom.di

import com.example.mvvmcleanhiltroom.data.remote.impl.ExampleRemoteImpl
import com.example.mvvmcleanhiltroom.data.remote.services.ExampleService
import com.example.mvvmcleanhiltroom.data.example.repository.ExampleRemote
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module()
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    companion object {
        @Provides
        fun providesAuthService(retrofit: Retrofit): ExampleService {
            return retrofit.create(ExampleService::class.java)
        }
    }

    @Binds
    abstract fun bindsMatchDetailsRemote(matchDetailsRemoteImpl: ExampleRemoteImpl): ExampleRemote
}