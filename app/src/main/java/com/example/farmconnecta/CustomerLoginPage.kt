package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerLoginPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    companion object {
        const val KEY1 = "com.example.readandusedatafromdatabase.email"
        const val KEY2 = "com.example.readandusedatafromdatabase.phoneNumber"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login_page)

        val etMail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        val btnSignUP = findViewById<Button>(R.id.btnSignUp)
        btnSignUP.setOnClickListener {
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
                Toast.makeText(this, "Please enter your Username!", Toast.LENGTH_SHORT).show()
            }
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
    }

    private fun readData(email : String, password : String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("phoneNumber")
        databaseReference.child(phoneNumber).get().addOnSuccessListener {
            // If user exist
            if (it.exists()) {
                val email = it.child("email").value
                val name = it.child("name").value
                val username = it.child("username").value

                val intentWelcome = Intent(this, CustomerMainHomePage::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                startActivity(intentWelcome)
            }
            // If user not exist
            else {
                Toast.makeText(
                    this,
                    "User does not exist, Please register first!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load!, Please try again later", Toast.LENGTH_SHORT)
                .show()
        }
    }
}