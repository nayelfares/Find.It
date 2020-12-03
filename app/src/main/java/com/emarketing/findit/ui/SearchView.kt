package com.emarketing.findit.ui

import com.emarketing.findit.data.Filters

interface SearchView {
    fun getFiltersOnFailer(message: String)
    fun getFiltersOnSuccess(filters: Filters)
}