package com.example.doordashlite.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("next_offset")
    val nextOffset: Int,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("show_list_as_pickup")
    val showListAsPickup: Boolean,
    @SerializedName("stores")
    val stores: List<Store>
)