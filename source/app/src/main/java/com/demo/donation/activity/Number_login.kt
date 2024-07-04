package com.demo.donation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.demo.R
import com.demo.databinding.ActivityNumberLoginBinding

class Number_login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_login)

        val sendOtp = findViewById<TextView>(R.id.loginbtn)
        sendOtp.setOnClickListener {
            val intent = Intent(this, Otp_page::class.java)
            startActivity(intent)
        }


    }
}