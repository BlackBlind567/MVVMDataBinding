package com.mvvm.myapplicationmvvm

import androidx.lifecycle.MutableLiveData

data class Category(
    val CategoryData: List<CategoryData>,
    val message: String,
    val status: Int,
    val success: Boolean
)