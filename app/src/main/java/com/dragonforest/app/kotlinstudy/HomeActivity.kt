package com.dragonforest.app.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dragonforest.app.kotlinstudy.child.constraintLayout.FgConstraintLayout
import com.dragonforest.app.kotlinstudy.child.hencoder1.FgHencoder1
import com.dragonforest.app.kotlinstudy.child.hencoder2.FgHencoder2
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
    }

    private fun initView() {
        var mainFragmentAdapter = MainFragmentAdapter(supportFragmentManager, 0)
        var fgs: MutableList<Fragment> = arrayListOf()
        var titles: MutableList<String> = arrayListOf()
        getFragmentsAndTitles(fgs, titles)
        mainFragmentAdapter.fragments = fgs
        mainFragmentAdapter.titles = titles
        vp_main.adapter = mainFragmentAdapter
        tl_main.setupWithViewPager(vp_main)
    }

    private fun getFragmentsAndTitles(fgs: MutableList<Fragment>, titles: MutableList<String>) {
        fgs.add(FgHencoder1("https://kaixue.io/kotlin-basic-1/"))
        titles.add("kotin的变量，函数和类型")
        fgs.add(FgHencoder2("https://kaixue.io/kotlin-basic-2/"))
        titles.add("kotlin那些不是那么写的")
        fgs.add(FgHencoder1("https://kaixue.io/kotlin-basic-3/"))
        titles.add("kotlin那些更方便的")
        fgs.add(FgConstraintLayout("https://juejin.im/post/5ce3b68b518825336e0a5190"))
        titles.add("ConstraintLayout(即刻团队)")
    }
}