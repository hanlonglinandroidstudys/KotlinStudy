package com.dragonforest.app.kotlinstudy.kotlinclasstest

/**
 *
 * author: DragonForest
 * time: 2020/4/20
 */
open class BaseAnimal {
    open var name: String = ""
    private var privateProperty = "Private BaseAnimal"
    protected var protectedProperty = "protected BaseAnimal"
    public var publicProperty = "public BaseAnimal"

    var firstP = "I am hanlonglin".also(::println)

    constructor() {
        println("this is base constructor")
    }

    constructor(p:String) {
        println("this is base 2 constructor $p")
    }

    init {
        println("this is first init block in base")
    }

    var second = "My father is good".also(::println)

    init {
        println("this is second init block in base")
    }

    open fun run() {
        println("base animal is running!")
    }
}