package com.santosh.core.dagger

import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Component(modules = [CoreDataModule::class])
@Singleton
interface CoreComponent {

    @Component.Builder interface Builder {
        fun build(): CoreComponent
    }

    fun provideOkHttpClient(): OkHttpClient
    fun provideGson(): Gson
}
