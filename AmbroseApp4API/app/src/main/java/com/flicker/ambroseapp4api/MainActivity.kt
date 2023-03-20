package com.flicker.ambroseapp4api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    lateinit var productList: ArrayList<Product>
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Github.com/modcomlearning/shop

        recyclerView = findViewById(R.id.recycler)
        progressBar = findViewById(R.id.progressbar)
        progressBar.visibility = View.VISIBLE

        //http client = to help you access API
        val client = AsyncHttpClient(true, 80, 443)
        recyclerAdapter = RecyclerAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)

        client.get(this, "https://ambu.pythonanywhere.com/api/all",
            null, "application/json",
            object: JsonHttpResponseHandler(){
                override fun onSuccess(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    response: JSONArray?
                ) {
                    val gson = GsonBuilder().create()
                    val list = gson.fromJson(response.toString(),
                        Array<Product>::class.java).toList()
                    //now pass the converted list to adapter
                    recyclerAdapter.setProductListItems(list)
                    progressBar.visibility = View.GONE
                } // end onSuccess
                //ToDo OnFailure
            }) // end handler

        //now put the adapter to recycler view - to help in looping
        recyclerView.adapter = recyclerAdapter
    } // end oncreate
} // end class