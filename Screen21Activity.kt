package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class Screen21Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_21)





        //home btnnn
        val homeButton = findViewById<ImageView>(R.id.home_btn21)

        homeButton.setOnClickListener {
            val intent = Intent(this, Screen7Activity::class.java)
            startActivity(intent)
        }

        //Search btnnn
        val sButton = findViewById<ImageView>(R.id.search_btnn21)

        sButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }



        //Add btnnn
        val adButton = findViewById<TextView>(R.id.add_btn21)

        adButton.setOnClickListener {
            val intent = Intent(this, AddMentorActivity::class.java)
            startActivity(intent)
        }


        //chat btnnn
        val chatButton = findViewById<ImageView>(R.id.chat_btn21)

        chatButton.setOnClickListener {
            val intent = Intent(this, Chat13Activity::class.java)
            startActivity(intent)
        }

        val bookedButton = findViewById<Button>(R.id.Booked_btn)

        bookedButton.setOnClickListener {
            val intent = Intent(this, Screen23Activity::class.java)
            startActivity(intent)
        }


        val editButton = findViewById<ImageButton>(R.id.edit_btn21)

        editButton.setOnClickListener {
            val intent = Intent(this, Screen22Activity::class.java)
            startActivity(intent)
        }

        val editButton2 = findViewById<ImageButton>(R.id.edit2_btn21)

        editButton2.setOnClickListener {
            val intent = Intent(this, Screen22Activity::class.java)
            startActivity(intent)
        }



    }
}