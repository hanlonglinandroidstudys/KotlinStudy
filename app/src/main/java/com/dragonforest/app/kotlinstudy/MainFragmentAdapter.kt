package com.dragonforest.app.kotlinstudy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class MainFragmentAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    var fragments: MutableList<Fragment> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
        get() {
            return field
        }

    var titles: MutableList<String> = arrayListOf()
        set(value) {
            field = value
        }
        get() {
            return field
        }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}