package com.mvvm.myapplicationmvvm.mvvmBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.myapplicationmvvm.model.CategoryData
import com.mvvm.myapplicationmvvm.R
import com.mvvm.myapplicationmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var arrayList: ArrayList<CategoryData>
    lateinit var categoryViewModel: CategoryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        arrayList = arrayListOf()
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        binding.rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        categoryViewModel.loadData(this@MainActivity).observe(this
        ) {
            println("getData1 == $it")
            if (it != null){
                println("getData == $it")
                arrayList = it
//                adapter.addItems(arrayList)
                adapter = CategoryAdapter(
                    this@MainActivity,
                    arrayList
                )
                binding.rvCategory.adapter = adapter
            }

        }


//        val blackBlind = BlackBlind(this@MainActivity)
//        blackBlind.headersRequired(false)
//
//        blackBlind.requestUrl("https://application.purityhub.co.in/api/get/masters/api/category")
//        blackBlind.executeRequest(Request.Method.POST, object : VolleyCallback {
//            override fun getResponse(response: String?) {
//                val gsonBuilder = GsonBuilder()
//                gsonBuilder.setDateFormat("M/d/yy hh:mm a")
//                val gson = gsonBuilder.create()
//                val brandCategory = gson.fromJson(
//                    response,
//                    Category::class.java
//                )
////                responseMsg = brandCategory.message
//                if (brandCategory.success && brandCategory.status == 1) {
////                    Toast.makeText(requireContext(), brandCategory.message, Toast.LENGTH_SHORT)
////                        .show()
//
////                    for (i in 0 until brandCategory.data.size) {
////
////                    }
//
//
//                    arrayList = brandCategory. as ArrayList<CategoryData>
////                    categoryArray.add(0, BrandCategoryData(-1, "", "All", -1))
//                    val brandCategoryAdapter =
//                        CategoryAdapter(
//                            requireContext(), categoryArray, updateListener,
//                            "categoryShortName"
//                        )
//                    binding.categoryRv.adapter = brandCategoryAdapter
//                    stopLoading()
//
//                } else {
//                    stopLoading()
//                    Toast.makeText(requireContext(), responseMsg, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun getError(error: String?) {
//                Toast.makeText(requireContext(), responseMsg, Toast.LENGTH_SHORT).show()
//            }
//        })

    }
}