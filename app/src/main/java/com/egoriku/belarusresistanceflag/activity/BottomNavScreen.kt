package com.egoriku.belarusresistanceflag.activity

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Flag
import androidx.compose.ui.graphics.vector.ImageVector
import com.egoriku.belarusresistanceflag.R

sealed class RootScreen(val route: String) {

    object FlagDetails : RootScreen(
        route = "flags/{areaId}"
    )

    object MainScreen : RootScreen(
        route = "main"
    )

    object FullSizeFlag : RootScreen(
        route = "fullSizeFlag/{id}",
    )
}

sealed class BottomNavScreen(
    val route: String,
    @StringRes val resourceId: Int,
    val imageVector: ImageVector,
) {

    object Categories : BottomNavScreen(
        route = "flags",
        resourceId = R.string.navigation_menu_flags,
        imageVector = Icons.Filled.Flag
    )

    object About : BottomNavScreen(
        route = "about",
        resourceId = R.string.navigation_menu_about,
        imageVector = Icons.Filled.Architecture
    )
}