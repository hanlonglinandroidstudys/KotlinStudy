package com.dragonforest.app.kotlinstudy.child.ktfunction

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import kotlinx.android.synthetic.main.fg_function.*
import java.util.*

/**
 *
 * author: DragonForest
 * time: 2020/4/15
 */
class FgFunction(mLink: String) : BaseFragment(mLink) {
    override fun getCustomLayout(): Int {
        return R.layout.fg_function
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_high_func1.setOnClickListener {
            deal("韩龙林",::getWelcomeStr1)
        }
        btn_high_func2.setOnClickListener {
            deal("韩龙林",::getWelcomeStr2)
        }
        btn_high_func3.setOnClickListener {
            deal("韩龙林",::getWelcomeStr3)
        }
    }

    fun deal(name:String,show:(String)->String){
        var msg = show(name)
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    fun getWelcomeStr1(name:String):String{
        return "你好$name,现在的时间是${Date().toString()}"
    }

    fun getWelcomeStr2(name:String):String{
        return "$name,你听好了,现在的时间是${Date().toString()}"
    }

    fun getWelcomeStr3(name:String):String{
        return "珍惜今天吧，$name,现在的时间是${Date().toString()}"
    }
}