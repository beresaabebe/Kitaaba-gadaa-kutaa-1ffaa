package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MainTokkeeActivity : AppCallOutside() {
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

            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5,
            R.drawable.t6,
            R.drawable.t7,
            R.drawable.t8,
            R.drawable.t9,
            R.drawable.t10
        )

        title = arrayOf(
            "Tokkeen tokkichuma",
            "Lamaan muchaa re'ee",
            "Sadan sunsummanii",
            "Afran mucha sa'aa",
            "Shanan quba harkaa",
            "Ja'an jabbii qaraxaa",
            "Torbaan naannoo sanbataa",
            "Sadeettan dhala leencaa",
            "Saglan yaa'ii Booranaa",
            "Kurnan boolla saddeeqaa"
        )


        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Tokkeen Maali?"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener {
            openPopupMenu(
                this@MainTokkeeActivity,
                binding.menuBtn
            )
        }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}