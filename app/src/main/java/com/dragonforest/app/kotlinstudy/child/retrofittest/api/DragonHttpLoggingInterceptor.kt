package com.dragonforest.app.kotlinstudy.child.retrofittest.api

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
class DragonHttpLoggingInterceptor {

     companion object fun getInterceptor(): HttpLoggingInterceptor {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    inner class DragonLogger : HttpLoggingInterceptor.Logger {

        override fun log(message: String) {
            sslog(message)
        }

        private fun sslog(msg: String) {
            Log.e(this.javaClass.simpleName, msg)
        }
    }
}