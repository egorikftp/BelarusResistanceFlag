package com.egoriku.belarusresistanceflag.screen.flags

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.domain.model.FlagModel
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FlagsScreen(
    title: String,
    flags: List<FlagModel>,
    openDetails: (Int) -> Unit,
    upPressed: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column {
            TopAppBar {
                Row(
                    Modifier.fillMaxHeight().weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = upPressed) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            modifier = Modifier.align(Alignment.CenterVertically),
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = title,
                        style = MaterialTheme.typography.h6
                    )
                }
            }

            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                cells = GridCells.Fixed(count = 2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(flags) {
                    FlagItem(model = it, openDetails = openDetails)
                }
                item {
                    Spacer(modifier = Modifier.navigationBarsHeight())
                }
            }
        }
    }
}