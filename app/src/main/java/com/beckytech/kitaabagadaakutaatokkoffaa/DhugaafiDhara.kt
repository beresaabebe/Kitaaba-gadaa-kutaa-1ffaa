package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class DhugaafiDhara : AppCallOutside() {
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
            R.drawable.t90,
            R.drawable.t91,
            R.drawable.t92,
            R.drawable.t93,
            R.drawable.t94
        )

        title = arrayOf(
            "Dhugaafi dhara",
            "Dhugaan warqee argate.",
            "Dhugaan warqee baatee dhara bira deeme.",
            "Dhugaan dharatti dhagaa konkolaachise.",
            "Dhugaan dhara ajjeese."
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Dhugaafi Dhara"
        binding.titleTv.text = tit
        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@DhugaafiDhara, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}