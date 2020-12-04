package com.emarketing.findit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.core.text.HtmlCompat
import com.emarketing.findit.R
import com.emarketing.findit.data.Site
import com.emarketing.findit.mvvm.BaseActivity
import com.emarketing.findit.vm.PhotoAdapter
import kotlinx.android.synthetic.main.activity_location_details.*
import kotlinx.android.synthetic.main.activity_location_details.city
import kotlinx.android.synthetic.main.activity_location_details.name

class LocationDetails : BaseActivity() {
    lateinit var currentLocation:Site
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_details)


        currentLocation=getIntent().getParcelableExtra<Site>("location")!!
        name.text=currentLocation.name
        city.text=currentLocation.city_name
        description.text=currentLocation.description
        openingHours.text=currentLocation.opening_hours
        phone.text=currentLocation.phone
        email.text=currentLocation.email
        address.text=currentLocation.address
        val loc="<a href='https://maps.google.com/?q=${currentLocation.latitude},${currentLocation.longitude}'>https://maps.google.com/?q=${currentLocation.latitude},${currentLocation.longitude}</a>"
        mapsLocation.text= HtmlCompat.fromHtml(loc, HtmlCompat.FROM_HTML_MODE_LEGACY)
        if (currentLocation.photos.isEmpty())
            noResults.visibility=View.VISIBLE
        mapsLocation.movementMethod = LinkMovementMethod.getInstance()
        photosView.adapter=PhotoAdapter(this,currentLocation.photos)
    }
}