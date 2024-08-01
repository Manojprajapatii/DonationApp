package com.demo.donation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.demo.R
import com.demo.donation.fragment.AllDonation_Fragment
import com.demo.donation.fragment.Donation_Fragment
import com.demo.donation.fragment.Help_Fragment
import com.demo.donation.fragment.HomeFragment
import com.demo.donation.fragment.MyDonation_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dashboard : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_all_donation -> {
                    replaceFragment(AllDonation_Fragment())
                    true
                }
                R.id.bottom_plus -> {
                    replaceFragment(Donation_Fragment())
                    true
                }
                R.id.bottom_my_donation -> {
                    replaceFragment(MyDonation_Fragment())
                    true
                }
                R.id.bottom_help -> {
                    replaceFragment(Help_Fragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}