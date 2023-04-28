package com.example.farmconnecta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var itemArrayList: ArrayList<Item>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemArrayList[position]
        holder.hTitle.text = currentItem.itemHeading
        holder.hImage.setImageResource(currentItem.itemImage)
        holder.hPrice.text = currentItem.itemMrp
    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    class MyViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val hTitle: TextView = itemView.findViewById(R.id.title)
        val hImage: ShapeableImageView = itemView.findViewById(R.id.headingImage)
        val hPrice: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }
}