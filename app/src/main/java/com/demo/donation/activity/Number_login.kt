package com.demo.donation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R


class Number_login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_login)

        val sendOtp = findViewById<TextView>(R.id.loginbtn)
        sendOtp.setOnClickListener {
            val intent = Intent(this, OtpPage::class.java)
            startActivity(intent)
        }


    }
}