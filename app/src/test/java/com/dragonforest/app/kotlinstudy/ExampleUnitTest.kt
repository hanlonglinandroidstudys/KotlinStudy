package com.dragonforest.app.kotlinstudy

import com.dragonforest.app.kotlinstudy.kotlinclasstest.BaseAnimal
import com.dragonforest.app.kotlinstudy.kotlinclasstest.Bird
import com.dragonforest.app.kotlinstudy.kotlinextends.BaseUtil
import com.dragonforest.app.kotlinstudy.kotlininterfacetest.BaseABImpl
import com.dragonforest.app.kotlinstudy.kotlininterfacetest.IBaseAImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testClass() {
//        var base=BaseAnimal()
//        var base2=BaseAnimal("haha")
        var bird = Bird("小苗小鸟", "gg")
//        base.run()
        bird.run()
    }

    @Test
    fun testInterface() {
        var baseA = BaseABImpl()
        baseA.foo()
    }

    fun BaseUtil.sayGood() {
        println("I am extended to say good")
    }
    var BaseUtil.extendsName: String
        get() = "sart"
        set(value) {}

    @Test
    fun testExtends() {
        var baseUtil = BaseUtil()
        baseUtil.sayGood()
        baseUtil.extendsName.also(::println)
    }
}
