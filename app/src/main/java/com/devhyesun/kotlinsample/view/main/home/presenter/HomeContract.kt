package com.devhyesun.kotlinsample.view.main.home.presenter

interface HomeContract {
    interface  View {
        fun showImage(imageName: String)
        fun hideProgress()
        fun showProgress()
    }

    interface Presenter {
        fun loadImage()
    }
}