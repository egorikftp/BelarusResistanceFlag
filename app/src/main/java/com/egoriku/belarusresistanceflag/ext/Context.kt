package com.egoriku.belarusresistanceflag.ext

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

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