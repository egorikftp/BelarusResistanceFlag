package com.egoriku.belarusresistanceflag.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.*
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.activity.BottomNavScreen
import com.egoriku.belarusresistanceflag.activity.FlagsViewModel
import com.egoriku.belarusresistanceflag.domain.model.FlagArea
import com.egoriku.belarusresistanceflag.ext.EMPTY
import com.egoriku.belarusresistanceflag.screen.about.AboutScreen
import com.egoriku.belarusresistanceflag.screen.categories.CategoriesScreen
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun MainScreen(
    viewModel: FlagsViewModel,
    onUrlClick: (String) -> Unit,
    selectArea: (FlagArea) -> Unit
) {
    val navigationItems = listOf(BottomNavScreen.Categories, BottomNavScreen.About)
    val navController = rememberNavController()
    val current: NavBackStackEntry? by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    val entry = current ?: return@TopAppBar

                    val title = when (entry.arguments?.getString(KEY_ROUTE)) {
                        BottomNavScreen.Categories.route -> stringResource(R.string.header_categories_screen)
                        BottomNavScreen.About.route -> stringResource(R.string.header_about_screen)
                        else -> EMPTY
                    }

                    Text(text = title)
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

                navigationItems.forEach { screen ->
                    BottomNavigationItem(
                        selectedContentColor = MaterialTheme.colors.error,
                        unselectedContentColor = MaterialTheme.colors.onSurface,
                        icon = { Icon(screen.imageVector) },
                        label = { Text(stringResource(screen.resourceId)) },
                        alwaysShowLabels = false,
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = BottomNavScreen.Categories.route) {
            composable(BottomNavScreen.Categories.route) {
                val categoriesState by viewModel.categoriesFlow.collectAsState()

                CategoriesScreen(
                    categoriesState = categoriesState,
                    modifier = Modifier.padding(innerPadding),
                    selectArea = selectArea
                )
            }
            composable(BottomNavScreen.About.route) {
                AboutScreen(
                    modifier = Modifier.padding(innerPadding),
                    onUrlClick = { onUrlClick(it) })
            }
        }
    }
}