package com.example.multiapirxmvvmapp.data.network.model

import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("ulr") val url: String,
    @SerializedName("text") val text: String
)
