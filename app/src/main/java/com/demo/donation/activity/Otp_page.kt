package com.demo.donation.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.R

class OtpPage : AppCompatActivity() {

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

        setupOtpInputs()
    }

    private fun setupOtpInputs() {
        val otpEditText1 = findViewById<EditText>(R.id.enter_otp1)
        val otpEditText2 = findViewById<EditText>(R.id.enter_otp2)
        val otpEditText3 = findViewById<EditText>(R.id.enter_otp3)
        val otpEditText4 = findViewById<EditText>(R.id.enter_otp4)
        val otpEditText5 = findViewById<EditText>(R.id.enter_otp5)
        val otpEditText6 = findViewById<EditText>(R.id.enter_otp6)

        otpEditText1.addTextChangedListener(GenericTextWatcher(otpEditText1, otpEditText2))
        otpEditText2.addTextChangedListener(GenericTextWatcher(otpEditText2, otpEditText3))
        otpEditText3.addTextChangedListener(GenericTextWatcher(otpEditText3, otpEditText4))
        otpEditText4.addTextChangedListener(GenericTextWatcher(otpEditText4, otpEditText5))
        otpEditText5.addTextChangedListener(GenericTextWatcher(otpEditText5, otpEditText6))
        otpEditText6.addTextChangedListener(GenericTextWatcher(otpEditText6, null))
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

    inner class GenericTextWatcher(private val currentView: EditText, private val nextView: EditText?) : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            if (s.toString().length == 1) {
                nextView?.requestFocus()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}
