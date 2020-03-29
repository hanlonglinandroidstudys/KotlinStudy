package com.dragonforest.app.kotlinstudy.child.retrofittest.api

import com.dragonforest.app.kotlinstudy.child.retrofittest.entity.WheatherResponseEntity
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * create by DragonForest at 2020/3/29
 */
interface WheatherService {
    @GET("api/weather/city/{citycode}")
    fun getWheather(@Path("citycode") cityCode:String):Call<WheatherResponseEntity>
}