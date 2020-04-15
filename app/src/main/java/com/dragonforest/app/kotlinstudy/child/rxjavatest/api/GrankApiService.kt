package com.dragonforest.app.kotlinstudy.child.rxjavatest.api

import com.dragonforest.app.kotlinstudy.child.rxjavatest.model.GankBeautyResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * create by DragonForest at 2020/4/2
 */
interface GrankApiService {
    @GET("data/福利/{number}/{page}")
    fun getBeauties(@Path("number") number: Int, @Path("page") page: Int): Observable<GankBeautyResult>
}