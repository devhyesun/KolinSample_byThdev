package com.devhyesun.kotlinsample.data.source.flickr

import com.devhyesun.kotlinsample.data.PhotoResponse
import retrofit2.Call

interface FlickrDataSource {
    fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>
}