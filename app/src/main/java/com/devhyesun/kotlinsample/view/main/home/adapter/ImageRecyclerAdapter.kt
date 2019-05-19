package com.devhyesun.kotlinsample.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.devhyesun.kotlinsample.data.Photo
import com.devhyesun.kotlinsample.view.main.home.adapter.holder.ImageViewHolder
import com.devhyesun.kotlinsample.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter(private val context: Context?): RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel{
    private val list = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(context, parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun addItem(photo: Photo) {
        list.add(photo)
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }
}