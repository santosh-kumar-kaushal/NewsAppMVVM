package com.santosh.newsappmvvm.ui.article

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.santosh.newsappmvvm.ui.base.BaseViewModel
import com.santosh.newsappmvvm.data.AppDataManager
import com.santosh.newsappmvvm.data.model.api.ArticlesResponse
import com.santosh.newsappmvvm.data.model.Result
import com.santosh.newsappmvvm.data.model.db.Article
import kotlinx.coroutines.launch

class ArticleViewModel(
    application: Application,
    appDataManager: AppDataManager
) : BaseViewModel<ArticleNavigator>(application, appDataManager) {

    private val articlesLiveData: MutableList<ArticleDataItem> = mutableListOf()

    fun fetchArticles(country: String = "us", category: String = "business") {
        viewModelScope.launch {
            setIsLoading(true)
            when (val result = appDataManager.getApiRepository().getArticles(country, category)) {
                is Result.Success<ArticlesResponse> -> {
                    result.data.articles.let { navigator?.setData(mapArticlesDataItem(it!!)) }
                    setIsLoading(false)
                }
                is Result.Error -> {
                    setIsLoading(false)
                    navigator?.handleError(result.message)
                }
            }
        }
    }

    init {
        fetchArticles("us", "business")
    }

    private fun mapArticlesDataItem(articles: List<ArticlesResponse.Article>): List<ArticleDataItem> {

        for (articleDataItem in articles) {
            val article= ArticleDataItem(
                articleDataItem.author
                , articleDataItem.urlToImage
                , articleDataItem.title
                , articleDataItem.publishedAt
                , articleDataItem.content)
            insertArticle(article)
            articlesLiveData.add(article)
        }
        return articlesLiveData
    }

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