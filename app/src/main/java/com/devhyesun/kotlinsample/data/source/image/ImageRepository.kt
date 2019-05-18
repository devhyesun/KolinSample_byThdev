package com.devhyesun.kotlinsample.data.source.image

import com.devhyesun.kotlinsample.data.ImageData

object ImageRepository: ImageDataSource {

    private val imageLocalData by lazy {
        ImageLocalData()
    }

    private val imageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
//        imageLocalData.loadImageList(imageDataList, size)
        imageRemoteData.loadImageList(imageDataList, size)
    }
}