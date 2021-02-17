package com.example.doordashlite.di

import com.example.doordashlite.network.DoorDashApiGateway
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @Singleton
    @Provides
    fun getRetrofit() = Retrofit.Builder()
        .baseUrl("https://api.doordash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun getDoordashApi(retrofit: Retrofit): DoorDashApiGateway = retrofit.create(DoorDashApiGateway::class.java)
}