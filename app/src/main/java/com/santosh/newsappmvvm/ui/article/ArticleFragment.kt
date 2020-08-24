package com.santosh.newsappmvvm.ui.article

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.santosh.newsappmvvm.ui.article.ArticleItemViewModel.ArticleItemViewModelListener
import com.santosh.newsappmvvm.AppConstants
import com.santosh.newsappmvvm.BR
import com.santosh.newsappmvvm.R
import com.santosh.newsappmvvm.ViewModelProviderFactory
import com.santosh.newsappmvvm.databinding.FragmentArticleBinding
import com.santosh.newsappmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article.*
import javax.inject.Inject

class ArticleFragment : BaseFragment<FragmentArticleBinding, ArticleViewModel>(),
    ArticleNavigator, ArticleItemViewModelListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    lateinit var articleAdapter: ArticleAdapter
    private var articleViewModel: ArticleViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article

    override val viewModel: ArticleViewModel
        get() {
            articleViewModel = ViewModelProvider(this, factory).get(ArticleViewModel::class.java)
            return articleViewModel as ArticleViewModel
        }

    override fun onRetryClick() {
        articleViewModel?.fetchArticles("us","business")
    }

    override fun onItemClick(item: ArticleDataItem) {
        val bundle = Bundle()
        bundle.putParcelable(
            AppConstants.ARTICLE,
            item
        )
        getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle)
    }

    override fun handleError(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun setData(data: List<ArticleDataItem>) {
        articleAdapter.addItems(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleViewModel?.setNavigator(this)
        viewModel.fetchArticles("us","business")
        articleAdapter = ArticleAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        setHasOptionsMenu(false)
        val typeface = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.regular)
        toolbar_title.run {
            toolbar_title.run { toolbar_title.typeface = typeface }
        }
    }

    private fun setUp() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().resultsBeanRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().resultsBeanRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().resultsBeanRecyclerView.adapter = articleAdapter
    }

}