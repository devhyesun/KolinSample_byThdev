package com.devhyesun.kotlinsample.view.main.home.adapter.model

import com.devhyesun.kotlinsample.data.ImageData

interface ImageRecyclerModel {
    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}