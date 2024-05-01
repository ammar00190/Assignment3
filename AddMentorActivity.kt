package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class AddMentorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_12)


        //home btn
        val hButton8 = findViewById<ImageView>(R.id.home_scn12_btn)

        hButton8.setOnClickListener {
            val intent = Intent(this, Screen7Activity::class.java)
            startActivity(intent)
        }


        //Search btnnn
        val sButton = findViewById<ImageView>(R.id.search_btnn12)

        sButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        //chat btnnn
        val chatButton = findViewById<ImageView>(R.id.chat_btn12)

        chatButton.setOnClickListener {
            val intent = Intent(this, Chat13Activity::class.java)
            startActivity(intent)
        }




        //upload video
        val uvidButton = findViewById<LinearLayout>(R.id.vid_btn_12)

        uvidButton.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }

        //Profile btnnn
        val pButton = findViewById<ImageView>(R.id.profile_btn12)

        pButton.setOnClickListener {
            val intent = Intent(this, Screen21Activity::class.java)
            startActivity(intent)
        }

        //upload video
        val camButton = findViewById<LinearLayout>(R.id.photo_btn12)

        camButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }


    }
}