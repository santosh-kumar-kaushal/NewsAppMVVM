package com.santosh.core.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflateView(@LayoutRes layout: Int): View {
    return LayoutInflater.from(this.context).inflate(layout, this, false)
}

fun View.visible() = visibility == View.VISIBLE

fun View.gone() = visibility == View.GONE

fun View.setVisibility(isVisible: Boolean) = visibility == when (isVisible) {
    true -> View.VISIBLE
    else -> View.GONE
}