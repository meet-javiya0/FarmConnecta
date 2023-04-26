package com.example.farmconnecta


import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FruitsPage : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<Item>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_page)

        myRecyclerView=findViewById(R.id.recyclerView1)

        var iteamImageArray= arrayOf(

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

        var iteamHeadingArray= arrayOf(

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
        val iteamMrpArray= arrayOf(
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

        myRecyclerView.layoutManager=LinearLayoutManager(this)
        newsArrayList= arrayListOf<Item>()

        for(index in iteamImageArray.indices){
            val news=Item(iteamHeadingArray[index],iteamImageArray[index],iteamMrpArray[index])
            newsArrayList.add(news)
        }

        myRecyclerView.adapter=MyAdapter(newsArrayList,this)


    }




}