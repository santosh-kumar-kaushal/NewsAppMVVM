package com.santosh.newsappmvvm.data.remote.network

import com.santosh.newsappmvvm.data.model.api.ArticlesResponse
import com.santosh.newsappmvvm.data.remote.network.ApiEndPoint
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_ARTICLES)
    suspend fun getArticles(@Query("country") country: String, @Query("category") category: String, @Query("apiKey") apiKey: String): ArticlesResponse
}