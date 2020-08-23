package com.santosh.core.ui

interface BaseNavigator<T> {
    fun handleError(message: String?)
    fun setData(data: T)
}