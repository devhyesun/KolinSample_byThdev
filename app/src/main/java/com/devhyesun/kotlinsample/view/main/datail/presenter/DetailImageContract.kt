package com.devhyesun.kotlinsample.view.main.datail.presenter

interface DetailImageContract {
    interface View {
        fun updateToolbarItem(buddyIcon: String, buddyName: String)
        fun updateItem(imageUrl: String, title: String, content: String, date: String, viewCount: String, commentCount: String)
        fun showFlickrWebPage(url: String)
    }

    interface Presenter {
        fun loadDetailInfo(photoId: String)
        fun loadFlickrWebPage()
    }
}