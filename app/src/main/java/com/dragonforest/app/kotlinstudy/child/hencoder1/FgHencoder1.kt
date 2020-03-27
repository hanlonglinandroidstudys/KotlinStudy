package com.dragonforest.app.kotlinstudy.child.hencoder1

import android.os.Bundle
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class FgHencoder1(var mLink: String) : BaseFragment(mLink) {

    override fun getCustomLayout(): Int {
        return R.layout.fg_hencoder1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var a: Int = 1000
        println("比较1->${a === a}")
        var boxA: Int = a
        var otherBoxA: Int = a
        println("比较2->${otherBoxA == boxA}")
        println("比较3->${otherBoxA === boxA}")
    }
}