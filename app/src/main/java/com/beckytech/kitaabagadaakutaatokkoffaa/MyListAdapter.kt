package com.beckytech.kitaabagadaakutaatokkoffaa

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val img: Array<Int>
) : ArrayAdapter<String>(context, R.layout.row_content_list, title) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.row_content_list, null, true)

        val titleText = rowView.findViewById<TextView>(R.id.titleTv)
        val imageButton = rowView.findViewById<ImageView>(R.id.forwardImg)

        titleText.text = title[position]
        imageButton.setImageResource(img[position])

        return rowView
    }
}