package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FarmerLoginPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    companion object {
        const val KEY1 = "com.example.farmconnecta.phoneNumber"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_login_page)

        val etPhoneNumber = findViewById<TextInputEditText>(R.id.farmer_login_phone_number)
        val etPassword = findViewById<TextInputEditText>(R.id.farmer_login_password)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val intent = Intent(this, FarmerSignUpPage::class.java)
            startActivity(intent)
        }


        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {

            val intent = Intent(this, FarmerHomePage::class.java)
            startActivity(intent)
            val phoneNumber = etPhoneNumber.text.toString()
            val password = etPassword.text.toString()

            if (phoneNumber.isNotEmpty() && password.isNotEmpty()) {
                if (!isStrongPassword(password)) {
                    Toast.makeText(
                        this,
                        "Password must match with your sign up password",
                        Toast.LENGTH_SHORT
                    ).show()
                    readData(phoneNumber)
                    return@setOnClickListener
                }
            } else {
                Toast.makeText(this, "Please enter your email and password!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun isStrongPassword(password: String): Boolean {
        val passwordPattern =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        return password.matches(passwordPattern.toRegex())
    }

    private fun readData(phoneNumberParam: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Farmers")
        databaseReference.child(phoneNumberParam).get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val phoneNumber = it.child("phoneNumber").value

                    val intent = Intent(this, FarmerMainHomePage::class.java)
                    intent.putExtra(KEY1, phoneNumber.toString())
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