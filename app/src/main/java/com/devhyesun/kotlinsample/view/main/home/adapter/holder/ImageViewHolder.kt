package com.devhyesun.kotlinsample.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhyesun.kotlinsample.R
import com.devhyesun.kotlinsample.data.ImageData
import com.devhyesun.kotlinsample.data.Photo
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(onClick:(Int)->Unit, context: Context?, parent: ViewGroup?):
    RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun onBind(item: Photo) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo) {
        img_view.loadImage(item.getImageUrl())
    }
}