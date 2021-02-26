package com.egoriku.belarusresistanceflag.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.common.ui.Zoomable
import com.egoriku.belarusresistanceflag.domain.model.Download
import com.egoriku.belarusresistanceflag.domain.model.FlagModel
import com.egoriku.belarusresistanceflag.ext.bottomTopShadow
import com.egoriku.belarusresistanceflag.ext.topBottomShadow
import com.egoriku.belarusresistanceflag.theme.DetailsTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun DetailScreen(
    flagModel: FlagModel,
    upPressed: () -> Unit
) {
    DetailsTheme {
        Scaffold {
            Box {
                ZoomableImage(flagModel = flagModel)

                TopAppBar(flagModel = flagModel, upPressed = upPressed)
                /*BottomActions(
                    flagModel = flagModel,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onDownloadClick = {},
                    onShareClick = {}
                )*/
            }
        }
    }
}

@Composable
private fun ZoomableImage(flagModel: FlagModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Zoomable(
            modifier = Modifier.fillMaxSize()
        ) { scale, translate ->
            CoilImage(
                data = flagModel.imageUrl,
                contentDescription = null,
                loading = {
                    Box(modifier = Modifier.fillMaxHeight()) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colors.error,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                        translationY = translate.y,
                        translationX = translate.x
                    )
            )
        }
    }
}

@Composable
private fun TopAppBar(
    flagModel: FlagModel,
    upPressed: () -> Unit
) {
    Box(
        modifier = Modifier
            .statusBarsHeight(100.dp)
            .fillMaxWidth()
            .topBottomShadow(
                colors = listOf(
                    Color.Black.copy(alpha = 0.3f),
                    Color.Transparent
                )
            )
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .preferredHeight(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = upPressed) {
                Icon(
                    contentDescription = null,
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
}

@Composable
private fun BottomActions(
    modifier: Modifier = Modifier,
    flagModel: FlagModel,
    onDownloadClick: (FlagModel) -> Unit,
    onShareClick: (FlagModel) -> Unit,
) {
    Box(
        modifier = modifier
            .navigationBarsHeight(100.dp)
            .fillMaxWidth()
            .bottomTopShadow(colors = listOf(Color.Black.copy(alpha = 0.3f), Color.Transparent))
    ) {
        when (val download = flagModel.download) {
            is Download.NotAvailable -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ActionShare(
                        onShareClick = onShareClick,
                        flagModel = flagModel
                    )
                }
            }
            is Download.Available -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        elevation = null,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        onClick = { onDownloadClick(flagModel) }
                    ) {
                        Icon(
                            contentDescription = null,
                            imageVector = Icons.Filled.SaveAlt,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = stringResource(
                                id = R.string.details_action_download,
                                download.format
                            )
                        )
                    }

                    ActionShare(
                        onShareClick = onShareClick,
                        flagModel = flagModel
                    )
                }
            }
        }
    }
}

@Composable
private fun ActionShare(
    onShareClick: (FlagModel) -> Unit,
    flagModel: FlagModel
) {
    Button(
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        onClick = { onShareClick(flagModel) }
    ) {
        Icon(
            contentDescription = null,
            imageVector = Icons.Filled.Share,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = stringResource(R.string.details_action_share))
    }
}