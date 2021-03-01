package com.egoriku.belarusresistanceflag.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.egoriku.belarusresistanceflag.ext.browseUrl
import com.egoriku.belarusresistanceflag.screen.main.RootNavGraph
import com.egoriku.belarusresistanceflag.theme.FlagsTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val viewModel = getViewModel<FlagsViewModel>()
        setContent {
            FlagsTheme {
                ProvideWindowInsets {
                    RootNavGraph(
                        viewModel = viewModel,
                        onUrlClick = { browseUrl(it) }
                    )
                }
            }
        }
    }
}