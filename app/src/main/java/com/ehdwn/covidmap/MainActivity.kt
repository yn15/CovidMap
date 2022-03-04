package com.ehdwn.covidmap

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Loadingstart()
    }

    private fun Loadingstart() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(applicationContext, MapActiviy::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}