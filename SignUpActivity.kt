package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject



import android.widget.ArrayAdapter
import android.widget.Spinner


import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_layout)



        val nameEditText: EditText = findViewById(R.id.nameEditText) // Assume you have an EditText for name
        val emailEditText: EditText = findViewById(R.id.emailEditText) // Your email EditText
        val passwordEditText: EditText = findViewById(R.id.passwordEditText) // Your password EditText
        val countrySpinner: Spinner = findViewById(R.id.countryMenu)
        val citySpinner: Spinner = findViewById(R.id.cityMenu)
        val signupButton = findViewById<Button>(R.id.signup_btn2)
        val ContactEditText: EditText = findViewById(R.id.contact_number)

        setupSpinners()




        val loginView = findViewById<TextView>(R.id.LoginView)


        signupButton.setOnClickListener {

            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val contactNo = ContactEditText.text.toString()
            val country = countrySpinner.selectedItem.toString()
            val city = citySpinner.selectedItem.toString()
            val password = passwordEditText.text.toString()


            // Call registerUser function with user input
            if (validateForm(email, password, name, country, city,contactNo)) {

                registerUser(name, email, contactNo, country, city, password)
            }

        }
        loginView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


    }
    private fun setupSpinners() {
        val countries = arrayOf("Select Country", "Country 1", "Country 2") // Add actual country names
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        findViewById<Spinner>(R.id.countryMenu).apply {
            adapter = countryAdapter
            prompt = "Select Country"
        }

        val cities = arrayOf("Select City", "City 1", "City 2") // Add actual city names
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        findViewById<Spinner>(R.id.cityMenu).apply {
            adapter = cityAdapter
            prompt = "Select City"
        }
    }

    private fun validateForm(email: String, password: String, name: String, country: String, city: String, contact: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email address.", Toast.LENGTH_SHORT).show()
            return false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter a password.", Toast.LENGTH_SHORT).show()
            return false
        } else if (password.length < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (country == "Select Country") {
            Toast.makeText(this, "Please select a country.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (city == "Select City") {
            Toast.makeText(this, "Please select a city.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (contact.length != 11 || !contact.startsWith("03")) {
            Toast.makeText(this, "Please enter a valid 11-digit contact number starting with 03.", Toast.LENGTH_SHORT).show()
            return false
        }

        // Add additional validation as needed
        return true
    }


    private fun registerUser(name: String, email: String, contactNo: String, country: String, city: String, password: String) {
        val url = "http://10.0.2.2/Tutorial/register.php"

        val requestQueue = Volley.newRequestQueue(this)
        val stringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                // Handle registration success
                val jsonResponse = JSONObject(response)
                val success = jsonResponse.getBoolean("success")
                val message = jsonResponse.getString("message")
                if (success) {
                    // Registration successful, handle accordingly (e.g., navigate to next screen)
                } else {
                    // Registration failed, display error message
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                // Handle error
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["name"] = name
                params["email"] = email
                params["contactNo"] = contactNo
                params["country"] = country
                params["city"] = city
                params["password"] = password
                return params
            }
        }
        requestQueue.add(stringRequest)
    }

}