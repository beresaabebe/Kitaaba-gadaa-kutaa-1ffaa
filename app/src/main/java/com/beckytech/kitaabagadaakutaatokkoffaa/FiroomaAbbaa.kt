package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class FiroomaAbbaa : AppCallOutside() {
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
            R.drawable.t75,
            R.drawable.t76,
            R.drawable.t77,
            R.drawable.t89,
            R.drawable.t78,
            R.drawable.t80,
            R.drawable.t79,
            R.drawable.t81
        )

        title = arrayOf(
            "Abaabilee / Abutturo\n" +
                    "Abaabayyuun abbaa koo Abaabilee / Abutturoo kooti.",
            "Abaabayyuu / Abuuboo\n" +
                    "Akaakoon abbaa koo Abaabayyuu / Abuuboo kooti.",
            "Akaakayyuu / Akaakoo\n" +
                    "Abbaan abbaa koo Akaakayyuu kooti.",
            "Akkoo \nHaati abbaa koo Akkoo kooti.",
            "Abbaa",
            "Abberaa / Wasiila / Abbaa-guddaa\n" +
                    "Obboleessi abbaa koo Abbeeraa / Wasiila kooti.",
            "Adaadaa\nObboleettiin abbaa koo Adaadaa kooti.",
            "Ilma"
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Firooma Abbaa"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }
        binding.menuBtn.setOnClickListener { openPopupMenu(this@FiroomaAbbaa, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}