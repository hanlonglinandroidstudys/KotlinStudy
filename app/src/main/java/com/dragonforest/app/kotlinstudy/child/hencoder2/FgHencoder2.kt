package com.dragonforest.app.kotlinstudy.child.hencoder2

import android.os.Bundle
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import com.dragonforest.app.kotlinstudy.child.hencoder2.entity.Student
import com.dragonforest.app.kotlinstudy.child.hencoder2.singleton.DateUtil
import kotlinx.android.synthetic.main.fg_hencoder2.*
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class FgHencoder2(var mLink: String) : BaseFragment(mLink), View.OnClickListener {

    override fun getCustomLayout(): Int {
        return R.layout.fg_hencoder2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(v: View?) {

        var st = getStu()

        tv_name.text = st.name
        tv_password.text = st.password
        tv_join_date.text = DateUtil.date2Str(st.joinDate)

        btn_date_from.setOnClickListener(this)
        btn_date_to.setOnClickListener(this)
    }

    private fun getStu(): Student {
        var st = Student()
        st.name = "韩龙林"
        st.password = "132456"
        st.joinDate = Date()
        return st
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_date_to -> {
                var st = getStu()
                tv_join_date.text =
                    DateUtil.date2Str(st.joinDate, SimpleDateFormat("yyyy/MM/dd hh:mm:ss"))
            }
            R.id.btn_date_from -> {
                var st = getStu()
                tv_join_date.text = DateUtil.date2Str(st.joinDate)
            }
        }
    }
}
