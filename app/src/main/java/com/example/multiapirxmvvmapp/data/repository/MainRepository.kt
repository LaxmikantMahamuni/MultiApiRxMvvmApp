package com.example.multiapirxmvvmapp.data.repository

import com.example.multiapirxmvvmapp.data.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsersList() = retrofitService.getAllUsersList()
    fun getDetailsList() = retrofitService.getDetailsList()
}