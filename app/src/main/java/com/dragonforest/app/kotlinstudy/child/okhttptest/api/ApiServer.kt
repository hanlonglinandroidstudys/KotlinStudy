package com.dragonforest.app.kotlinstudy.child.okhttptest.api

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
object ApiServer {
    var cookieStore: MutableMap<String, List<Cookie>> = mutableMapOf()


    fun makeOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(DragonHttpLoggingInterceptor().getInterceptor())
            .cookieJar(object : CookieJar {
                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                    cookieStore.put(url.host, cookies)
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    return cookieStore.get(url.host) ?: emptyList()
                }
            })
            .build()
    }
}