package com.dragonforest.app.kotlinstudy.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.dragonforest.app.kotlinstudy.R

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
abstract class BaseFragment(var link: String) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: ViewGroup =
            LayoutInflater.from(container?.context).inflate(
                R.layout.fg_base,
                container,
                false
            ) as ViewGroup
        setLink(v)
        addCustomView(inflater, v)
        return v
    }

    private fun setLink(v: ViewGroup) {
        v.findViewById<TextView>(R.id.tv_link).setText(link)
    }

    private fun addCustomView(inflater: LayoutInflater, v: ViewGroup) {
        var content = v.findViewById<ConstraintLayout>(R.id.cl_content)
        content.removeAllViews()
        var lp: ViewGroup.LayoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        var customView =
            inflater.inflate(getCustomLayout(), content, false)
        content.addView(customView, lp)
    }

    abstract fun getCustomLayout():Int
}