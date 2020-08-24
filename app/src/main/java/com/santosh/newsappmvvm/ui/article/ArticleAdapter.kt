package com.santosh.newsappmvvm.ui.article

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.santosh.newsappmvvm.ui.article.ArticleItemViewModel.ArticleItemViewModelListener
import com.santosh.core.ui.BaseRecyclerViewAdapter
import com.santosh.core.ui.BaseViewHolder
import com.santosh.newsappmvvm.R
import com.santosh.newsappmvvm.databinding.ItemArticleViewBinding

class ArticleAdapter(items: MutableList<ArticleDataItem>, listener: ArticleItemViewModelListener) :
    BaseRecyclerViewAdapter<ArticleDataItem>(items, listener) {

    private lateinit var context: Context

    override fun getItemCount(): Int=items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context=parent.context
        return ArticleViewHolder(
            ItemArticleViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class ArticleViewHolder(private val mBinding: ItemArticleViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val article = items[position]
            mBinding.viewModel = ArticleItemViewModel(article) { itemListener.onItemClick(article) }
            val typeface = ResourcesCompat.getFont(context, R.font.bold)
            mBinding.authorTextView.setTypeface(typeface)
            mBinding.executePendingBindings()
        }
    }


}