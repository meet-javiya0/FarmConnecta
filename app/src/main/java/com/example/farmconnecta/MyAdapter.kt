package com.example.farmconnecta

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class MyAdapter(var newsArrayList: ArrayList<Item>, var context: Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=  LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem=newsArrayList[position]
        holder.hTital.text=currentItem.iteamHeading
        holder.hImage.setImageResource(currentItem.iteamImage)

    }

    override fun getItemCount(): Int {
        return newsArrayList.size

    }

    class MyViewHolder(iteamView: View): RecyclerView.ViewHolder(iteamView){
        val hTital=iteamView.findViewById<TextView>(R.id.headingTital)

        val hImage=iteamView.findViewById<ShapeableImageView>(R.id.headingImage)
    }

}