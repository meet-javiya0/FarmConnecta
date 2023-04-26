package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerLoginPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.example.farmconnecta.email"
        const val KEY2 = "com.example.farmconnecta.phoneNumber"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login_page)

        val etMail = findViewById<TextInputEditText>(R.id.login_email)
        val etPassword = findViewById<TextInputEditText>(R.id.login_password)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, CustomerSignUpPage::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val email = etMail.text.toString()
            val password = etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                readData(email, password)
            } else {
                Toast.makeText(this, "Please enter your email and password!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun readData(email: String, password: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.orderByChild("email").equalTo(email).get()
            .addOnSuccessListener { dataSnapshot ->
                if (dataSnapshot.exists()) {
                    for (userSnapshot in dataSnapshot.children) {
                        val phoneNumber = userSnapshot.child("phoneNumber").value as String
                        val name = userSnapshot.child("name").value as String

                        val intent = Intent(this, CustomerMainHomePage::class.java)
                        intent.putExtra(KEY1, email)
                        intent.putExtra(KEY2, phoneNumber)
                        startActivity(intent)

                        Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
                        return@addOnSuccessListener
                    }
                } else {
                    Toast.makeText(
                        this, "User does not exist, please register first!", Toast.LENGTH_SHORT
                    ).show()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(
                    this,
                    "Failed to read data from database. Error: ${exception.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

}