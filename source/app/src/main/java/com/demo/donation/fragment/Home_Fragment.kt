package com.demo.donation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.R
import com.demo.databinding.ActivityHomeFragmentBinding
import com.demo.donation.adapter.CardAdapter

import com.demo.donation.adapter.Constant
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class HomeFragment : Fragment() {

    private lateinit var cardAdapter: CardAdapter

    private lateinit var binding: ActivityHomeFragmentBinding
    private lateinit var imageSlider: ImageSlider


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageSlider = binding.imageSlider

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.donate_img, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.my_donation1, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.my_donation2, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.donate_img, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.my_donation1, ScaleTypes.CENTER_CROP))

        imageSlider.setImageList(imageList)

        cardAdapter = CardAdapter(Constant.getData(), requireContext()) // Use requireContext() to get Context
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.recycler.adapter = cardAdapter
    }
}
