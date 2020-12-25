package com.egoriku.belarusresistanceflag.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.egoriku.belarusresistanceflag.activity.FlagsViewModel
import com.egoriku.belarusresistanceflag.activity.RootScreen
import com.egoriku.belarusresistanceflag.domain.model.FlagArea
import com.egoriku.belarusresistanceflag.ext.extraNotNull
import com.egoriku.belarusresistanceflag.screen.DetailScreen
import com.egoriku.belarusresistanceflag.screen.flags.FlagsScreen

@Composable
fun RootNavGraph(
    viewModel: FlagsViewModel,
    onUrlClick: (String) -> Unit,
    startDestination: String = RootScreen.MainScreen.route
) {
    val navController = rememberNavController()
    val actions = remember(navController) { NavigationActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(RootScreen.MainScreen.route) {
            MainScreen(
                viewModel,
                onUrlClick = onUrlClick,
                selectArea = actions.selectFlagsArea
            )
        }
        composable(
            route = RootScreen.FlagDetails.route,
            arguments = listOf(navArgument("areaId") {
                type = NavType.EnumType(FlagArea::class.java)
            })
        ) { navBackStackEntry ->
            val area = navBackStackEntry.extraNotNull<FlagArea>("areaId")

            FlagsScreen(
                title = area.title,
                flags = viewModel.getByArea(area),
                openDetails = actions.openFlagDetail,
                upPressed = actions.upPress
            )
        }
        composable(
            route = RootScreen.FullSizeFlag.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.extraNotNull<Int>("id")

            DetailScreen(
                flagModel = viewModel.getFlagId(id),
                upPressed = actions.upPress
            )
        }
    }
}