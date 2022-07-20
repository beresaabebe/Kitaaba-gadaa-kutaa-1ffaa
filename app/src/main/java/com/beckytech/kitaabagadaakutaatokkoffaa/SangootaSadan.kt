package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class SangootaSadan : AppCallOutside() {
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
            R.drawable.t67,
            R.drawable.t68,
            R.drawable.t69,
            R.drawable.t70,
            R.drawable.t71,
            R.drawable.t72,
            R.drawable.t73,
            R.drawable.t74
        )

        title = arrayOf(
            "Sangoota sadan",
            "Waraabeessi sangaa gurraachatti hasaase.",
            "Sangoonni lamaan sangaa adii of biraa ari'an.",
            "Waraabessi sangaa adii nyaate.",
            "Waraabessi sanga gurraachatti hasaase.",
            "Sangaa gurraachi sangaa burree of biraa ari'e.",
            "Waraabessi sangaa burree nyaate.",
            "Waraabeyyiin sangaa gurraacha nyaatan."
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Sangoota sadan"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@SangootaSadan, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}