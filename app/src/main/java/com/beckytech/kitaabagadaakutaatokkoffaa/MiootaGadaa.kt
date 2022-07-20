package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MiootaGadaa : AppCallOutside() {
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
            R.drawable.t96,
            R.drawable.t97,
            R.drawable.t98,
            R.drawable.t99,
            R.drawable.t100,
            R.drawable.t101,
            R.drawable.t102,
            R.drawable.t103,
            R.drawable.t104,
            R.drawable.t105
        )

        title = arrayOf(
            "Kallacha\nKallachi mi'a ulfoo Gadaati. Kallachi ilka arbaafi sibiila irraa tolfama. Kallacha Abbaa Gadaatu godhata.",
            "Alangee / Lichee\nAlangeen mi'a ulfoo Gadaati. Alangeen gogaa roobii irraa tolfama. Alangee Abbaa Gadaatu qabata.",
            "Bokkuu\nBokkuun mi'a ulfoo Gadaati. Bokkuun Abbaa Gadaa, Qaalluufi Abbaa Bokkuutu qabata.",
            "Horooroo\nHorooroon mi'a ulfoo Gadaati. Horooroon muka horooressa jedhamu irraa tolfama. Horooroo nama fuudhetu qabata.",
            "Siinqee\nSiinqeen mi'a ulfoo Gadaati. Siinqeen muka harooressa jedhamu irraa tolfama. Siinqee dubartii heerumtetu qabata.",
            "Guutimala\nGuutimalli mi'a ulfoo Gadaati. Guutimalli ribuu foon loonii irraa tolfama. Guutimala dubartoota gadoomantu mataa irratti godhata.",
            "Ruufa\nRuufni mi'a ulfoo Gadaati. Ruufni huccuu irraa tolfama. Ruufa Qaalluufi Abbaa Gadaatu mataatti marata.",
            "Caaccuu\nCaaccuun mi'a ulfoo Gadaati. Caaccuun gogaa loonii irraa tolfama. Caaccuu dubartii deessetu harkatti hidhata.",
            "Maxxaarrii\nMaxxaarriin meeshaa ulfoo Gadaati. Maxxaarriin gogaa horii irraa tolfama. Maxxaarriin guyyaa jilaafi waaqeeffannaa qabatama.",
            "Saqaa\nSaqaan meeshaa ulfoo Gadaati. Gogaa horiifi buqqee irraa tolfama. Saqaa dubartii ilma deessetu harkatti keewwata. Gaafa jila maq-baasaa keewwatti."
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Mi'oota Ulfoo Gadaa"
        binding.titleTv.text = tit
        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@MiootaGadaa, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}