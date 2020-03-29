package com.dragonforest.app.kotlinstudy.child.retrofittest.api

import com.dragonforest.app.kotlinstudy.child.okhttptest.api.ApiServer
import com.dragonforest.app.kotlinstudy.child.okhttptest.api.DragonHttpLoggingInterceptor
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * create by DragonForest at 2020/3/29
 */
object WheatherApiFactory {
    fun getWheatherService():WheatherService{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://t.weather.sojson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkhttpClient())
            .build()
        return retrofit.create(WheatherService::class.java)
    }

    private fun getOkhttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(DiyInterceptor())
            .addInterceptor(DragonHttpLoggingInterceptor().getInterceptor())
            .build()
    }
}