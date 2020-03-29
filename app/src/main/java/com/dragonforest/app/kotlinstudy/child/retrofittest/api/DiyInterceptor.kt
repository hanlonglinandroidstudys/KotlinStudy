package com.dragonforest.app.kotlinstudy.child.retrofittest.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.RealInterceptorChain

/**
 *
 * create by DragonForest at 2020/3/29
 */
class DiyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var realChain = chain as RealInterceptorChain
        var requestBuilder=realChain.request().newBuilder()
        requestBuilder.header("king","DragonForest")
        return realChain.proceed(requestBuilder.build())
    }
}