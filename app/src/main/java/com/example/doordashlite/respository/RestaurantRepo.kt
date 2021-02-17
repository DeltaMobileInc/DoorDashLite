package com.example.doordashlite.respository

import com.example.doordashlite.model.ApiResponse
import com.example.doordashlite.model.Store
import com.example.doordashlite.network.DoorDashApiGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantRepo @Inject constructor(private val doorDashApiGateway: DoorDashApiGateway) {

    suspend fun getRestaurantsList(offset: Int, limit: Int = 50, latitude: Float = 37.422740f, longitude: Float = -122.139956f): ApiResponse{
        return doorDashApiGateway.getRestaurants(latitude,longitude,offset,limit)
    }
}