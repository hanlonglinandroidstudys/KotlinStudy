package com.dragonforest.app.kotlinstudy.kotlininterfacetest

/**
 *
 * author: DragonForest
 * time: 2020/4/20
 */
class IBaseAImpl:IBaseA {
    override var name: String="尼玛"

    override fun bar() {
        println("IBaseAImpl bar()")
        foo()
    }
}