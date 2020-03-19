package com.dragonforest.app.kotlinstudy.child.database.entity

import org.litepal.crud.LitePalSupport

/**
 *
 * create by DragonForest at 2020/3/16
 */
class StudentEntity: LitePalSupport() {
    var id: Long = 0
    var name: String = ""
    var sex: String = ""
}