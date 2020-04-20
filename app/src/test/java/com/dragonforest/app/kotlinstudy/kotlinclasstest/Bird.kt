package com.dragonforest.app.kotlinstudy.kotlinclasstest

/**
 *
 * author: DragonForest
 * time: 2020/4/20
 */
class Bird(var mname:String): BaseAnimal() {

    constructor(mname:String,aa:String):this (mname){
        println("this is bird second constructor,mName is $mname")
    }

    init {
        println("this is bird init block,name is $mname")
    }

    override var name="百灵鸟"
    override fun run(){
        println("bird names $name is running!")
    }
}