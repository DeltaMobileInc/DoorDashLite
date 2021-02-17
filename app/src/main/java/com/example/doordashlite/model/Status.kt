package com.example.doordashlite.model


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("asap_available")
    val asapAvailable: Boolean,
    @SerializedName("asap_minutes_range")
    val asapMinutesRange: List<Int>,
    @SerializedName("pickup_available")
    val pickupAvailable: Boolean,
    @SerializedName("scheduled_available")
    val scheduledAvailable: Boolean,
    @SerializedName("unavailable_reason")
    val unavailableReason: Any
)