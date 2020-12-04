package com.emarketing.findit.data

import java.util.ArrayList


data class Site(
    val name: String,
    val description: String?,
    val opening_hours: String?,
    val email: String,
    val phone: String,
    val latitude: String?,
    val longitude: String?,
    val profile_photo: String,
    val city_name: String
)

data class SearchResult(val success:Boolean,val message:String,val data:ArrayList<Site>)