package com.example.memegenerator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memegenerator.room.MemeEntity

class MyAdapter(val context: Context, private val data: List<MemeEntity>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_card, parent, false)
        return MyViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val url=data.get(position).url
        Glide.with(context).load(url).into(holder.view.findViewById(R.id.memeImage))
    }

    override fun getItemCount() = data.size



}