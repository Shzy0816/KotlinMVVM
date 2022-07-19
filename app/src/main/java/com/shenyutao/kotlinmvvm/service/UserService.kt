package com.shenyutao.kotlinmvvm.service

import com.shenyutao.kotlinmvvm.bean.User
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("/user/getUserById")
    suspend fun getUserById(@Query("userId") userId:String): User
}