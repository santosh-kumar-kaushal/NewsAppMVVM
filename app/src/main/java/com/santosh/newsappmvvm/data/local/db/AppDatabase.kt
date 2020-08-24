package com.santosh.newsappmvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santosh.newsappmvvm.data.local.db.dao.ArticleDao
import com.santosh.newsappmvvm.data.model.db.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}