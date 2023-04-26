package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomerLoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login_page)

        val btnSignUP = findViewById<Button>(R.id.btnSignUp)
        btnSignUP.setOnClickListener {
            val intent = Intent(this, CustomerSignUpPage::class.java)
            startActivity(intent)
        }
    }
}