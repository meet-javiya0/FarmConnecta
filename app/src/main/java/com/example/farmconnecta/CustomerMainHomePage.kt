package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomerMainHomePage : AppCompatActivity() {
    private lateinit var itemArrayList: ArrayList<Item>
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
            val intent = Intent(this, VegetablePage::class.java)
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
            val intent = Intent(this, OrganicGrainsPage::class.java)
            startActivity(intent)
        }

        val itemImageArray = arrayOf(
            R.drawable.panuts,
            R.drawable.jasud,
            R.drawable.tometo,
            R.drawable.poteto,
            R.drawable.g

        )

        val itemHeadingArray = arrayOf(
            "Peanuts",
            "Jasood",
            "Tomato",
            "Potato",
            "Banana"

        )

        val itemMrpArray = arrayOf(
            "50 Rs/-",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-"
        )

        val itemWeightArray = arrayOf(
            "50 kg",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-"

        )

        val myRecyclerView: RecyclerView = findViewById(R.id.recyclerViewMain)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        itemArrayList = arrayListOf()

        for (index in itemImageArray.indices) {
            val item = Item(
                itemHeadingArray[index],
                itemImageArray[index],
                itemMrpArray[index],
                itemWeightArray[index]
            )
            itemArrayList.add(item)
        }

        val myAdapter = MyAdapter(itemArrayList)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClicking(position: Int) {
                val intent = Intent(applicationContext, itemDetailActivity::class.java)
                intent.putExtra("heading", itemArrayList[position].itemHeading)
                intent.putExtra("imageId", itemArrayList[position].itemImage)
                intent.putExtra("MRP", itemArrayList[position].itemMrp)
                intent.putExtra("Weight", itemArrayList[position].itemWeight)
                startActivity(intent)
            }
        })
    }
}