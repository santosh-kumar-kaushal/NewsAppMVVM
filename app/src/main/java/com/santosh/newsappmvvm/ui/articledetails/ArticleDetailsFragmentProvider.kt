package com.santosh.newsappmvvm.ui.articledetails

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleDetailsFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleDetailsFragmentFactory(): ArticleDetailsFragment
}