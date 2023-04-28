package com.example.farmconnecta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrganicVegetablesPage : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var itemArrayList: ArrayList<Item>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organic_vegetables_page)
        myRecyclerView=findViewById(R.id.recyclerView4)

        val itemImageArray= arrayOf(

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

        val itemHeadingArray= arrayOf(

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
        val itemMrpArray= arrayOf(
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

        myRecyclerView.layoutManager= LinearLayoutManager(this)
        itemArrayList= arrayListOf<Item>()

        for(index in itemImageArray.indices){
            val item=Item(itemHeadingArray[index],itemImageArray[index],itemMrpArray[index],itemWeightArray[index])
            itemArrayList.add(item)
        }

        myRecyclerView.adapter=MyAdapter(itemArrayList,this)


    }
}