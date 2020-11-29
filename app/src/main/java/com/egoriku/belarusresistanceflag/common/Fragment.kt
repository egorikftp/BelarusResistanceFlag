package com.egoriku.belarusresistanceflag.common

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

inline fun <reified T : Any> Fragment.extraNotNull(key: String, default: T? = null) = lazy {
    val value = arguments?.get(key)
    requireNotNull(if (value is T) value else default) { key }
}

fun Fragment.browseUrl(url: String, newTask: Boolean = false): Boolean =
    requireContext().browseUrl(url, newTask)

fun Context.browseUrl(url: String, newTask: Boolean = false): Boolean = try {
    startActivity(Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)

        if (newTask) {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    })
    true
} catch (e: ActivityNotFoundException) {
    e.printStackTrace()
    false
}