package com.santosh.core.dagger

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

/**
 * Provide [SharedPreferences] to this app's components.
 */
@Module
open class SharedPreferencesModule(val context: Context, val name: String) {

    @Provides
    @FeatureScope
    fun provideSharedPreferences(): SharedPreferences {
        return context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}
