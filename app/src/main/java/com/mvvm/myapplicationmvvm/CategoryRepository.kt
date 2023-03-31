package com.mvvm.myapplicationmvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.google.gson.GsonBuilder
import java.lang.Exception


class CategoryRepository(application: Application) {
    //constructor to initialize data
    private var categoryDataArray: MutableLiveData<ArrayList<CategoryData>> =  MutableLiveData()
    private var categoryDataList: ArrayList<CategoryData> = ArrayList()

    //call api function
    fun callProductDetailApi(context: Context): MutableLiveData<ArrayList<CategoryData>>{
        val blackBlind = BlackBlind(context)
        blackBlind.requestUrl("https://application.purityhub.co.in/api/get/masters/api/category")
        blackBlind.headersRequired(false)
        blackBlind.executeRequest(Request.Method.POST, object: VolleyCallback{
            override fun getResponse(response: String?) {
               try {
                   val gsonBuilder = GsonBuilder()
                   gsonBuilder.setDateFormat("M/d/yy hh:mm a")
                   val gson = gsonBuilder.create()
                   val brandCategory = gson.fromJson(
                       response,
                       Category::class.java
                   )

                   if (brandCategory.success && brandCategory.status == 1) {
                       categoryDataList = brandCategory.data as ArrayList<CategoryData>
                        categoryDataArray.value = categoryDataList
                   }
               }catch (e: Exception){
                   println("e = " + e.message)
               }
            }

            override fun getError(error: String?) {

            }
        })
        return categoryDataArray
    }



}