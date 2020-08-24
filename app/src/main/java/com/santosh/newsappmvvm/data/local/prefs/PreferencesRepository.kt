package com.santosh.newsappmvvm.data.local.prefs

import android.content.SharedPreferences
import com.santosh.newsappmvvm.data.local.prefs.PreferencesDataSource
import javax.inject.Inject

class PreferencesRepository @Inject constructor(private val sharedPreferences: SharedPreferences) :
        PreferencesDataSource