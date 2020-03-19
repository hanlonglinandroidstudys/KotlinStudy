package com.dragonforest.app.kotlinstudy.child.hencoder2.entity

import java.util.*

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class Student {
    var name: String? = null
        get() {
            return "姓名:$field"
        }
        set(value) {
            field = value
        }

    var password: String? = null
        get() {
            return "密码:$field"
        }
        set(value) {
            field = value
        }

    var joinDate: Date = Date()
        get() {
            return field
        }
        set(value) {
            field = value
        }

}