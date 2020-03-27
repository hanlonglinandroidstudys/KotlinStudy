package com.dragonforest.app.kotlinstudy.child.okhttptest.api

import okhttp3.OkHttpClient

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
object ApiServer {
    fun makeOkhttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(DragonHttpLoggingInterceptor().getInterceptor())
            .build()
    }
}