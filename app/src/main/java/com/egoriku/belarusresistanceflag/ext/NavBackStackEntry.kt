package com.egoriku.belarusresistanceflag.ext

import androidx.navigation.NavBackStackEntry

inline fun <reified T : Any> NavBackStackEntry.extraNotNull(key: String, default: T? = null): T {
    val value = arguments?.get(key)

    return requireNotNull(if (value is T) value else default) { key }
}