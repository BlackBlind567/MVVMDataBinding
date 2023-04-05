package com.mvvm.myapplicationmvvm.model

data class Category(
    val data: List<CategoryData>,
    val message: String,
    val status: Int,
    val success: Boolean
)