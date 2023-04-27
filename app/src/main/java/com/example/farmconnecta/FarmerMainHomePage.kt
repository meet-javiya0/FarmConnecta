package com.example.farmconnecta

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class FarmerMainHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_main_home_page)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val fName = findViewById<TextInputEditText>(R.id.fName)
        val phoneNumber = findViewById<TextInputEditText>(R.id.phoneNumber)
        val productName = findViewById<TextInputEditText>(R.id.productName)
        val productWeight = findViewById<TextInputEditText>(R.id.productWeight)
        val productLocation = findViewById<TextInputEditText>(R.id.productLocation)
        val productPrice = findViewById<TextInputEditText>(R.id.productPrice)

        btnSubmit.setOnClickListener {
            val fNameString = fName.text.toString()
            val phoneNumberString = phoneNumber.text.toString()
            val productNameString = productName.text.toString()
            val productWeightString = productWeight.text.toString()
            val productLocationString = productLocation.text.toString()
            val productPriceString = productPrice.text.toString()

            // Validate input fields
            if (fNameString.isBlank() || phoneNumberString.isBlank() || productNameString.isBlank() || productWeightString.isBlank() || productLocationString.isBlank() || productPriceString.isBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!isValidPhoneNumber(phoneNumberString)) {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = "^[+]?[0-9]{10,13}\$"
        return phoneNumber.matches(phonePattern.toRegex())
    }
}