package com.demo.donation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.demo.R
import com.demo.databinding.ActivitySliderBinding
import com.demo.donation.activity.Number_login
import com.demo.donation.activity.Otp_page

@Suppress("UNREACHABLE_CODE")
class AllDonation_Fragment : Fragment() {

    private lateinit var binding: ActivitySliderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_all_donation_fragment, container, false)

        fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


        }
    }

}