package com.santosh.newsappmvvm.ui.articledetails

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.santosh.newsappmvvm.ui.base.BaseViewModel
import com.santosh.newsappmvvm.data.AppDataManager
import com.santosh.newsappmvvm.data.model.db.Article
import com.santosh.newsappmvvm.ui.article.ArticleDataItem
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<ArticleDetailsNavigator>(application, appDataManager) {

    private fun insertArticle(articleDataItem: ArticleDataItem) {
        viewModelScope.launch {
            appDataManager.getDbRepository().insertArticle(
                Article(
                    articleDataItem.title!!,
                    articleDataItem.author
                    , articleDataItem.imageUrl
                    , articleDataItem.title
                    , articleDataItem.publishedDate
                    , articleDataItem.content
                )
            )
        }
    }

}