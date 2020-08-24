package com.santosh.newsappmvvm.ui.article

import androidx.databinding.ObservableField
import com.santosh.core.ui.BaseItemListener

class ArticleItemViewModel(
    article: ArticleDataItem,
    private val onItemClick: () -> Unit
) {
    val imageUrl: ObservableField<String?> = ObservableField(article.imageUrl)
    val title: ObservableField<String?> = ObservableField(article.title)
    val author: ObservableField<String?> = ObservableField(article.author)
    val publishedDate: ObservableField<String?> = ObservableField(article.publishedDate)

    fun onItemClick() = onItemClick.invoke()

    interface ArticleItemViewModelListener : BaseItemListener<ArticleDataItem>

}