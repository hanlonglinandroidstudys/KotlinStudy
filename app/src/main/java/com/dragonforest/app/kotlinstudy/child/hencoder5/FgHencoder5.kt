package com.dragonforest.app.kotlinstudy.child.hencoder3

import android.os.Bundle
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import kotlinx.android.synthetic.main.fg_hencoder5.*
import kotlinx.coroutines.*

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class FgHencoder5(var mLink: String) : BaseFragment(mLink), View.OnClickListener {

    var start: Long = 0
    var end: Long = 1000 * 24 * 60 * 60 * 100

    override fun getCustomLayout(): Int {
        return R.layout.fg_hencoder5
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        tv_intro.text = "计算$start 到$end 的平均数 和 $start 到$end 平方的平均数，对比时间"
        btn_coroutine_start.setOnClickListener(this)
        btn_thread_start.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_coroutine_start -> {
                useCoroutine()
            }
            R.id.btn_thread_start -> {
                useThread()
            }
            else -> {

            }
        }
    }

    /**
     * 使用协程来写
     *
     * 用同步的方式写异步代码 爽
     *
     * 说明：
     *  getResult1() 和 getResult2() 在async{}代码块里，会同时执行，通过await 可以获取结果，这样比一步一步请求省去了一半时间
     */
    private fun useCoroutine() {
        CoroutineScope(newSingleThreadContext("")).launch(Dispatchers.Main) {
            var st = System.currentTimeMillis()
            var result1 = async { getResult1() }
            var result2 = async { getResult2() }
            tv_result.text = "使用协程计算结果 平均数=${result1.await()}，平方的平均数=${result2.await()}"
            var et = System.currentTimeMillis()
            tv_result.text = tv_result.text.toString() + ",总用时${et - st}ms"
            println("跳出withContext所在线程" + Thread.currentThread().name)
        }
    }

    suspend fun getResult1(): Long {
        return withContext(Dispatchers.Default) {
            calculate1()
        }
    }

    suspend fun getResult2(): Long {
        return withContext(Dispatchers.Default) {
            calculate2()
        }
    }

    private fun useThread() {
        var st = System.currentTimeMillis()
        var result1 = 0L
        var result2 = 0L
        var t = Thread() {
            result1 = calculate1()
            result2 = calculate2()
        }
        t.start()
        t.join()
        var et = System.currentTimeMillis()
        println("跳出Thread所在线程" + Thread.currentThread().name)
        tv_result.text = "使用线程计算结果 平均数=$result1，平方的平均数=$result2,总用时：${et - st}ms"
    }

    /**
     * 计算平均数
     */
    private fun calculate1(): Long {
        var st = System.currentTimeMillis()
        var sum = 0L
        var num = 0
        for (i in start..end) {
//            sum += i
            sum += Math.pow(i.toDouble(), 2.0).toLong()
            num += 1
        }
        var et = System.currentTimeMillis()
        println("计算所在线程" + Thread.currentThread().name)
        println("用时->${et - st}ms")
        return sum / num
    }

    /**
     * 计算平方的平均数
     */
    private fun calculate2(): Long {
        var st = System.currentTimeMillis()
        var sum = 0L
        var num = 0
        for (i in start..end) {
            sum += Math.pow(i.toDouble(), 2.0).toLong()
            num += 1
        }
        var et = System.currentTimeMillis()
        println("计算所在线程" + Thread.currentThread().name)
        println("用时->${et - st}ms")
        return sum / num
    }
}
