package com.egoriku.belarusresistanceflag.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.egoriku.belarusresistanceflag.activity.FlagsViewModel
import com.egoriku.belarusresistanceflag.activity.RootScreen
import com.egoriku.belarusresistanceflag.domain.model.Areas
import com.egoriku.belarusresistanceflag.ext.extraNotNull
import com.egoriku.belarusresistanceflag.screen.flags.FlagsScreen

@Composable
fun RootNavGraph(
    viewModel: FlagsViewModel,
    onUrlClick: (String) -> Unit,
    startDestination: String = RootScreen.MainScreen.route
) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

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
                type = NavType.EnumType(Areas::class.java)
            })
        ) { navBackStackEntry ->
            val area = navBackStackEntry.extraNotNull<Areas>("areaId")

            FlagsScreen(
                title = area.title,
                flags = viewModel.getByArea(area),
                upPressed = actions.upPress
            )
        }
    }
}

class MainActions(navController: NavHostController) {

    val selectFlagsArea: (Areas) -> Unit = { area: Areas ->
        navController.navigate(
            RootScreen.FlagDetails.route.replace("{areaId}", area.name)
        )
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}