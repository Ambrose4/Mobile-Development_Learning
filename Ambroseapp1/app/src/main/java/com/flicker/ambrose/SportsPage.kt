package com.flicker.ambrose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SportsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_page)

        // local data = audio/video/pdf/html - internet not need
        // html approach
        //right click app = new = folder = assets folder = finish
        //right click on assets = new = file =sports.html

        val websports = findViewById<WebView>(R.id.websports)
        websports.loadUrl( "file:///android_asset/sports.html" )





    } // endoncreate
} // end class