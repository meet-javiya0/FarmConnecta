package com.example.farmconnecta

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomerMainHomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var myRecyclerView: RecyclerView
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

        val orgfruits = findViewById<ImageView>(R.id.organicFruits)
        orgfruits.setOnClickListener {

            val intent = Intent(this, OrganicFruitsPage::class.java)
            startActivity(intent)
        }
        val orgvegetable = findViewById<ImageView>(R.id.organicVegetable)
        orgvegetable.setOnClickListener {

            val intent = Intent(this, OrganicVegetablesPage::class.java)
            startActivity(intent)
        }
//        val orggrain = findViewById<ImageView>(R.id.organicGrain)
//        orggrain.setOnClickListener {
//            val intent = Intent(this, OrgainGrainsPage::class.java)
//            startActivity(intent)
//        }

//        myRecyclerView=findViewById(R.id.recyclerViewMain)

        val itemImageArray= arrayOf(

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

        val itemHeadingArray= arrayOf(

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
            "55 Rs/-",
            "45 Rs/-"
        )

        myRecyclerView.layoutManager= LinearLayoutManager(this)
        val itemArrayList: ArrayList<Item> = arrayListOf()

        for(index in itemImageArray.indices){
            val item=Item(itemHeadingArray[index],itemImageArray[index],itemMrpArray[index])
            itemArrayList.add(item)
        }

        myRecyclerView.adapter=MyAdapter(itemArrayList,this)


    }
}