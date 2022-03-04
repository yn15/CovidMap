package com.ehdwn.covidmap

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.ehdwn.covidmap.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var i:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = object:Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                binding.percent.setText(msg.arg1.toString().plus("%"))
            }
        }
        thread(start=true){
            for(i in 0..100){
                binding.progressBar.setProgress(i)
                val msg = handler.obtainMessage()
                msg.arg1 = i
                handler.sendMessage(msg)
                Thread.sleep(300)
            }
        }

//        val t = Thread {
//            while (i <= 100) {
//                binding.progressBar.setProgress(i)
//                val msg: Message = handler.obtainMessage()
//                msg.arg1 = i
//                handler.sendMessage(msg)
//                try {
//                    Thread.sleep(100)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//                i++
//            }
//        }
        //Loadingstart()
    }
}