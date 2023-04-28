package com.example.farmconnecta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class itemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val heading=   intent.getStringExtra("heading")
        val MRP = intent.getStringExtra("MRP")
        val imageID = intent.getIntExtra("imageId",R.drawable.carot)


        val headings=findViewById<TextView>(R.id.tital)
        val image=findViewById<ImageView>(R.id.headingImage)
        val mrp=findViewById<TextView>(R.id.price)
        val weights=findViewById<TextView>(R.id.weight)

        headings.text=heading
        mrp.text=MRP
        image.setImageResource(imageID)

    }
}




