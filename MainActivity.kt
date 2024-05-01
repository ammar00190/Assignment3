package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast



import android.widget.ArrayAdapter
import android.widget.Spinner


import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assuming you have a button with id 'nextButton' in your layout
        val nextButton = findViewById<Button>(R.id.start_btn)

        // Set OnClickListener to the button
        nextButton.setOnClickListener {
            // Create Intent to switch to NextActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // Start NextActivity
        }

/*        val countrySpinner: Spinner = findViewById(R.id.countryMenu)

// Create an ArrayAdapter using the string array and a default spinner layout
        val countries =
            arrayOf("Select Country", "Country 1", "Country 3") // Add your actual country names
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Set a prompt for the Spinner
        countrySpinner.prompt = "Select Country"

// Apply the adapter to the spinner
        countrySpinner.adapter = adapter



        val citySpinner: Spinner = findViewById(R.id.cityMenu)

// Create an ArrayAdapter using the string array and a default spinner layout
        val cities =
            arrayOf("Select City", "City 1", "City 3") // Add your actual country names
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)

// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Set a prompt for the Spinner
        citySpinner.prompt = "Select City"

// Apply the adapter to the spinner
        citySpinner.adapter = adapter2
    }
*/

    ///------------------------------------Login Page-------------------
 //Find the TextView by its ID

//        val signupTextView = findViewById<TextView>(R.id.SignupView)
//
//        Log.d("MainActivity", "SignupTextView: $signupTextView")
//        signupTextView.setOnClickListener { val second_intent=Intent(this,SignUp_activity::class.java)
//        startActivity(second_intent)
//        }
//
//        // Create a ClickableSpan to underline the text and handle the click event
//        val clickableSpan = object : ClickableSpan() {
//            override fun onClick(widget: View) {
//                // Handle the click event for the "Signup" text
//                // You can navigate to the signup screen or perform other actions here
//            }
//
//            override fun updateDrawState(ds: TextPaint) {
//                super.updateDrawState(ds)
//                ds.isUnderlineText = true // Set underline for the text
//            }
//        }
//
//        // Apply the ClickableSpan to the "Signup" text
//        val spannableString = SpannableString("Signup")
//        spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        // Set the SpannableString to the TextView
//        signupTextView.text = spannableString
//
//        // Enable clickable behavior for the TextView
//        signupTextView.movementMethod = LinkMovementMethod.getInstance()
   }
}



