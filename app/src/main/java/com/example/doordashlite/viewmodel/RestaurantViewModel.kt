package com.example.doordashlite.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.doordashlite.DoorDashLiteApplication
import com.example.doordashlite.model.ApiResponse
import com.example.doordashlite.model.Store
import com.example.doordashlite.respository.RestaurantRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantViewModel(application: Application): AndroidViewModel(application) {

    private val _restLiveData = MutableLiveData<MutableList<Store>>()
    val restLiveData: LiveData<MutableList<Store>> = _restLiveData
    //Used to persist list position during config changes
    var firstVisibleItem: Int? = null

    @Inject
    lateinit var restaurantRepo: RestaurantRepo

    init {
        (application as DoorDashLiteApplication).appComponent.inject(this)
    }

    fun getRestaurantsList(offset: Int){
        //git test
        viewModelScope.launch {
            restaurantRepo.getRestaurantsList(offset)?.let {
                _restLiveData.postValue(
                    restLiveData.value?.apply {
                        addAll(it.stores)
                    } ?: run {
                        it.stores.toMutableList()
                    }
                )
            }
        }
    }
}