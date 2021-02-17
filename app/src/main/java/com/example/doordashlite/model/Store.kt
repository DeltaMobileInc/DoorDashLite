package com.example.doordashlite.model


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("average_rating")
    val averageRating: Double,
    @SerializedName("business_id")
    val businessId: Int,
    @SerializedName("cover_img_url")
    val coverImgUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("header_img_url")
    val headerImgUrl: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("display_delivery_fee")
    val displayDeliveryFee: String,
    @SerializedName("distance_from_consumer")
    val distanceFromConsumer: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_newly_added")
    val isNewlyAdded: Boolean,
    @SerializedName("num_ratings")
    val numRatings: Int,
    @SerializedName("price_range")
    val priceRange: Int
 /*   @SerializedName("status")
    val status: Status*/
)