package com.dragonforest.app.kotlinstudy.bean

/**
 *
 * create by DragonForest at 2020/3/15
 */
class Student constructor(var name: String, var age: Int) {
    var hobby = ""
    constructor(mName: String, mAge: Int, hobby: String) : this(mName, mAge) {
        println("Student调用次级构造函数")
        this.hobby = hobby
    }

    fun sayHello(msg: String = "你好啊") {
        println("$msg,$name,$age 岁,爱好$hobby")
    }

    override fun toString(): String {
        return """
            |name=$name
            |age=$age
            |hobby=$hobby
        """.trimMargin()
    }

}