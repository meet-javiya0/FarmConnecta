package com.example.farmconnecta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrganicVegetablesPage : AppCompatActivity() {
    private lateinit var itemArrayList: ArrayList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organic_vegetables_page)

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

        val myRecyclerView: RecyclerView = findViewById(R.id.recyclerView5)
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