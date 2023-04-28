package com.example.farmconnecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrganicFruitsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var myRecyclerView: RecyclerView
        lateinit var itemArrayList: ArrayList<Item>

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organic_fruits_page)
        myRecyclerView=findViewById(R.id.recyclerView3)

        val itemImageArray= arrayOf(

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

        val itemHeadingArray= arrayOf(

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
        val itemMrpArray= arrayOf(
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

        myRecyclerView.layoutManager= LinearLayoutManager(this)
        itemArrayList= arrayListOf<Item>()

        for(index in itemImageArray.indices){
            val item=Item(itemHeadingArray[index],itemImageArray[index],itemMrpArray[index],itemWeightArray[index])
            itemArrayList.add(item)
        }
        var myAdapter=MyAdapter(itemArrayList,this)
        myRecyclerView.adapter= myAdapter
        myAdapter.setIteamClickListner(object :MyAdapter.onIteamClickListener{
            override fun onItemClick(position: Int) {
                val intent= Intent(applicationContext,itemDetailActivity::class.java)
                intent.putExtra("heading",itemHeadingArray[position])
                intent.putExtra("imageId",itemImageArray[position])
                intent.putExtra("MRP",itemMrpArray[position])
                startActivity(intent)
            }

        })


    }
}