package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerLoginPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login_page)

        val etPhoneNumber = findViewById<TextInputEditText>(R.id.login_phone_number)
        val etPassword = findViewById<TextInputEditText>(R.id.login_password)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, CustomerSignUpPage::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString()
            val password = etPassword.text.toString()

            if (phoneNumber.isNotEmpty() && password.isNotEmpty()) {
                readData(phoneNumber)
            } else {
                Toast.makeText(this, "Please enter your email and password!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun readData(phoneNumberParam: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(phoneNumberParam).get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val intent = Intent(this, CustomerMainHomePage::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Welcome to Farm Connecta", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener

                } else {
                    Toast.makeText(
                        this, "User does not exist, please register first!", Toast.LENGTH_SHORT
                    ).show()
                }
            }.addOnFailureListener {
                Toast.makeText(
                    this,
                    "Failed to read data from database.",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}