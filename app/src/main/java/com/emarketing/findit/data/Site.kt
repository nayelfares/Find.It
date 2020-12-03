package com.emarketing.findit.data

import java.util.ArrayList

data class Site(val tags:ArrayList<Tag>,val result:SiteDetails,val photos:ArrayList<String>)

data class SiteDetails(
    val id:Long,
    val name:String,
    val description:String?,
    val opening_hours:String?,
    val email:String,
    val phone:String,
    val latitude:String?,
    val longitude:String?,
    val image:String
)

data class SearchResult(val success:Boolean,val message:String,val data:ArrayList<Site>)