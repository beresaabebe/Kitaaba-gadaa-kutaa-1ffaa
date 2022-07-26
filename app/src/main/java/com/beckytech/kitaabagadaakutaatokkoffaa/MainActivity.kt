package com.beckytech.kitaabagadaakutaatokkoffaa

import android.content.Intent
import android.os.Bundle
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCallOutside() {

    private lateinit var binding: ActivityMainBinding

    private val title = arrayOf(
        "Boqonnaa 1: Tokkeen Maali?",
        "Boqonnaa 2: Waa jajuu",
        "Boqonnaa 3: Hibboon - Tayii",
        "Boqonnaa 4: Tiksee sobduu",
        "Boqonnaa 5: Faaruu Hirmaanaa",
        "Boqonnaa 6: Eebba Manguddoo",
        "Boqonnaa 7: Binoo - Bineentii",
        "Boqonnaa 8: Muka Mukkurree Ganne",
        "Boqonnaa 9: Tuqaa",
        "Boqonnaa 10: Hiibboo",
        "Boqonnaa 11: Jimaa - jimiitee",
        "Boqonnaa 12: Beenuu ni duullaa",
        "Boqonnaa 13: Sangoota sadan",
        "Boqonnaa 14: Firooma Abbaa",
        "Boqonnaa 15: Firooma Haadhaa",
        "Boqonnaa 16: Dhugaafi Dhara",
        "Boqonnaa 17: Manguddoota Keenya",
        "Boqonnaa 18: Mi'oota ulfoo Gadaa",
        "Boqonnaa 19: Taakkiyyee",
        "Boqonnaa 20: Mammaaksa"
    )

    private val imgId = arrayOf(
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24,
        R.drawable.ic_baseline_arrow_forward_ios_24
    )
    var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        setAds()

        val myListAdapter = MyListAdapter(this, title, imgId)

        binding.listView.adapter = myListAdapter

        binding.listView.setOnItemClickListener { adapterView, _, position, _ ->
            adapterView.getItemIdAtPosition(position)

            if (position == 0) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        MainTokkeeActivity::class.java
                                    )
                                )
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this@MainActivity, MainTokkeeActivity::class.java))
                }
            }

            if (position == 1) {
                startActivity(Intent(this, WaaJajuuActivity::class.java))
            }

            if (position == 2) {
                startActivity(Intent(this, HibboonTayiiActivity::class.java))
            }

            if (position == 3) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(Intent(this@MainActivity, TikseeSobduu::class.java))
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this, TikseeSobduu::class.java))
                }
            }

            if (position == 4) {
                startActivity(Intent(this, FaaruuHirmaanaa::class.java))
            }

            if (position == 5) {
                startActivity(Intent(this, EebbaManguddoo::class.java))
            }

            if (position == 6) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(Intent(this@MainActivity, BinooBineentii::class.java))
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this, BinooBineentii::class.java))
                }
            }
            if (position == 7) {
                startActivity(Intent(this, MukaMukkurree::class.java))
            }
            if (position == 8) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(Intent(this@MainActivity, Tuqaa::class.java))
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this, Tuqaa::class.java))
                }
            }
            if (position == 9) {
                startActivity(Intent(this, Hiibboo::class.java))
            }
            if (position == 10) {
                startActivity(Intent(this, JimaaJimiitee::class.java))
            }
            if (position == 11) {
                startActivity(Intent(this, BeenuNidullaa::class.java))
            }

            if (position == 12) {
                startActivity(Intent(this, SangootaSadan::class.java))
            }
            if (position == 13) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(Intent(this@MainActivity, FiroomaAbbaa::class.java))
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this, FiroomaAbbaa::class.java))
                }
            }

            if (position == 14) {
                startActivity(Intent(this, FiroomaHaadhaa::class.java))
            }
            if (position == 15) {
                startActivity(Intent(this, DhugaafiDhara::class.java))
            }
            if (position == 16) {
                if (mInterstitialAd != null) {
                    mInterstitialAd!!.show(this@MainActivity)
                    mInterstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent()
                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        ManguddooKeenya::class.java
                                    )
                                )
                                mInterstitialAd = null
                                setAds()
                            }
                        }
                } else {
                    startActivity(Intent(this, ManguddooKeenya::class.java))
                }
            }
            if (position == 17) {
                startActivity(Intent(this, MiootaGadaa::class.java))
            }
            if (position == 18) {
                startActivity(Intent(this, Takkiyyee::class.java))
            }
            if (position == 19) {
                startActivity(Intent(this, Mammaaksa::class.java))
            }
        }

        binding.menuBtn.setOnClickListener {
            openPopupMenu(this@MainActivity, binding.menuBtn)
        }
    }

    private fun setAds() {
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