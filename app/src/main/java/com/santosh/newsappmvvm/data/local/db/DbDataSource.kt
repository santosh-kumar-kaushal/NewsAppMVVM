package com.santosh.newsappmvvm.data.local.db

import androidx.lifecycle.LiveData
import com.santosh.newsappmvvm.data.model.db.Article

interface DbDataSource {
    suspend fun insertArticle(article: Article)
    fun allArticles(): LiveData<List<Article>>
}