package com.example.doordashlite.network

import com.example.doordashlite.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DoorDashApiGateway {
    @GET("v1/store_feed")
    suspend fun getRestaurants(
        @Query("lat") latitude: Float,
        @Query("lng") longitude: Float,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ApiResponse
}