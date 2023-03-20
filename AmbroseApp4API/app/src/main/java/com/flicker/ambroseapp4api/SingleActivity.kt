package com.flicker.ambroseapp4api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import org.json.JSONObject

class SingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        // access your prefs
        val prefs = getSharedPreferences("db", MODE_PRIVATE)

        val p_name = findViewById<TextView>(R.id.p_name)
        p_name.text = prefs.getString("product_name", "")
        val p_cost = findViewById<TextView>(R.id.p_cost)
        p_cost.text = "kES"+ prefs.getString("product_cost", "")
        val p_desc = findViewById<TextView>(R.id.p_desc)
        p_desc.text = prefs.getString("product_desc", "")
        val image_url = findViewById<ImageView>(R.id.img_url)
        Glide.with(applicationContext).load(prefs.getString("image_url", ""))
            .apply(RequestOptions().centerCrop())
            .into(image_url) // put to image view


        // we now get the phone and amount

        val phone = findViewById<EditText>(R.id.phone)
        val progressbar = findViewById<ProgressBar>(R.id.progressbar)
        progressbar.visibility = View.GONE
        val pay = findViewById<Button>(R.id.pay)
        pay.setOnClickListener {
            progressbar.visibility = View.VISIBLE
            val client = AsyncHttpClient(true, 80, 443)
            //prepare what you will post
            val data = JSONObject()
           // data.put("amount", prefs.getString("product_cost", "")) // get cost from prefs
            data.put("amount", "1")
            data.put("phone", phone.text.toString())// get phone from edittext

            // convert data in a format that my API is using
            val condata = StringEntity(data.toString())

            // POST IT TO API
            client.post(this, "https://ambu.pythonanywhere.com/mpesa_payment",
            condata, "application/JSON",
            object:JsonHttpResponseHandler() {
                override fun onSuccess(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    response: JSONObject?
                ) {
                    // super, onSuccess(statusCode,headers, response)
                    // pn success means the API will send on stk prompt to phone number entered
                    Toast.makeText(applicationContext, "complete payment on your phone",
                    Toast.LENGTH_SHORT).show()
                    progressbar.visibility = View.GONE
                }

            }) // END POST

        }// end listener

    }// end oncreate
}// end class