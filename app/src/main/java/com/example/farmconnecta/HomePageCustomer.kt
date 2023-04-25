package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePageCustomer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_customer)

        val btnCustomer = findViewById<Button>(R.id.customerLoginPage)
        btnCustomer.setOnClickListener {
            val intent = Intent(this, )
            startActivity(intent)
        }

        val btnFarmer = findViewById<Button>(R.id.farmerLoginPage)
        btnFarmer.setOnClickListener {
            val intent = Intent(this, )
            startActivity(intent)
        }
    }
}