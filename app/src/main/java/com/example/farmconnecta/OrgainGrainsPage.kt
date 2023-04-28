package com.example.farmconnecta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrgainGrainsPage : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var itemArrayList: ArrayList<Item>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orgain_grains_page)
        myRecyclerView=findViewById(R.id.recyclerView5)

        val itemImageArray= arrayOf(

            R.drawable.wheat,
            R.drawable.millet,
            R.drawable.corn,
            R.drawable.sorghum,
            R.drawable.beaten_rice
        )

        val itemHeadingArray= arrayOf(

            "Wheat",
            "Millet",
            "Corn",
            "Sorghum",
            "Beaten Rice"

        )
        val itemMrpArray= arrayOf(
            "50 Rs/-",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-"
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
            val item=Item(itemHeadingArray[index],itemImageArray[index],itemMrpArray[index], itemWeightArray[index])
            itemArrayList.add(item)
        }

        myRecyclerView.adapter=MyAdapter(itemArrayList,this)


    }
}