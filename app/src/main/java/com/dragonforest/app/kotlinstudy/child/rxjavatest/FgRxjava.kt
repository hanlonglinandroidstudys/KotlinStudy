package com.dragonforest.app.kotlinstudy.child.rxjavatest

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import com.dragonforest.app.kotlinstudy.child.rxjavatest.adapter.ItemListAdapter
import com.dragonforest.app.kotlinstudy.child.rxjavatest.api.ApiServiceFactory
import com.dragonforest.app.kotlinstudy.child.rxjavatest.model.GankBeautyResult
import com.dragonforest.app.kotlinstudy.child.rxjavatest.model.Item
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fg_rxjava.*

/**
 *
 * create by DragonForest at 2020/4/2
 */
class FgRxjava(var mLink: String) : BaseFragment(mLink) {

    lateinit var adapter: ItemListAdapter

    var pageIndex: Int = 0
    var pageSize = 20

    override fun getCustomLayout(): Int {
        return R.layout.fg_rxjava
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_last.setOnClickListener { lastPage() }
        btn_next.setOnClickListener { nextPage() }

        sfl.isEnabled = false
        sfl.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE)
        adapter = ItemListAdapter()
        adapter.setItems(null)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = adapter

        loadPage(pageIndex)
    }

    private fun lastPage() {
        loadPage(--pageIndex)
    }

    private fun nextPage() {
        loadPage(++pageIndex)
    }


    private fun loadPage(page: Int) {
        if (page == 0) {
            btn_last.isEnabled = false
        }
        if (page == 1) {
            btn_last.isEnabled = true
        }
        tv_pageIndex.text = "第$pageIndex 页"

        sfl.isRefreshing = true
        ApiServiceFactory.getGrankApiService()
            .getBeauties(pageSize, page)
            .map(Function<GankBeautyResult, List<Item>>() {
                it.beauties.map {
                    var item = Item()
                    item.imageUrl = it.url
                    item.description = it.createdAt
                    item
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer {
                    sfl.isRefreshing = false
                    adapter.setItems(it)
                },
                Consumer {
                    sfl.isRefreshing = false
                    Toast.makeText(activity, "加载失败", Toast.LENGTH_SHORT).show()
                })

    }
}