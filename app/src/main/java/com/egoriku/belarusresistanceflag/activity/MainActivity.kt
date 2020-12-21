package com.egoriku.belarusresistanceflag.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.setContent
import com.egoriku.belarusresistanceflag.ext.browseUrl
import com.egoriku.belarusresistanceflag.screen.main.RootNavGraph
import com.egoriku.belarusresistanceflag.theme.FlagsTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = getViewModel<FlagsViewModel>()
        setContent {
            FlagsTheme {
                RootNavGraph(
                    viewModel = viewModel,
                    onUrlClick = { browseUrl(it) }
                )
            }
        }
    }
}