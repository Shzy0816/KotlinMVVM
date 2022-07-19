package com.shenyutao.kotlinmvvm.util

import com.google.gson.GsonBuilder
import com.shenyutao.kotlinmvvm.service.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtils {
    private var mRetrofit: Retrofit? = null
    var mUserService: UserService? = null


    companion object {
        const val BASE_URL = "http://10.0.2.2:8080"

        // 懒汉双重锁
        var mInstance: RetrofitUtils? = null
            get() {
                if (field == null) {
                    synchronized(RetrofitUtils::class.java) {
                        if (field == null) {
                            field = RetrofitUtils()
                            field!!.init()
                        }
                    }
                }
                return field
            }
    }

    private fun init() {
        if (mRetrofit == null) {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(30000, TimeUnit.MILLISECONDS)
                .build()

            val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()

            mRetrofit = Retrofit.Builder()
                //添加标准数据格式转换器，防止String字符串被直接转化为json格式
                .addConverterFactory(ScalarsConverterFactory.create())
                //添加Gson数据格式转换器支持
                .addConverterFactory(GsonConverterFactory.create(gson))
                /*
                添加rxjava支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                */
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

            mUserService = mRetrofit!!.create(UserService::class.java)
        }
    }

}