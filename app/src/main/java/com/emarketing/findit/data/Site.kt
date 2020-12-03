package com.emarketing.findit.data

data class Site(val result:SiteDetails)

data class SiteDetails(
    val id:Long,
    val name:String,
    val city:String,
    val description:String?,
    val opening_hours:String?,
    val email:String?,
    val phone:String?,
    val latitude:String?,
    val longitude:String?,
    val facebook:String?,
    val instagram:String?,
    val snapchat:String?,
    val whatsapp:String?,
    val website:String?
)