package com.mvvm.myapplicationmvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.google.gson.GsonBuilder


class CategoryRepository(application: Application) {
    //constructor to initialize data
    private var categoryDataArray: MutableLiveData<ArrayList<CategoryData>> =  MutableLiveData()
    private var categoryDataList: ArrayList<CategoryData> = ArrayList()

    //call api function
    fun callProductDetailApi(context: Context): MutableLiveData<ArrayList<CategoryData>>{
        val blackBlind = BlackBlind(context)
        blackBlind.requestUrl("")
        blackBlind.headersRequired(false)
        blackBlind.executeRequest(Request.Method.POST, object: VolleyCallback{
            override fun getResponse(response: String?) {
                val gsonBuilder = GsonBuilder()
                gsonBuilder.setDateFormat("M/d/yy hh:mm a")
                val gson = gsonBuilder.create()
                val brandCategory = gson.fromJson(
                    response,
                    Category::class.java
                )

                if (brandCategory.success && brandCategory.status == 1) {
                    categoryDataArray = brandCategory.CategoryData

                }
            }

            override fun getError(error: String?) {

            }
        })
        return categoryDataArray
    }



}