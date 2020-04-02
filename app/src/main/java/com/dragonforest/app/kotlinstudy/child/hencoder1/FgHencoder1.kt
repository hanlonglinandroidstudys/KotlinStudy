package com.dragonforest.app.kotlinstudy.child.hencoder1

import android.os.Bundle
import android.util.Log
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

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

        test()
    }

    // test
    fun test() {
        TestClass().callHandler("getUserInfo", arrayOf("token", 5050, "http://192.168.100.2:53379"))

        TestClass().callHandler(
            "setAppVersion",
            arrayOf("1.0.1-4138".split("-")[0])
        )

        Log.e("test", "date->" + Date().toISO8601String())
    }

    fun Date.toISO8601String(): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK)
        df.timeZone = tz
        return df.format(this)
    }
}