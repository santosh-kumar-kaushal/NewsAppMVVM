package com.santosh.core.ui

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.santosh.core.data.AppDataManager
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val application: Application,
    val appDataManager: AppDataManager
) : ViewModel() {
    private val isLoading = ObservableBoolean()
    private var mNavigator: WeakReference<N>? = null

    fun setIsLoading(b: Boolean) {
        isLoading.set(b)
    }

    val navigator: N?
        get() = mNavigator?.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

}