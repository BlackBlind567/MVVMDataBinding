package com.mvvm.myapplicationmvvm.mvvmBinding

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mvvm.myapplicationmvvm.model.CategoryData

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    var categoryRepository = CategoryRepository(application)

    fun loadData(context: Context): MutableLiveData<ArrayList<CategoryData>>{
        return categoryRepository.callProductDetailApi(context)
    }

}