package com.demo.donation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.demo.databinding.CardDonationBinding

class CardAdapter(
    var dataList: ArrayList<CardModel>,
    var context: Context // Updated context type to Context
) : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CardDonationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.image.setImageResource(dataList[position].image)
        holder.binding.cardHeading.text = dataList[position].card_heading
        holder.itemView.setOnClickListener{
            Toast.makeText(context,dataList.get(position).card_heading,Toast.LENGTH_SHORT).show()
        }
    }

    inner class MyViewHolder(var binding: CardDonationBinding) : RecyclerView.ViewHolder(binding.root)
}
