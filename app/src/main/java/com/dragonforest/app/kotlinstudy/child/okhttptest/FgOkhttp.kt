package com.dragonforest.app.kotlinstudy.child.okhttptest

import android.os.Bundle
import android.util.Log
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import com.dragonforest.app.kotlinstudy.child.okhttptest.api.ApiServer
import com.dragonforest.app.kotlinstudy.child.okhttptest.model.CityDTO
import com.dragonforest.app.kotlinstudy.child.okhttptest.model.CityGenerator
import kotlinx.android.synthetic.main.fg_okhttp1.*
import kotlinx.coroutines.*
import okhttp3.*

/**
 *
 * author: DragonForest
 * time: 2020/3/27
 */
class FgOkhttp(var mLink: String) : BaseFragment(mLink), View.OnClickListener {

    override fun getCustomLayout(): Int {
        return R.layout.fg_okhttp1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_get.setOnClickListener(this)
        btn_post.setOnClickListener(this)

        ed_url_get.setText("http://t.weather.sojson.com/api/weather/city")
        ed_url_post.setText("http://www.wanandroid.com/lg/todo/add/json")
        var adapter = CityAdapter()
        adapter.cityList = CityGenerator.citys
        sp_city.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_get -> {
                doGet()
            }
            R.id.btn_post -> {
                doPost()
            }
        }
    }

    private fun doGet() {
        CoroutineScope(newSingleThreadContext("")).launch(Dispatchers.Main) {
            tv_result.setText("请求中...")
            var responseStr = getResult(getGetUrl())
            tv_result.setText(responseStr)
        }
    }

    private fun doPost() {
        CoroutineScope(newSingleThreadContext("")).launch(Dispatchers.Main) {
            tv_result.setText("请求中...")
            var loginStr = login()
            var responseStr = postResult(getPostUrl())
            tv_result.setText(responseStr)
        }
    }

    private fun getGetUrl(): String {
        var city = sp_city.selectedItem as CityDTO
        var baseUrl = ed_url_get.text.toString()
        if (sp_city.count == 0 || baseUrl.isEmpty()) {
            throw Exception("url不能为空!参数不能为空！")
        }
        return baseUrl + "/" + city.code
    }

    private fun getPostUrl(): String {
        var baseUrl = ed_url_post.text.toString()
        if (baseUrl.isEmpty()) {
            throw Exception("url不能为空!参数不能为空！")
        }
        return baseUrl
    }

    /**
     * 使用协程进行网络请求 get
     * 网络请求的操作在withContext指定的线程中
     * 在执行完之后会自动切换到withContext之外的线程中
     */
    private suspend fun getResult(url: String): String? {
        log("url->$url")
        return withContext(Dispatchers.Default) {
            var client: OkHttpClient = ApiServer.makeOkhttpClient()
            var request: Request = Request.Builder()
                .url(url)
                .get()
                .build()
            client.newCall(request).execute().body?.string()
        }
    }

    private suspend fun login(): String {
        return withContext(Dispatchers.Default) {
            var formBody = FormBody.Builder()
                .add("username", "hanlonglin")
                .add("password", "longlin1234")
                .build()
            var client: OkHttpClient = ApiServer.makeOkhttpClient()
            var request: Request = Request.Builder()
                .url("https://www.wanandroid.com/user/login")
                .post(formBody)
                .build()
            client.newCall(request).execute().body!!.string()
        }
    }

    private suspend fun postResult(url: String): String? {
        log("url->$url")
        return withContext(Dispatchers.Default) {
            var formBody = FormBody.Builder()
                .add("title", "标题1")
                .add("content", "内容2")
                .add("date", "2020-03-28")
                .add("type", "0")
                .build()
            var client: OkHttpClient = ApiServer.makeOkhttpClient()
            var request: Request = Request.Builder()
                .url(url)
                .post(formBody)
                .build()
            client.newCall(request).execute().body?.string()
        }
    }

    private fun log(msg: String) {
        Log.e(this.javaClass.simpleName, msg)
    }
}