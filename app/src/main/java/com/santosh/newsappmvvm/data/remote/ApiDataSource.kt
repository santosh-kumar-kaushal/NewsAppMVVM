package com.santosh.newsappmvvm.data.remote

import com.santosh.newsappmvvm.data.model.Result
import com.santosh.newsappmvvm.data.model.api.ArticlesResponse

interface ApiDataSource {
    suspend fun getArticles(country: String,category: String): Result<ArticlesResponse>
}