package com.flicker.ambrose

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MoreInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        //find 3 website

        val nytimes = findViewById<Button>(R.id.nytimes)
        nytimes.setOnClickListener {
            val x = Intent(Intent.ACTION_VIEW, Uri.parse("https://nytimes.com"))
            startActivity(x)
        } // end

        val quickmatt = findViewById<Button>(R.id.quickmatt)
        quickmatt.setOnClickListener {
            val x = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-1.26399, 36.8021163z=14"))
            startActivity(x)
        } // end

        val callus = findViewById<Button>(R.id.callus)
        callus.setOnClickListener {
            val x = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0705316151"))
            startActivity(x)
        }

        val camera = findViewById<Button>(R.id.camera)
        camera.setOnClickListener {
            val x = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(x)
        }



    } // endoncreate
}// end class