package com.devhyesun.kotlinsample.view.main.home.adapter.model

import com.devhyesun.kotlinsample.data.Photo

interface ImageRecyclerModel {
    fun addItem(photo: Photo)

    fun getItem(position: Int): Photo

    fun getItemCount(): Int

    fun notifyDataSetChang()

    var onClick: (Int) -> Unit
}