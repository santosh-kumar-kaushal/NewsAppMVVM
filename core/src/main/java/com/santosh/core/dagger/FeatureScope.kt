package com.santosh.core.dagger

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Scope for a feature module.
 */
@Scope
@Retention(RUNTIME)
annotation class FeatureScope
