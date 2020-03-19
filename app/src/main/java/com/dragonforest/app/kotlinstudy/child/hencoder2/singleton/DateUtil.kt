package com.dragonforest.app.kotlinstudy.child.hencoder2.singleton

import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
object DateUtil {
    var sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        set(value) {
            field = value
        }
        get() {
            return field
        }

    fun date2Str(date: Date, sdf1: SimpleDateFormat = this.sdf): String {
        return sdf1.format(date)
    }

    fun str2Date(dateStr: String, sdf1: SimpleDateFormat = this.sdf): Date {
        return sdf1.parse(dateStr)
    }
}