package com.santosh.newsappmvvm.dagger


import com.santosh.newsappmvvm.ui.MainActivity
import com.santosh.newsappmvvm.ui.article.ArticleFragmentProvider
import com.santosh.newsappmvvm.ui.articledetails.ArticleDetailsFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}