package com.dragonforest.app.kotlinstudy.child.retrofittest

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.dragonforest.app.kotlinstudy.child.retrofit.model.CityDTO

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
class CityAdapter: BaseAdapter() {
    var cityList:MutableList<CityDTO> = mutableListOf()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var tv=TextView(parent?.context)
        tv.layoutParams=ViewGroup.LayoutParams(-1,-2)
        tv.setText(cityList[position].name)
        return tv
    }

    override fun getItem(position: Int): Any {
        return cityList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cityList.size
    }
}