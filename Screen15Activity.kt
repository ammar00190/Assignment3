package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class Screen15Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_15)





        //call btnnn
        val callButton = findViewById<ImageButton>(R.id.call_btn_msg)

        callButton.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }

        //video call btnnn
        val videocallButton = findViewById<ImageButton>(R.id.video_btn_msg)

        videocallButton.setOnClickListener {
            val intent = Intent(this, VideoCallActivity::class.java)
            startActivity(intent)
        }

        //Profile btnnn
        val pButton = findViewById<ImageView>(R.id.profile_btn15)

        pButton.setOnClickListener {
            val intent = Intent(this, Screen21Activity::class.java)
            startActivity(intent)
        }

        //Search btnnn
        val sButton = findViewById<ImageView>(R.id.search_btn15)

        sButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }



        //Add btnnn
        val adButton = findViewById<TextView>(R.id.add_btn15)

        adButton.setOnClickListener {
            val intent = Intent(this, AddMentorActivity::class.java)
            startActivity(intent)
        }


        //home btnnn
        val homeButton = findViewById<ImageView>(R.id.home_btn15)

        homeButton.setOnClickListener {
            val intent = Intent(this, Screen7Activity::class.java)
            startActivity(intent)
        }
    }

}