package com.example.recycleview_pertemuan10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newslist: ArrayList<News>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mlistener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mlistener)
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newslist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.headingTV.text = currentItem.heading
        holder.descTV.text = currentItem.desc

    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val headingTV: TextView = itemView.findViewById(R.id.headingTV)
        val descTV: TextView = itemView.findViewById(R.id.descTV)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
}
