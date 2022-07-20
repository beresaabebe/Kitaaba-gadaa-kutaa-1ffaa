package com.beckytech.kitaabagadaakutaatokkoffaa

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.beckytech.kitaabagadaakutaatokkoffaa.databinding.ActivityMainTokkeeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class WaaJajuuActivity : AppCallOutside() {
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
            R.drawable.t11,
            R.drawable.t12,
            R.drawable.t13,
            R.drawable.t14,
            R.drawable.t15,
            R.drawable.t16,
            R.drawable.t17,
            R.drawable.t18
        )

        title = arrayOf(
            "Samii utubaa malee dhaabbatu",
            "Lafa dhisaa malee diriirte",
            "Bishaan oofaa malee yaa'u",
            "Bofa miila malee loo'u",
            "Lukkuu mecha malee guddiftu",
            "Gaangee dhala malee hafte",
            "Huummoo dhukkuba malee aadu",
            "Hiddii soora malee gabbattu"
        )

        contentArrayList = arrayListOf()
        getContentData()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val tit = "Waa Jajuu"
        binding.titleTv.text = tit

        binding.backBtn.setOnClickListener { onBackPressed() }

        binding.menuBtn.setOnClickListener { openPopupMenu(this@WaaJajuuActivity, binding.menuBtn) }
    }

    private fun getContentData() {
        for (i in imageId.indices) {
            val cont = Model(imageId[i], title[i])
            contentArrayList.add(cont)
        }
        binding.recyclerView.adapter = MyRecyclerAdapter(contentArrayList)
    }
}