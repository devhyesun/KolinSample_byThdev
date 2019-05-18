package com.devhyesun.kotlinsample.data.source.image

import com.devhyesun.kotlinsample.data.ImageData

class ImageRemoteData : ImageDataSource {
    private val imageList = listOf(
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_01.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_02.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_03.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_04.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_05.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_06.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_07.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_08.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_09.png",
        "https://raw.githubusercontent.com/devhyesun/KolinSample_byThdev/mvp/app/src/main/res/drawable/sample_10.png"
    )

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for (index in 1..size) {
            val randNumber = (0..9).random()
            val url = imageList[randNumber]
            val name = String.format("sample_%02d", randNumber + 1)
            list.add(ImageData(url, name))
        }

        imageDataList(list)
    }
}