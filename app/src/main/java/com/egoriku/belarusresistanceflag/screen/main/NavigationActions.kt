package com.egoriku.belarusresistanceflag.screen.main

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.egoriku.belarusresistanceflag.activity.RootScreen
import com.egoriku.belarusresistanceflag.domain.model.FlagArea

class NavigationActions(navController: NavHostController) {

    val selectFlagsArea: (FlagArea) -> Unit = { area ->
        navController.navigate(
            RootScreen.FlagDetails.route.replace("{areaId}", area.name)
        )
    }

    val openFlagDetail: (Int) -> Unit = { id ->
        navController.navigate(
            RootScreen.FullSizeFlag.route.replace("{id}", id.toString())
        )
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}