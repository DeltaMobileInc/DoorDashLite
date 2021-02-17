package com.example.doordashlite.repositorytest

import com.example.doordashlite.model.ApiResponse
import com.example.doordashlite.model.Store
import com.example.doordashlite.network.DoorDashApiGateway
import com.example.doordashlite.respository.RestaurantRepo
import com.google.gson.annotations.SerializedName
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(JUnit4::class)
class RestaurantRepoTest : BaseRepositoryTest() {

    @Mock
    lateinit var doorDashApiGateway: DoorDashApiGateway

    lateinit var restaurantRepo: RestaurantRepo

    @Before
    override fun steup() {
        super.steup()
        restaurantRepo = RestaurantRepo(doorDashApiGateway)
    }

    @Test
    fun getRestaurantsListShouldPass() = runBlocking {

        val store = Store(
           3.3,
            1,
           "null",
            "test",
            "header_img_url",
           "description",
            "0",
            2.3,
             1,
            true,
            4,
             100
        )

        whenever(restaurantRepo.getRestaurantsList(0,0,0f,0f)).thenReturn(
            ApiResponse(
                 10,
                 50,
                 true,
                 listOf(store)
            )
        )

        val response = restaurantRepo.getRestaurantsList(0,0,0f,0f)
        assert(response is ApiResponse)
        assert(response.stores is List<Store>)

    }
}