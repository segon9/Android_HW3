package com.example.android_hw3.network

import com.example.android_hw3.data.RequestJoin
import com.example.android_hw3.data.ResponseJoin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterfaceJoin {
    @POST("/user/signup")
    fun requestJoin(@Body body : RequestJoin) : Call<ResponseJoin>
}