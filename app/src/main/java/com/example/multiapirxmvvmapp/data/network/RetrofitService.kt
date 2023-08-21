package com.example.multiapirxmvvmapp.data.network

import com.example.multiapirxmvvmapp.data.network.model.ResponseAllUsers
import com.example.multiapirxmvvmapp.data.network.model.ResponseDetailsList
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/users?page=2")
    fun getAllUsersList(): Observable<ResponseAllUsers>

    @GET("api/unknown")
    fun getDetailsList(): Observable<ResponseDetailsList>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService{
            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
                retrofitService = retrofit.create()
            }
            return retrofitService!!
        }
    }
}