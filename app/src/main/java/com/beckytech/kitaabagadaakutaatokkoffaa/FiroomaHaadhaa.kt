package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class FiroomaHaadhaa : AppCallOutside() {
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
            R.drawable.t82,
            R.drawable.t83,
            R.drawable.t84,
            R.drawable.t89,
            R.drawable.t85,
            R.drawable.t86,
            R.drawable.t87,
            R.drawable.t88
        )

        title = arrayOf(
            "Abaabilee / Abutturo\n" +
                    "Abaabayyuun haadha koo Abaabilee / Abutturoo kooti.",
            "Abaabayyuu / Abuuboo\n" +
                    "Akaakoon haadha koo Abaabayyuu / Abuuboo kooti.",
            "Akaakayyuu / Akaakoo\n" +
                    "Abbaan haadha koo Akaakayyuu kooti.",
            "Akkoo \nHaati haadha koo Akkoo kooti.",
            "Haadha",
            "Eessuma / Abuyyaa\n" +
                    "Obboleessi haadha koo Essuma / Abuyyaa kooti.",
            "Adaadaa / Haboo / Areeraa \nObboleettiin haadha koo Adaadaa / haboo / areeraa kooti.",
            "Intala"
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Firooma Haadhaa"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@FiroomaHaadhaa, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}