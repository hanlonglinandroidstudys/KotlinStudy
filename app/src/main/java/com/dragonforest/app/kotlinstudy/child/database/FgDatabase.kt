package com.dragonforest.app.kotlinstudy.child.database

import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class FgDatabase(val mlink: String) : BaseFragment(mlink) {
    override fun getCustomLayout(): Int {
        return R.layout.fg_database
    }
}