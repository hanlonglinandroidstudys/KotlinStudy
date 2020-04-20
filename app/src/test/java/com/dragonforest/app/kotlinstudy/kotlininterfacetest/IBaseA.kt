package com.dragonforest.app.kotlinstudy.kotlininterfacetest

/**
 *
 * author: DragonForest
 * time: 2020/4/20
 */
interface IBaseA {

    var name: String

    fun bar()
    fun foo() {
        println("IBaseA foo name is $name")
    }
}
