package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FarmerLoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_login_page)

        val btnSignUP = findViewById<Button>(R.id.btnSignUp)
        btnSignUP.setOnClickListener {
            val intent = Intent(this, FarmerSignUpPage::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            handleSignIn()
        }
    }

    private fun handleSignIn() {
        val email = findViewById<EditText>(R.id.signup_email).text.toString().trim()
        val password = findViewById<EditText>(R.id.password_toggle).text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            return
        }
        val intent = Intent(this, FarmerMainHomePage::class.java)
        startActivity(intent)
    }
}