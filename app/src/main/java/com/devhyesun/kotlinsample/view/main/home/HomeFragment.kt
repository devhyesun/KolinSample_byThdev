package com.devhyesun.kotlinsample.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devhyesun.kotlinsample.R
import com.devhyesun.kotlinsample.data.source.flickr.FlickrRepository
import com.devhyesun.kotlinsample.view.main.datail.DetailImageBottomSheet
import com.devhyesun.kotlinsample.view.main.home.adapter.ImageRecyclerAdapter
import com.devhyesun.kotlinsample.view.main.home.presenter.HomeContract
import com.devhyesun.kotlinsample.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {
    private val homePresenter by lazy {
        HomePresenter(this@HomeFragment, FlickrRepository, imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@HomeFragment.context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadFlickrImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun showBottomSheetDialog(photoId: String) {
        if(isDetached) return

        DetailImageBottomSheet.create(photoId).show(activity?.supportFragmentManager, "DetailImageBottomSheet")
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showLoadFail() {
        if(isDetached) return
            Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail(message: String) {
        if(isDetached) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView.childCount
            val totalItemCount = imageRecyclerAdapter.itemCount
            var firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if(!homePresenter.isLoading && (firstVisibleItem + visibleItemCount >= totalItemCount - 7)) {
                homePresenter.loadFlickrImage()
            }
        }
    }
}