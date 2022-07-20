package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class Mammaaksa : AppCompatActivity() {
    private lateinit var binding: ActivityMainTokkeeBinding
    private lateinit var contentArrayList: ArrayList<Model>
    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTokkeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        imageId = arrayOf(
            R.drawable.t110,
            R.drawable.t111,
            R.drawable.t112,
            R.drawable.t113,
            R.drawable.t114,
            R.drawable.t115,
            R.drawable.t116,
            R.drawable.t117
        )

        title = arrayOf(
            "Tulluu tokko yaaban tokotu mul'ata.",
            "Waan lafatti kalan gaalatti fe'an.",
            "Jibicha korma ta'u haada irrattuu beekan.",
            "Harki dabaree wal dhiqa.",
            "Mixiin wal qabattee laga ceeti.",
            "Dhugaafi aduun ni dhokatti malee hin baddu.",
            "Ilkaan hin qabdu; rigaa harkaa qabdi.",
            "Ilmoon harree fe'iisa geesse haadha furti."
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Mammaaksa"
        binding.titleTv.text = tit
        binding.backBtn.setOnClickListener { onBackPressed() }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}