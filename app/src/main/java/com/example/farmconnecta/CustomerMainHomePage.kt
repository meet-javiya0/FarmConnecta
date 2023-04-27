package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CustomerMainHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home_page)

        val fruits = findViewById<ImageView>(R.id.fruit)
        fruits.setOnClickListener {

            val intent = Intent(this, FruitsPage::class.java)
            startActivity(intent)
        }
        val vegetable = findViewById<ImageView>(R.id.vegetable)
        vegetable.setOnClickListener {

            val intent = Intent(this, vegetable_Page::class.java)
            startActivity(intent)
        }
        val grain = findViewById<ImageView>(R.id.grain)
        grain.setOnClickListener {

            val intent = Intent(this, GrainPage::class.java)
            startActivity(intent)
        }
    }
}