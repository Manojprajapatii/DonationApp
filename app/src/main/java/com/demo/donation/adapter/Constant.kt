package com.demo.donation.adapter

import com.demo.R

object Constant {

    private lateinit var datalist: ArrayList<CardModel>

    fun getData():ArrayList<CardModel>{

        datalist = ArrayList()
        datalist.add(CardModel(R.drawable.food_donation, "He/She want to go school"))
        datalist.add(CardModel(R.drawable.donate_img, "Tree donation"))
        datalist.add(CardModel(R.drawable.my_donation1, "Save tree"))
        datalist.add(CardModel(R.drawable.food_donation, "He/She want to go school"))
        datalist.add(CardModel(R.drawable.donate_img, "Tree donation"))
        datalist.add(CardModel(R.drawable.my_donation1, "Save tree"))
        datalist.add(CardModel(R.drawable.my_donation1, "Save tree"))

        return datalist

    }
}