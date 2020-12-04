package com.emarketing.findit.ui

import com.emarketing.findit.data.Category

interface GeneralBrowsingView {
    fun onFailer(toString: String)
    fun onSuccess(categories: ArrayList<Category>)
}