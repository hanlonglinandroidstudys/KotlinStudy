package com.dragonforest.app.kotlinstudy.child.database.util

import android.content.Context
import com.dragonforest.app.kotlinstudy.child.database.entity.StudentEntity
import org.litepal.LitePal
import org.litepal.crud.LitePalSupport
import org.litepal.extension.findAll

/**
 *
 * create by DragonForest at 2020/3/16
 */
object DBHelper {

    fun init(context: Context) {
        LitePal.initialize(context)
        LitePal.getDatabase()

        save(StudentEntity())
        save(StudentEntity())
        save(StudentEntity())
    }

    inline fun <reified T> save(t: T) {
        if (t is LitePalSupport) {
            t.save()
        }
    }

    inline fun <reified T> get():List<T>{
        return LitePal.findAll<T>()
    }

}