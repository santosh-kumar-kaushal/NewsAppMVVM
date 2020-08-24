package com.santosh.newsappmvvm.data.remote

import com.santosh.newsappmvvm.dagger.ApiInfo
import com.santosh.newsappmvvm.data.model.Result
import com.santosh.newsappmvvm.data.model.api.ArticlesResponse
import com.santosh.newsappmvvm.data.remote.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(
        private val apiService: ApiService,
        @param:ApiInfo private val apiKey: String
) : ApiDataSource {

    override suspend fun getArticles(country: String,category: String): Result<ArticlesResponse> {
        return try {
            val articlesResponse = apiService.getArticles(country,category,apiKey)
            Result.Success(articlesResponse)
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}