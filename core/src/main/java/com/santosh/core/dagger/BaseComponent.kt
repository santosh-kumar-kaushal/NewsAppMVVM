package com.santosh.core.dagger

import android.app.Activity
import androidx.fragment.app.Fragment

interface BaseComponent<T> {

    fun inject(target: T)
}

/**
 * Base dagger component for use in activities.
 */
interface BaseActivityComponent<T : Activity> : BaseComponent<T>

/**
 * Base dagger components for use in fragment.
 */
interface BaseFragmentComponent<T : Fragment> : BaseComponent<T>
