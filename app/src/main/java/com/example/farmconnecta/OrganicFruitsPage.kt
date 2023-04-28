package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrganicFruitsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organic_fruits_page)

        val itemImageArray = arrayOf(
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.strawberry,
            R.drawable.black_graps,
            R.drawable.graps,
            R.drawable.pomegranate,
            R.drawable.chiku,
            R.drawable.dragon,
            R.drawable.watermelons,
            R.drawable.guava
        )

        val itemHeadingArray = arrayOf(
            "Orange",
            "Kiwi",
            "Banana",
            "Apple",
            "Strawberry",
            "Black Graps",
            "Graps",
            "Pomegranate",
            "Chiku",
            "Dragon fruit",
            "Watermelons",
            "Guava"
        )

        val itemMrpArray = arrayOf(
            "60 Rs/-",
            "40 Rs/-",
            "90 Rs/-",
            "120 Rs/-",
            "60 Rs/-",
            "80 Rs/-",
            "50 Rs/-",
            "100 Rs/-",
            "40 Rs/-",
            "84 Rs/-",
            "55 Rs/-",
            "45 Rs/-"
        )

        val itemWeightArray = arrayOf(
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg"
        )

        val myRecyclerView: RecyclerView = findViewById(R.id.recyclerView4)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val itemArrayList: ArrayList<Item> = arrayListOf()

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
                val intent = Intent(applicationContext, ItemDetailActivity::class.java)
                intent.putExtra("heading", itemArrayList[position].itemHeading)
                intent.putExtra("imageId", itemArrayList[position].itemImage)
                intent.putExtra("MRP", itemArrayList[position].itemMrp)
                intent.putExtra("Weight", itemArrayList[position].itemWeight)
                startActivity(intent)
            }
        })
    }
}