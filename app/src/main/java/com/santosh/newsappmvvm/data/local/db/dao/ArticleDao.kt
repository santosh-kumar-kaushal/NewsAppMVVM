package com.santosh.newsappmvvm.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.santosh.newsappmvvm.data.model.db.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articles")
    fun loadAll(): LiveData<List<Article>>
}