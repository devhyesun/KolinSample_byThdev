package com.devhyesun.kotlinsample.view.main.datail.presenter

import com.devhyesun.kotlinsample.data.PhotoInfo
import com.devhyesun.kotlinsample.data.source.flickr.FlickrRepository
import com.devhyesun.kotlinsample.util.decimalFormat
import com.devhyesun.kotlinsample.util.getDate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailImagePresenter(val view: DetailImageContract.View,
                           private val repository: FlickrRepository): DetailImageContract.Presenter {

    override fun loadDetailInfo(photoId: String) {
        repository.getPhotoDetail(photoId)
                .enqueue(object : Callback<PhotoInfo> {
                    override fun onFailure(call: Call<PhotoInfo>, t: Throwable) {
                    }

                    override fun onResponse(call: Call<PhotoInfo>, response: Response<PhotoInfo>) {
                        if(response?.isSuccessful) {
                            response.body()?.takeIf { it.stat == "ok" }?.let {
                                it.photo.let {
                                    view.updateItem(
                                            it.getImageUrl(),
                                            it.title._content,
                                            it.description._content,
                                            it.dates.lastupdate.getDate("MM-dd-yyyy hh:mm:ss"),
                                            it.views.toString().decimalFormat(),
                                            it.comments._content.toString().decimalFormat())

                                    view.updateToolbarItem(
                                            it.owner.getBuddyIcons(),
                                            it.owner.username
                                    )
                                }
                            }
                        }
                    }
                })
    }
}