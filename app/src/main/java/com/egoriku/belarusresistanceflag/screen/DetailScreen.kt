package com.egoriku.belarusresistanceflag.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.theme.DetailsTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailScreen(
    flagModel: FlagModel,
    upPressed: () -> Unit
) {
    DetailsTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    Row(
                        modifier = Modifier.fillMaxHeight().weight(1f),
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
                            text = flagModel.title,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                CoilImage(
                    loading = {
                        Box(modifier = Modifier.fillMaxHeight()) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colors.error,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    },
                    data = flagModel.imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}