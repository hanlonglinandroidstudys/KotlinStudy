package com.dragonforest.app.kotlinstudy.child.retrofit.model


/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
object CityGenerator {
    var citys: MutableList<CityDTO> = mutableListOf()

    init {
        citys.add(CityDTO("天津", "101030100"))
        citys.add(CityDTO("黄骅", "101090713"))
        citys.add(CityDTO("石家庄", "101090101"))
        citys.add(CityDTO("青岛", "101120201"))
        citys.add(CityDTO("呼和浩特", "101080101"))
    }

}