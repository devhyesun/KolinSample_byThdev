package com.devhyesun.kotlinsample.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhyesun.kotlinsample.R
import com.devhyesun.kotlinsample.data.ImageData
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(context: Context?, parent: ViewGroup?):
    RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    fun onBind(item: ImageData) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: ImageData) {
        tv_title.text = item.name
        img_view.setImageResource(resources.getIdentifier(item.fileName, "drawable", context.packageName))
    }
}