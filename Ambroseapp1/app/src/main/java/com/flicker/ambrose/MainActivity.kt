package com.flicker.ambrose
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // below connects to our xml layout
        setContentView(R.layout.activity_main)

        // find buttons in xml
        val sports = findViewById<Button>(R.id.sports)
        val breaking = findViewById<Button>(R.id.breaking)
        val business = findViewById<Button>(R.id.business)
        val politics = findViewById<Button>(R.id.politics)
        val entertainment = findViewById<Button>(R.id.entertainment)
        val moreInfo = findViewById<Button>(R.id.moreinfo)

        // click events/listeners
        sports.setOnClickListener {
            // link to sports page
            startActivity(Intent(applicationContext,SportsPage::class.java))
        } // end

        breaking.setOnClickListener {
            // link to breaking page
            startActivity(Intent(applicationContext,BreakingNewsPage::class.java))

        } // end

        business.setOnClickListener {
            // link to business
            startActivity(Intent(applicationContext,BusinessPage::class.java))

        } // end


        politics.setOnClickListener {
            // link to politic page
            startActivity(Intent(applicationContext,PoliticsPage::class.java))

        } // end

        entertainment.setOnClickListener {
            // link to entertainment
            startActivity(Intent(applicationContext,EntertainmentPage::class.java))

        } // end

        moreinfo.setOnClickListener {
            // link to more info
            startActivity(Intent(applicationContext,MoreInfo::class.java))

        } // end



        // right click app-new-Activity-empty activity
        // Activity=page
        // give a name


    } // end oncreate
}// end class
