package com.example.doordashlite.model


import com.google.gson.annotations.SerializedName

data class PopularItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_url")
    val imgUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)