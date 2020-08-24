package com.santosh.newsappmvvm.ui

import androidx.lifecycle.ViewModelProvider
import com.santosh.newsappmvvm.BR
import com.santosh.newsappmvvm.R
import com.santosh.newsappmvvm.ViewModelProviderFactory
import com.santosh.newsappmvvm.databinding.ActivityMainBinding
import com.santosh.newsappmvvm.ui.base.BaseActivity
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
        HasAndroidInjector {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory).get(MainViewModel::class.java)
}
