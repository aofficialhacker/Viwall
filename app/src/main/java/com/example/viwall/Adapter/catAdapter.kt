package com.example.viwall.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viwall.R
import com.example.viwall.catActivity
import com.example.viwall.model.catModel

class catAdapter(val requireContext: Context, val listOfCat: ArrayList<catModel>) : RecyclerView.Adapter<catAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView=itemView.findViewById<ImageView>(R.id.cat_image)
        val name=itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        holder.name.text=listOfCat[position].name
        Glide.with(requireContext).load(listOfCat[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext,catActivity::class.java)
            intent.putExtra("uid",listOfCat[position].id)
            intent.putExtra("name",listOfCat[position].name)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount()=listOfCat.size
}