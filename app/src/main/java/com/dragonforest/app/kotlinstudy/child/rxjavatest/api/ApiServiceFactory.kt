package com.dragonforest.app.kotlinstudy.child.rxjavatest.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * create by DragonForest at 2020/4/2
 */
class ApiServiceFactory {
    companion object {
        fun getGrankApiService(): GrankApiService {
            var retrofit = Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(GrankApiService::class.java)
        }
    }

}