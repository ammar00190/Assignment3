package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.login_btn2)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Call login function with user input
            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        val url = "http://10.0.2.2/Tutorial/login.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getBoolean("success")
                    val message = jsonResponse.getString("message")
                    if (success) {
                        // Login successful, navigate to next screen
                        val intent = Intent(this, Screen7Activity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Login failed, display error message
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Log.e("LoginActivity", "Exception: ${e.message}")
                    Toast.makeText(this, "Error occurred. Please try again later.", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("LoginActivity", "Volley Error: ${error.message}")
                Toast.makeText(this, "Error occurred. Please try again later.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["email"] = email
                params["password"] = password
                return params
            }
        }

        // Add the request to the RequestQueue
        Volley.newRequestQueue(this).add(stringRequest)
    }
}
