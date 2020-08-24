package com.santosh.newsappmvvm.ui.article

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleFragmentFactory(): ArticleFragment
}