package com.demo.donation.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R

class Otp_page : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var requestOtpButton: TextView
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_page)

        val sendOtp = findViewById<Button>(R.id.btnNext)
        sendOtp.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        timerTextView = findViewById(R.id.timerTextView)
        requestOtpButton = findViewById(R.id.requestOtpButton)

        // Start the OTP timer when the page opens
        startOtpTimer()

        requestOtpButton.setOnClickListener {
            startOtpTimer()
            // Here, you can add the logic to request an OTP from your server
        }
    }

    private fun startOtpTimer() {
        countDownTimer = object : CountDownTimer(30000, 500) { // 30 seconds timer with 0.5 second interval
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = String.format("%02d:%02d", secondsRemaining / 60, secondsRemaining % 60)
            }

            override fun onFinish() {
                timerTextView.text = "00:00"
                // Handle the timer finish, e.g., enable the button to request OTP again
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel() // Cancel the timer if the activity is destroyed to prevent memory leaks
    }
}
