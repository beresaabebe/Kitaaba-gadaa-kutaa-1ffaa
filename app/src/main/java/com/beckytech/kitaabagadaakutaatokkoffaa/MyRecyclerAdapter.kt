package com.beckytech.kitaabagadaakutaatokkoffaa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(private val contentList: ArrayList<Model>) :
    RecyclerView.Adapter<MyRecyclerAdapter.TokkeeViewHolder>() {

    inner class TokkeeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.contentTv)
        val imageView: ImageView = itemView.findViewById(R.id.image_img_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokkeeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tokkee_list_item, parent, false)
        return TokkeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: TokkeeViewHolder, position: Int) {
        val content = contentList[position]

        holder.textView.text = content.title
        holder.imageView.setImageResource(content.image)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

}