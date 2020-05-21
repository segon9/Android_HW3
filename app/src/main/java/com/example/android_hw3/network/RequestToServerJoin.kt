package com.example.android_hw3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RequestToServerJoin  {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestInterfaceJoin = retrofit.create(RequestInterfaceJoin::class.java)
}