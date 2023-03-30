package com.mvvm.myapplicationmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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


//        categoryViewModel.loadData(this@MainActivity).observe(this
//        ) {
//            println("getData1 == $it")
//            if (it != null){
//                println("getData == $it")
//                arrayList = it
////                adapter.addItems(arrayList)
//                adapter = CategoryAdapter(this@MainActivity, arrayList)
//                binding.rvCategory.adapter = adapter
//            }
//
//        }


    }
}