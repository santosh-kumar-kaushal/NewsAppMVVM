package com.santosh.newsappmvvm.data.local.db

import androidx.lifecycle.LiveData
import com.santosh.newsappmvvm.data.model.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbRepository @Inject constructor(private val mAppDatabase: AppDatabase) : DbDataSource {

    override suspend fun insertArticle(article: Article) = mAppDatabase.articleDao().insert(article)

    override fun allArticles(): LiveData<List<Article>> {
        return mAppDatabase.articleDao().loadAll()
    }

}