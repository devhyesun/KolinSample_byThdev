package com.devhyesun.kotlinsample.network

import com.devhyesun.kotlinsample.BuildConfig
import com.devhyesun.kotlinsample.data.PhotoInfo
import com.devhyesun.kotlinsample.data.PhotoResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FlickrServiceInterface {

    @POST("?method=flickr.photos.search&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getRecentPhotos(
            @Query("text") text: String,
            @Query("safe_search") safeSearch: Int = 1,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getPhotoDetail(
            @Query("photo_id") photoId: String
    ): Call<PhotoInfo>
}