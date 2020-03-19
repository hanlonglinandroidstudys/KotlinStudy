package com.dragonforest.app.kotlinstudy

import android.app.Application
import org.litepal.LitePal

/**
 *
 * create by DragonForest at 2020/3/17
 */
class APP : Application() {
    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
    }
}