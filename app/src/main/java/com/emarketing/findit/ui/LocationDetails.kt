package com.emarketing.findit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.core.text.HtmlCompat
import com.emarketing.findit.R
import com.emarketing.findit.data.Site
import com.emarketing.findit.mvvm.BaseActivity
import com.emarketing.findit.vm.PhotoAdapter
import kotlinx.android.synthetic.main.activity_location_details.*
import java.util.ArrayList

class LocationDetails : BaseActivity() {
    lateinit var currentLocation:Site
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_details)


        currentLocation=getIntent().getParcelableExtra<Site>("location")!!
        name.text=currentLocation.name
        city.text=currentLocation.city_name
//        description.text=currentLocation.description
        val loc="<a href='https://maps.google.com/?q=${currentLocation.latitude},${currentLocation.longitude}'>https://maps.google.com/?q=${currentLocation.latitude},${currentLocation.longitude}</a>"
        mapsLocation.text= HtmlCompat.fromHtml(loc, HtmlCompat.FROM_HTML_MODE_LEGACY)

        mapsLocation.movementMethod = LinkMovementMethod.getInstance()
        val photos=ArrayList<String>()
        photos.add("https://homepages.cae.wisc.edu/~ece533/images/airplane.png")
        photos.add("https://homepages.cae.wisc.edu/~ece533/images/arctichare.png")
        photos.add("https://homepages.cae.wisc.edu/~ece533/images/baboon.png")
        photos.add("https://homepages.cae.wisc.edu/~ece533/images/cat.png")
        photosView.adapter=PhotoAdapter(this,photos)
    }
}