package com.example.farmconnecta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GrainPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var myRecyclerView: RecyclerView
        lateinit var itemArrayList: ArrayList<Item>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grain_page)

        myRecyclerView=findViewById(R.id.recyclerView2)

        val itemImageArray= arrayOf(

            R.drawable.wheat,
            R.drawable.millet,
            R.drawable.corn,
            R.drawable.sorghum,
            R.drawable.beaten_rice,
            R.drawable.matar_dal,
            R.drawable.lentils,
            R.drawable.lima_beans,
            R.drawable.green_peas,
            R.drawable.kidney_beans,
            R.drawable.green_gram,
            R.drawable.black_eyed_pea,
            R.drawable.chana,
            R.drawable.urad_dal,
            R.drawable.black_gram,
            R.drawable.chickpeas,
        )

        val itemHeadingArray= arrayOf(

            "Wheat",
            "Millet",
            "Corn",
            "Sorghum",
            "Beaten Rice",
            "Yellow Split Peas",
            "Lentils",
            "Lima Beans",
            "Green Peas",
            "Kidney Beans",
            "Green Gram",
            "Black eyed peas",
            "Chana",
            "Urad Dal",
            "Black Gram",
            "Chickpeas"
        )
        val itemMrpArray= arrayOf(
            "50 Rs/-",
            "30 Rs/-",
            "80 Rs/-",
            "100 Rs/-",
            "56 Rs/-",
            "48 Rs/-",
            "65 Rs/-",
            "42 Rs/-",
            "45 Rs/-",
            "32 Rs/-",
            "65 Rs/-",
            "34 Rs/-",
            "45 Rs/-",
            "53 Rs/-",
            "37 Rs/-",
            "60 Rs/-"
        )
        myRecyclerView.layoutManager= LinearLayoutManager(this)
        itemArrayList= arrayListOf<Item>()

        for(index in itemImageArray.indices){
            val item=Item(itemHeadingArray[index],itemImageArray[index],itemMrpArray[index])
            itemArrayList.add(item)
        }

        myRecyclerView.adapter=MyAdapter(itemArrayList,this)


    }
}

