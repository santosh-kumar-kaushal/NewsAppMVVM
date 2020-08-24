package com.santosh.newsappmvvm.dagger

import android.app.Application
import com.santosh.newsappmvvm.NewsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppDataModule::class, ActivityBuilder::class])
interface ApplicationComponent {
    fun inject(app: NewsApplication)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}