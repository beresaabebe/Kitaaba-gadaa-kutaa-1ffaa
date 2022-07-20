package com.beckytech.kitaabagadaakutaatokkoffaa

import android.annotation.SuppressLint
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beckytech.kitaabagadaakutaatokkoffaa.MyApplication.OnShowAdCompleteListener
import com.google.android.gms.ads.MobileAds

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private var secondsRemaining: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}

        setContentView(R.layout.activity_splash)
        createTimer(SplashActivity.Companion.COUNTER_TIME)
    }

    private fun createTimer(seconds: Long) {
        val counterTextView: TextView = findViewById(R.id.timer)
        val countDownTimer: CountDownTimer = object : CountDownTimer(seconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = millisUntilFinished / 1000 + 1
                counterTextView.text = "App is done loading in: $secondsRemaining"
            }

            override fun onFinish() {
                secondsRemaining = 0
                counterTextView.text = "Done."
                val application: Application = getApplication()
                if (application !is MyApplication) {
                    Log.e(
                        SplashActivity.Companion.LOG_TAG,
                        "Failed to cast application to MyApplication."
                    )
                    startMainActivity()
                    return
                }
                application
                    .showAdIfAvailable(
                        this@SplashActivity,
                        object : OnShowAdCompleteListener {
                            override fun onShowAdComplete() {
                                startMainActivity()
                            }
                        })
            }
        }
        countDownTimer.start()
    }

    fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
        this@SplashActivity.finish()
    }

    companion object {
        private const val LOG_TAG = "SplashActivity"
        private const val COUNTER_TIME: Long = 5
    }
}