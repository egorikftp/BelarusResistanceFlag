package com.egoriku.belarusresistanceflag.activity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.egoriku.belarusresistanceflag.R

sealed class RootScreen(val route: String) {

    object FlagDetails : RootScreen(
        route = "flags/{areaId}"
    )

    object MainScreen : RootScreen(
        route = "main"
    )
}

sealed class BottomNavScreen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableResId: Int,
) {

    object Categories : BottomNavScreen(
        route = "flags",
        resourceId = R.string.navigation_menu_flags,
        drawableResId = R.drawable.ic_flag
    )

    object About : BottomNavScreen(
        route = "about",
        resourceId = R.string.navigation_menu_about,
        drawableResId = R.drawable.ic_arch
    )
}