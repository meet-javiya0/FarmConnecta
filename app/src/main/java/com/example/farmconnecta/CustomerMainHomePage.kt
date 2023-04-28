package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomerMainHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home_page)

        val fruits = findViewById<ImageView>(R.id.Fruits)
        fruits.setOnClickListener {
            val intent = Intent(this, FruitsPage::class.java)
            startActivity(intent)
        }

        val vegetable = findViewById<ImageView>(R.id.Vegetables)
        vegetable.setOnClickListener {
            val intent = Intent(this, vegetable_Page::class.java)
            startActivity(intent)
        }

        val grain = findViewById<ImageView>(R.id.Grains)
        grain.setOnClickListener {
            val intent = Intent(this, GrainPage::class.java)
            startActivity(intent)
        }

        val orgFruits = findViewById<ImageView>(R.id.organicFruits)
        orgFruits.setOnClickListener {
            val intent = Intent(this, OrganicFruitsPage::class.java)
            startActivity(intent)
        }

        val orgVegetable = findViewById<ImageView>(R.id.organicVegetables)
        orgVegetable.setOnClickListener {
            val intent = Intent(this, OrganicVegetablesPage::class.java)
            startActivity(intent)
        }

        val orgGrain = findViewById<ImageView>(R.id.organicGrains)
        orgGrain.setOnClickListener {
            val intent = Intent(this, OrgainGrainsPage::class.java)
            startActivity(intent)
        }

        val myRecyclerView: RecyclerView = findViewById(R.id.recyclerViewMain)

        val itemImageArray = arrayOf(
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h
        )

        val itemHeadingArray = arrayOf(
            "Fruit1",
            "Fruit2",
            "Fruit3",
            "Fruit4",
            "Fruit1",
            "Fruit2",
            "Fruit3",
            "Fruit4",
            "Fruit1",
            "Fruit2",
            "Fruit3",
            "Fruit4"
        )

        val itemMrpArray = arrayOf(
            "50 Rs/-",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-",
            "80 Rs/-",
            "20 Rs/-",
            "10 Rs/-",
            "15 Rs/-",
            "84 Rs/-",
            "55 Rs/-",
            "45 Rs/-"
        )
        
        val itemWeightArray = arrayOf(
            "50 kg",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-",
            "80 Rs/-",
            "20 Rs/-",
            "10 Rs/-",
            "15 Rs/-",
            "84 Rs/-",
            "55 Rs/-",
            "45 Rs/-"
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val itemArrayList: ArrayList<Item> = arrayListOf()
        for (index in itemImageArray.indices) {
            val item = Item(itemHeadingArray[index], itemImageArray[index], itemMrpArray[index], itemWeightArray[index])
            itemArrayList.add(item)
        }
        myRecyclerView.adapter = MyAdapter(itemArrayList, this)
    }
}