package com.santosh.newsappmvvm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.santosh.newsappmvvm.ui.article.ArticleViewModel
import com.santosh.newsappmvvm.ui.articledetails.ArticleDetailsViewModel
import com.santosh.newsappmvvm.ui.MainViewModel
import com.santosh.newsappmvvm.data.AppDataManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val application: Application,
    private val appDataManager: AppDataManager
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(application, appDataManager) as T
            }
            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                ArticleDetailsViewModel(application, appDataManager) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}