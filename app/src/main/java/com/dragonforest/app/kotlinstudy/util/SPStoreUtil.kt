package com.dragonforest.app.kotlinstudy.util

import android.content.Context

/**
 *
 * author: DragonForest
 * time: 2020/3/30
 */
object SPStoreUtil {
    val SAVE_FILE = "kotlinStudy"

    fun saveString(context: Context, key: String, value: String) {
        val sp = context.getSharedPreferences(SAVE_FILE, Context.MODE_PRIVATE)
        var edit = sp.edit()
        edit.putString(key, value)
        edit.commit()
    }

    fun getString(context: Context, key: String, default: String = ""):String {
        val sp = context.getSharedPreferences(SAVE_FILE, Context.MODE_PRIVATE)
        return sp.getString(key, default)
    }
}