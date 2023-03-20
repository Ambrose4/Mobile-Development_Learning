package com.flicker.ambrose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class PoliticsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_politics_page)

        val webpolitics = findViewById<WebView>(R.id.webpolitics)
        webpolitics.loadUrl("file:///android_asset/politics.html")



    }// end oncreate
}// end class