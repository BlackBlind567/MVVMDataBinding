package com.mvvm.myapplicationmvvm.model

data class CategoryData(
    val id: Int,
    val image: String,
    val name: String,
    val status: Int

) {
    override fun toString(): String {
        return "CategoryData(id=$id, image='$image', name='$name', status=$status)"
    }
}