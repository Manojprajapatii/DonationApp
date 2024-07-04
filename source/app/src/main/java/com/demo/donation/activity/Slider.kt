package com.demo.donation.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.R
import com.demo.databinding.ActivitySliderBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class Slider : AppCompatActivity() {

    private lateinit var binding: ActivitySliderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signPhone.setOnClickListener {
            val intent = Intent(this, Number_login::class.java)
            startActivity(intent)
        }

        binding.facebook.setOnClickListener {
            openUrl("https://www.facebook.com/")
        }

        binding.google.setOnClickListener {
            openUrl("https://google.com/")
        }

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.slider_1, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.slider_2, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.slider_3, ScaleTypes.CENTER_CROP))

        imageSlider.setImageList(imageList)
    }

    private fun openUrl(link: String) {
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
