package com.dragonforest.app.kotlinstudy.child.database

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import com.dragonforest.app.kotlinstudy.child.database.entity.StudentEntity
import com.dragonforest.app.kotlinstudy.child.database.util.DBHelper
import kotlinx.android.synthetic.main.fg_database.*

/**
 *
 * author: DragonForest
 * time: 2020/3/18
 */
class FgDatabase(val mlink: String) : BaseFragment(mlink), View.OnClickListener,
    StuAdapter.OnItemClickListener {
    var stuAdapter = StuAdapter()

    override fun getCustomLayout(): Int {
        return R.layout.fg_database
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        updateData()
    }

    private fun initView() {
        stuAdapter.stuList = mutableListOf()
        rv_stu.adapter = stuAdapter
        rv_stu.layoutManager = LinearLayoutManager(activity)
        btn_add_stu.setOnClickListener(this)
        stuAdapter.mOnItemClickLister = this
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add_stu -> {
                var name = ed_name.text.toString()
                var passwd = ed_password.text.toString()
                if (TextUtils.isEmpty(name)
                    || TextUtils.isEmpty(passwd)
                ) {
                    return
                }
                var stu = StudentEntity()
                stu.name = name
                stu.password = passwd
                DBHelper.save(stu)
                updateData()
            }
        }
    }

    override fun onItemClick(stu: StudentEntity) {
        Toast.makeText(activity, "不要随便点击我", Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClick(stu: StudentEntity) {
        showDeleteDialog(stu)
    }

    private fun showDeleteDialog(stu: StudentEntity) {
        AlertDialog.Builder(activity)
            .setMessage("确定删除${stu.name}吗？")
            .setNegativeButton("取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }
            })
            .setPositiveButton("确定", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    DBHelper.delete(stu.id, stu)
                    updateData()
                }
            })
            .show()
    }

    private fun updateData() {
        var stuList = DBHelper.get<StudentEntity>()
        stuAdapter.stuList = stuList
    }
}