package com.dragonforest.app.kotlinstudy.child.okhttptest.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.RealInterceptorChain

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
class MyOwnInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var realChain = chain as RealInterceptorChain

        realChain.request().url

        return realChain.proceed(realChain.request())
    }
}