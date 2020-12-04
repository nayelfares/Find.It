package com.emarketing.findit.ui

import android.os.Bundle
import com.emarketing.findit.R
import com.emarketing.findit.data.Category
import com.emarketing.findit.mvvm.BaseActivity
import com.emarketing.findit.vm.CategoryAdapter
import com.emarketing.findit.vm.GeneralBrowsingViewModel
import kotlinx.android.synthetic.main.activity_general_browsing.*

class GeneralBrowsing : BaseActivity(),GeneralBrowsingView {
    lateinit var generalBrowsingViewModel: GeneralBrowsingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_browsing)
        generalBrowsingViewModel= GeneralBrowsingViewModel(this,this)
        loading()
        generalBrowsingViewModel.getCategories()
    }

    override fun onFailer(message: String) {
        stopLoading()
        showMessage(message )
    }

    override fun onSuccess(categories: ArrayList<Category>) {
        stopLoading()
        content.adapter=CategoryAdapter(this,categories)
    }

}