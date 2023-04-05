package com.mvvm.myapplicationmvvm.mvvmBinding;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.myapplicationmvvm.extras.BlindAdapter;
import com.mvvm.myapplicationmvvm.model.CategoryData;
import com.mvvm.myapplicationmvvm.R;
import com.mvvm.myapplicationmvvm.databinding.CategoryLayoutBinding;

import java.util.ArrayList;

public class CategoryAdapter extends BlindAdapter<CategoryData, CategoryLayoutBinding> {
    public CategoryAdapter(Context context, ArrayList<CategoryData> arrayList) {
        super(context, arrayList);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.category_layout;
    }

    @Override
    public void onBindData(CategoryData model, int position, CategoryLayoutBinding dataBinding) {
        dataBinding.text.setText(model.getName());
    }

    @Override
    protected void onBindDataHolder(CategoryData categoryData, int position, CategoryLayoutBinding mDataBinding, RecyclerView.ViewHolder holder) {

    }

    @Override
    public void onItemClick(CategoryData model, int position) {

    }
}
