package com.emarketing.findit.ui

import com.emarketing.findit.data.Filters
import com.emarketing.findit.data.Site

interface SearchView {
    fun getFiltersOnFailer(message: String)
    fun getFiltersOnSuccess(filters: Filters)
    fun searchOnSuccess(data: ArrayList<Site>)
    fun searchOnFailer(message: String)
}