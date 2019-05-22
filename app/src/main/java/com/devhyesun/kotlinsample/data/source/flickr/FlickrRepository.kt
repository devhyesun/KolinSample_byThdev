package com.devhyesun.kotlinsample.data.source.flickr

import com.devhyesun.kotlinsample.data.PhotoInfo
import retrofit2.Call

object FlickrRepository: FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()
    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int) = flickrRemoteData.getSearchPhoto(keyword, page, perPage)
    override fun getPhotoDetail(photoId: String): Call<PhotoInfo> = flickrRemoteData.getPhotoDetail(photoId)
}