package com.shenyutao.kotlinmvvm.repository

import com.shenyutao.kotlinmvvm.bean.User
import com.shenyutao.kotlinmvvm.util.RetrofitUtils

class UserRepository {
    suspend fun getUserById(userId :String) : User? {
        return RetrofitUtils.mInstance?.mUserService?.getUserById(String())
    }
}