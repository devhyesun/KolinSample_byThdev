package com.devhyesun.kotlinsample.data.source.flickr

import com.devhyesun.kotlinsample.network.FlickrServiceInterface
import com.devhyesun.kotlinsample.network.createRetrofit

class FlickrRemoteData: FlickrDataSource {

    companion object {
        const val FLICKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = flickrServiceInterface.getFlickrRecentPhotos(text = keyword, page = page, perPage = perPage)
}