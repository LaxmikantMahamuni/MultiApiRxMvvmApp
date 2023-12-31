package com.example.multiapirxmvvmapp.data.network.model

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("avatar") val avatarImage: String,
)
