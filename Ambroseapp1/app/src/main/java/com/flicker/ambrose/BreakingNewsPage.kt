package com.flicker.ambrose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class BreakingNewsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breaking_news_page)

        val webreaking = findViewById<WebView>(R.id.webbreaking)
        webreaking.loadUrl( "file:///android_asset/breakingnews.html")

    }
}