package com.devhyesun.kotlinsample.data.source.image

import com.devhyesun.kotlinsample.data.ImageData

interface ImageDataSource {
    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}