package com.emarketing.findit.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.emarketing.findit.R
import com.emarketing.findit.data.*
import com.emarketing.findit.mvvm.BaseActivity
import com.emarketing.findit.vm.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*



class Search : BaseActivity(),SearchView{
    lateinit var searchViewModel: SearchViewModel
    var cities=ArrayList<City>()
    var categories=ArrayList<Category>()
    var tags =ArrayList<Tag>()
    val allCities=ArrayList<String>()
    val allCategories=ArrayList<String>()
    val allTages=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchViewModel=SearchViewModel(this, this)
        initLists()
        searchViewModel.getFilters()
        loading()
    }

    fun initLists(){
        allCities.add("Select city")
        allCategories.add("Select category")
        allTages.add("Select tag")
        val citiesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, allCities)
        citiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        city.adapter = citiesAdapter
        city.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                showMessage(allCities[p2])
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }

        val categoriesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, allCategories)
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        category.adapter = categoriesAdapter
        category.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                showMessage(allCategories[p2])
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }

        val tagAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, allTages)
        tagAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag.adapter = tagAdapter
        tag.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                showMessage(allTages[p2])
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
    }

    override fun getFiltersOnFailer(message: String) {
        stopLoading()
        showMessage(message)
        finish()
    }

    override fun getFiltersOnSuccess(filters: Filters) {
        stopLoading()
        tags=filters.tags
        for (tag in tags)
            allTages.add(tag.name)
        categories=filters.categories
        for (category in categories)
            allCategories.add(category.name)
        cities=filters.cities
        for (city in cities)
            allCities.add(city.name)
    }

    override fun searchOnSuccess(data: ArrayList<Site>) {

    }

    override fun searchOnFailer(message: String) {

    }

}