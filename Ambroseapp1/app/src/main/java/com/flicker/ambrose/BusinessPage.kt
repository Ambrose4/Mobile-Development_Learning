package com.flicker.ambrose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class BusinessPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_page)
        val webbusiness = findViewById<WebView>(R.id.webbusiness)
        webbusiness.loadUrl( "file:///android_asset/business.html")

    } // end oncreate
} // end class