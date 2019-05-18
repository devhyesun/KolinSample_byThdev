package com.devhyesun.kotlinsample.data.source.image

import com.devhyesun.kotlinsample.data.ImageData

class ImageLocalData: ImageDataSource {
    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for(index in 1..size) {
            val name = String.format("sample_%02d", (1..10).random() + 1)
            list.add(ImageData(name, name))
        }

        imageDataList(list)
    }
}