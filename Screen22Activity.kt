package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner

class Screen22Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_22)


        //back btnnn
        val backButton = findViewById<ImageButton>(R.id.back_btn22)

        backButton.setOnClickListener {
            val intent = Intent(this, Screen21Activity::class.java)
            startActivity(intent)
        }


        //Spinners
        val countrySpinner: Spinner = findViewById(R.id.countryMenu22)

        // Create an ArrayAdapter using the string array and a default spinner layout
        val countries =   arrayOf("Select Country", "Country 1", "Country 3") // Add your actual country names
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.prompt = "Select Country"
        countrySpinner.adapter = adapter



        val citySpinner: Spinner = findViewById(R.id.cityMenu22)


        val cities = arrayOf("Select City", "City 1", "City 3") // Add your actual country names
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)


        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.prompt = "Select City"


        citySpinner.adapter = adapter2

    }
}