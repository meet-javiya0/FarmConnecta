package com.example.farmconnecta

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class vegetable_Page : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var itemArrayList: ArrayList<Item>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetable_page)



        myRecyclerView = findViewById(R.id.recyclerView1)

        val itemImageArray = arrayOf(
            R.drawable.carot,
            R.drawable.chili,
            R.drawable.choli,
            R.drawable.cucumber,
            R.drawable.garlich,
            R.drawable.ladyfigyer,
            R.drawable.onion,
            R.drawable.poteto,
            R.drawable.kobi,
            R.drawable.tometo,
            R.drawable.rigna
        )

        val itemHeadingArray = arrayOf(
            "Carrot",
            "Chili",
            "Black_eyed peas",
            "Cucumber",
            "Garlich",
            "Lady finger",
            "Onion",
            "Potato",
            "Cabbage",
            "Tomato",
            "Brinjal"

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
            "55 Rs/-"
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
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        itemArrayList = arrayListOf<Item>()

        for (index in itemImageArray.indices) {
            val item = Item(itemHeadingArray[index], itemImageArray[index], itemMrpArray[index],itemWeightArray[index])
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