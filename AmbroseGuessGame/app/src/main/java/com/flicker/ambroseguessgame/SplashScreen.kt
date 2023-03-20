package com.flicker.ambroseguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.result.contract.ActivityResultContracts

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //we delay for 4 seconds
        Handler().postDelayed( Runnable {
                //   During the 4 seconds we can do more task-pull things from the database
                // in this case,we only link to main game
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish() //we finish this activity
        },4000 )



    } // end onCreate
} // end class