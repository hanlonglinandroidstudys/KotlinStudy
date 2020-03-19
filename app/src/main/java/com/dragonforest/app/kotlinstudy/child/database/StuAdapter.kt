package com.dragonforest.app.kotlinstudy.child.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.database.entity.StudentEntity

/**
 *
 * author: DragonForest
 * time: 2020/3/19
 */
class StuAdapter() : RecyclerView.Adapter<StuAdapter.ViewHolder>() {

    var mOnItemClickLister: OnItemClickListener? = null

    var stuList = mutableListOf<StudentEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
        get() {
            return field
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_stu, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return stuList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var vh: ViewHolder = holder as ViewHolder
        vh.tv_stu_name.text = stuList[position].name
        vh.tv_stu_password.text = stuList[position].password
        vh.v_content.setOnClickListener {
            mOnItemClickLister?.onItemClick(stuList[position])
        }
        vh.v_content.setOnLongClickListener {
            mOnItemClickLister?.onItemLongClick(stuList[position])
            true
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var v_content = view
        var iv_stu_head = view.findViewById<ImageView>(R.id.iv_stu_head)
        var tv_stu_name = view.findViewById<TextView>(R.id.tv_stu_name)
        var tv_stu_password = view.findViewById<TextView>(R.id.tv_stu_password)
    }

    interface OnItemClickListener {
        fun onItemClick(stu: StudentEntity)
        fun onItemLongClick(stu: StudentEntity)
    }
}