package com.devhyesun.kotlinsample.util

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: Fragment, tag: String? = null) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)

fun String.decimalFormat() = DecimalFormat("#,###").format(this.toLong())

fun String.getDate(dateFormat: String): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@getDate.toLong() * 1000
    }

    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(calendar.time)
}