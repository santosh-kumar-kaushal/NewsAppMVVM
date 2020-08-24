package com.santosh.newsappmvvm.data

import com.santosh.newsappmvvm.data.remote.ApiRepository
import com.santosh.newsappmvvm.data.local.db.DbRepository
import com.santosh.newsappmvvm.data.local.prefs.PreferencesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
        private val apiRepository: ApiRepository,
        private val dbRepository: DbRepository,
        private val preferencesRepository: PreferencesRepository
) {
    fun getApiRepository(): ApiRepository {
        return apiRepository
    }

    fun getDbRepository(): DbRepository {
        return dbRepository
    }

    fun getPreferencesRepository(): PreferencesRepository {
        return preferencesRepository
    }
}