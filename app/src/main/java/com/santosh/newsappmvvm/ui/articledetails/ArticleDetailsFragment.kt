package com.santosh.newsappmvvm.ui.articledetails

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.santosh.newsappmvvm.ui.article.ArticleDataItem
import com.santosh.newsappmvvm.AppConstants
import com.santosh.newsappmvvm.BR
import com.santosh.newsappmvvm.R
import com.santosh.newsappmvvm.ViewModelProviderFactory
import com.santosh.newsappmvvm.databinding.FragmentArticleDetailsBinding
import com.santosh.newsappmvvm.ui.MainActivity
import com.santosh.newsappmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_details.*
import javax.inject.Inject

class ArticleDetailsFragment :
    BaseFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>(),
    ArticleDetailsNavigator {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var articleDetailsViewModel: ArticleDetailsViewModel? = null
    private var articleDataItem: ArticleDataItem? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article_details

    override val viewModel: ArticleDetailsViewModel
        get() {
            articleDetailsViewModel =
                ViewModelProvider(this, factory).get(ArticleDetailsViewModel::class.java)
            return articleDetailsViewModel as ArticleDetailsViewModel
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleDetailsViewModel?.setNavigator(this)
        if (arguments != null) {
            articleDataItem = arguments?.getParcelable(AppConstants.ARTICLE)
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

        val typefaceBold = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.bold)
        titleTextView.run {
            titleTextView.run { titleTextView.typeface = typefaceBold }
        }
        val typefaceRegurlar = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.regular)
        authorTextView.run {
            authorTextView.run { authorTextView.typeface = typefaceRegurlar }
        }
        contentTextView.run {
            contentTextView.run { contentTextView.typeface = typefaceRegurlar }
        }
        dateTextView.run {
            dateTextView.run { dateTextView.typeface = typefaceRegurlar }
        }
    }

    private fun setUp() {
        setUpToolbar()
        setArticle()

    }

    private fun setArticle() {
        if (articleDataItem != null) {
            getViewDataBinding().article = articleDataItem
        }
    }

    private fun setUpToolbar() {
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
    }
}