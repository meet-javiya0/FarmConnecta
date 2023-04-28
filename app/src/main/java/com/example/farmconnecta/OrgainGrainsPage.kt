package com.example.farmconnecta


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrgainGrainsPage : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var itemArrayList: ArrayList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orgain_grains_page)
        myRecyclerView = findViewById(R.id.recyclerView5)

        val itemImageArray = arrayOf(

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
            R.drawable.chickpeas
        )

        val itemHeadingArray = arrayOf(

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
            "Vigna mungo",
            "Black Gram",
            "Chickpeas"

        )
        val itemMrpArray = arrayOf(
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
            "1kg",
            "1kg",
            "1kg",
            "1kg",
            "1kg"


        )
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