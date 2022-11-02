package com.example.viwall.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.viwall.FinalWallpaper
import com.example.viwall.R
import com.example.viwall.model.colortoneModel

class colortoneAdapter(val requireContext: Context, val listTheColorTone: ArrayList<colortoneModel>) : RecyclerView.Adapter<colortoneAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val cardBack=itemView.findViewById<CardView>(R.id.item_Card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        val color=listTheColorTone[position].color

        holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener {
            val intent= Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link",listTheColorTone[position].link)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount()=listTheColorTone.size
}