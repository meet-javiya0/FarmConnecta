package com.example.farmconnecta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerSignUpPage : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_sign_up_page)

        val btnSignUP = findViewById<Button>(R.id.btnSignUp)
        val fName = findViewById<TextInputEditText>(R.id.fName)
        val lName = findViewById<TextInputEditText>(R.id.lName)
        val location = findViewById<TextInputEditText>(R.id.location)
        val phoneNumber = findViewById<TextInputEditText>(R.id.phoneNumber)
        val etMail = findViewById<TextInputEditText>(R.id.signup_email)
        val etPassword = findViewById<TextInputEditText>(R.id.signup_password)

        btnSignUP.setOnClickListener {
            // Get user data
            val firstName = fName.text.toString()
            val lastName = lName.text.toString()
            val locationString = location.text.toString()
            val phoneNumberString = phoneNumber.text.toString()
            val email = etMail.text.toString()
            val etPasswordString = etPassword.text.toString()

            // Validate input fields
            if (firstName.isBlank() || lastName.isBlank() || locationString.isBlank() || phoneNumberString.isBlank() || email.isBlank() || etPasswordString.isBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!isValidEmail(email)) {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!isStrongPassword(etPasswordString)) {
                Toast.makeText(
                    this,
                    "Password should contain at least 1 uppercase, 1 lowercase, 1 digit, 1 special character, and have a minimum length of 8 characters",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (!isValidPhoneNumber(phoneNumberString)) {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create user object
            val users = Users(
                firstName,
                lastName,
                email,
                etPasswordString,
                phoneNumberString,
                locationString
            )

            // Save user data in database
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(phoneNumberString).setValue(users).addOnSuccessListener {
                Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Email validation function
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Password validation function
    private fun isStrongPassword(password: String): Boolean {
        val passwordPattern =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        return password.matches(passwordPattern.toRegex())
    }

    // Phone number validation function
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = "^[+]?[0-9]{10,13}\$"
        return phoneNumber.matches(phonePattern.toRegex())
    }
}