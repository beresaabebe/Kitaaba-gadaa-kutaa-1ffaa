package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class BinooBineentii : AppCallOutside() {
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
            R.drawable.t33,
            R.drawable.t34,
            R.drawable.t35,
            R.drawable.t36,
            R.drawable.t37,
            R.drawable.t38,
            R.drawable.t39,
            R.drawable.t40,
            R.drawable.t41,
            R.drawable.t42
        )

        title = arrayOf(
            "Waraabessa",
            "Hoolaa",
            "Sangaa",
            "Jaldeessa",
            "Leenca",
            "Re'ee",
            "Saree",
            "Bosonuu",
            "Lukkuu",
            "Harree"
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Binoo - Bineentii"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@BinooBineentii, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}