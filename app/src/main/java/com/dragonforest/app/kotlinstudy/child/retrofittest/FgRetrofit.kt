package com.dragonforest.app.kotlinstudy.child.retrofittest

import android.os.Bundle
import android.view.View
import com.dragonforest.app.kotlinstudy.R
import com.dragonforest.app.kotlinstudy.child.BaseFragment
import com.dragonforest.app.kotlinstudy.child.retrofit.model.CityDTO
import com.dragonforest.app.kotlinstudy.child.retrofit.model.CityGenerator
import com.dragonforest.app.kotlinstudy.child.retrofittest.api.WheatherApiFactory
import kotlinx.android.synthetic.main.fg_retrofit1.*
import kotlinx.coroutines.*

/**
 *
 * create by DragonForest at 2020/3/29
 */
class FgRetrofit(var mLink: String) : BaseFragment(mLink), View.OnClickListener {
    override fun getCustomLayout(): Int {
        return R.layout.fg_retrofit1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_get.setOnClickListener(this)

        tv_base_url.setText("http://t.weather.sojson.com/api/weather/city/{citycode}")
        var adapter = CityAdapter()
        adapter.cityList = CityGenerator.citys
        sp_city.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_get -> {
                doGet()
            }
        }
    }

    private fun doGet() {
        var city = sp_city.selectedItem as CityDTO
        CoroutineScope(newSingleThreadContext("")).launch(Dispatchers.Main) {
            var result = getWheather(city.code)
            tv_result.setText(result)
        }
    }

    private suspend fun getWheather(code: String): String {
        return withContext(Dispatchers.Default) {
            var result=WheatherApiFactory.getWheatherService().getWheather(code).execute()
            result.body().toString()
        }
    }

}