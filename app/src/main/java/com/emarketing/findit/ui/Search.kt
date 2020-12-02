package com.emarketing.findit.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.emarketing.findit.R
import com.emarketing.findit.mvvm.BaseActivity
import com.emarketing.findit.vm.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*


class Search : BaseActivity(),SearchView{
    lateinit var searchViewModel: SearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchViewModel=SearchViewModel(this, this)
        val users = arrayOf(
            "Suresh Dasari",
            "Trishika Dasari",
            "Rohini Alavala",
            "Praveen Kumar",
            "Madhav Sai"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, users)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        city.adapter = adapter
        city.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                showMessage(users[p2])
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
    }

}