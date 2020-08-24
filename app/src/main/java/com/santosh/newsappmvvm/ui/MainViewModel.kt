package com.santosh.newsappmvvm.ui

import android.app.Application
import com.santosh.newsappmvvm.data.AppDataManager
import com.santosh.newsappmvvm.ui.base.BaseViewModel


class MainViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<Any>(application, appDataManager)