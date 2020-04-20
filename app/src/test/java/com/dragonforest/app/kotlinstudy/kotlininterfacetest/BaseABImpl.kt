package com.dragonforest.app.kotlinstudy.kotlininterfacetest

/**
 *
 * author: DragonForest
 * time: 2020/4/20
 */
class BaseABImpl:IBaseA,IBaseB {
    override fun aar() {
        println("BaseAB aar()")
    }

    override var name: String="IbaseAB"

    override fun bar() {
        println("BaseAB bar()")
    }

    override fun foo() {
        super<IBaseA>.foo()
        super<IBaseB>.foo()
        println("BaseAB foo()")
    }
}