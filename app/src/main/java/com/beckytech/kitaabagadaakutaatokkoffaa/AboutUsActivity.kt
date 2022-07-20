package com.beckytech.kitaabagadaakutaatokkoffaa

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityAboutUsBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class AboutUsActivity : AppCallOutside() {

    private lateinit var binding: ActivityAboutUsBinding
    var mInterstitialAd: InterstitialAd? = null

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        setAds()

        binding.webView.loadUrl("file:///android_asset/about.html")
        binding.webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.startsWith(TEL_PREFIX)) {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                    return true
                }
                return false
            }
        }

        binding.phone.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(this@AboutUsActivity)
                mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+251917361283"))
                        if (ContextCompat.checkSelfPermission(
                                this@AboutUsActivity,
                                Manifest.permission.CALL_PHONE
                            )
                            != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@AboutUsActivity, arrayOf(Manifest.permission.CALL_PHONE),
                                1
                            )
                        }
                        startActivity(intent)
                        mInterstitialAd = null
                        setAds()
                    }
                }
            } else {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+251917361283"))
                if (ContextCompat.checkSelfPermission(
                        this@AboutUsActivity,
                        Manifest.permission.CALL_PHONE
                    )
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@AboutUsActivity, arrayOf(Manifest.permission.CALL_PHONE),
                        1
                    )
                }
                startActivity(intent)
            }

        }

        binding.facebook.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(this@AboutUsActivity)
                mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/beresabecky")
                            )
                        )
                        mInterstitialAd = null
                        setAds()
                    }
                }
            } else {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/beresabecky")
                    )
                )
            }
        }

        binding.email.setOnClickListener { view: View? ->
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data =
                Uri.parse("mailto: roobaanuuf@gmail.com") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Email from Galata Gooftaa")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        binding.website.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(this@AboutUsActivity)
                mInterstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://yoosaad.com")
                            )
                        )
                        mInterstitialAd = null
                        setAds()
                    }
                }
            } else {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://yoosaad.com")
                    )
                )
            }
        }

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@AboutUsActivity, binding.menuBtn) }
    }

    companion object {
        private const val TEL_PREFIX = "tel:"
    }

    fun setAds() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, getString(R.string.ads_unit_interstitial_unit), adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    mInterstitialAd = null
                }
            })
    }
}