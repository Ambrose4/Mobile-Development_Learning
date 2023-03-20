package com.flicker.ambroseguessgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    // create an array of your images
    val images = arrayOf(
        R.drawable.c1,R.drawable.c2,R.drawable.c3,
        R.drawable.c4,R.drawable.c5)

    //array of question for above image
    val questions = arrayOf("What type of make is this?","can you identify its origin?",
    "which year was it manufactured?","which car is this?","is this new or old model?")

    val answers = arrayOf("bmw","japan","2015","toyota","new model")

    // SET POINTS TO 0

    var points: Int = 0
    var counter: Int = 0

    //define your for views
    lateinit var quizimage: ImageView
    lateinit var quizquestion: TextView
    lateinit var quizanswer: EditText
    lateinit var quizsubmit: Button


    override fun onPause() {
        super.onPause()
        //Toast.makeText(applicationContext, "Game paused",
       // Toast.LENGTH_SHORT).show()
        player.stop()
    } // end onPause

    override fun onBackPressed() {
        super.onBackPressed()
            Toast.makeText(applicationContext, "Quit",
            Toast.LENGTH_SHORT).show()
        player.stop()


    } // end onBackPressed

    override fun onResume() {
        super.onResume()
        player.start()
    } // end onResume

        lateinit  var player: MediaPlayer // define


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        // play background song
        player = MediaPlayer.create (this, R.raw.song) // initialize
        player.start()
        player.isLooping = true

        val timer = findViewById<TextView>(R.id.timer)
        quizsubmit = findViewById(R.id.quizsubmit)

        //timer - the game should be played with given time
        object: CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                timer.text = "seconds remaining:"+p0/1000
            } // end on tick

            override fun onFinish() {
               quizsubmit.visibility = View.GONE
                Toast.makeText(applicationContext, "Time is up!",
                    Toast.LENGTH_SHORT).show()
                player.stop()


            } // end onfinish

        }.start()







        quizimage = findViewById(R.id.quizimage)
        quizquestion = findViewById(R.id.quizquestion)
        quizanswer = findViewById(R.id.quizanswer)

        // set quiz number 0
        quizimage.setImageResource(images[counter])
        quizquestion.text = questions[counter]

        // user types an answer after seeing the image and the question
        quizsubmit.setOnClickListener {
            //check if user inputs is same answer[0]
              if(counter <=3) { // number of quiz minus 1
                  if (quizanswer.text.toString() == answers[counter]) {
                      Toast.makeText(applicationContext, "Right"+counter, Toast.LENGTH_LONG).show()
                      counter++ // add 1 to counter
                      quizimage.setImageResource(images[counter]) //next image
                      quizquestion.text = questions[counter] // next question
                      // clear the answer
                      quizanswer.text.clear()
                      // Add to points

                      points + 2

                  } else {
                      Toast.makeText(applicationContext, "Wrong"+counter, Toast.LENGTH_LONG).show()
                      counter++ // add 1 to counter
                      quizimage.setImageResource(images[counter]) //next image
                      quizquestion.text = questions[counter] // next question
                      // clear the answer
                      quizanswer.text.clear()
                      // Add to points

                      points + 0

                  } // end else

              } // end if of counter
              else {
                      // check how many points , above 8 points move to level 2
                      Toast.makeText(applicationContext, "Game Over", Toast.LENGTH_LONG).show()
                      Toast.makeText(applicationContext, "you scored"+points, Toast.LENGTH_LONG).show()
                      player.stop()
              } // end else of counter



        } // end listener



    } // end onCreate
} // end class

//automate the question to loop
//play background music
//-right click on res -new - directory ....give it a name raw-paste the song their
//calculate points
//timer
//randomize
//levels
//ads