package com.example.multiapirxmvvmapp.data.network.model

import com.google.gson.annotations.SerializedName

data class Details (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("year") val year: Int,
    @SerializedName("color") val color: String,
    @SerializedName("pantone_value") val pantoneValue: String,
)
