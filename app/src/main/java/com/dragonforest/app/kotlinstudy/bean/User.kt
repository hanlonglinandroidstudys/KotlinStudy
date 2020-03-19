package com.dragonforest.app.kotlinstudy.bean

/**
 *
 * create by DragonForest at 2020/3/14
 */
class User {
    constructor(){
        print("主构造函数")
    }
    val school = "黄骅中学"
        get() {
            return "河北" + field
        }

    var name: String = "韩龙林"
        get() = field + "很帅"
        set(value) {
            field = value + "很牛逼"
        }

    var start = null
    var hobby = "打篮球"
        get() {
            return field + "是第一"
        }
        set(value) {
            field = value + "特别准"
        }
}