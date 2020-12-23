package com.egoriku.belarusresistanceflag.common.ui

import androidx.compose.foundation.gestures.zoomable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.gesture.DragObserver
import androidx.compose.ui.gesture.doubleTapGestureFilter
import androidx.compose.ui.gesture.rawDragGestureFilter

enum class ZoomCallbackState {
    IN_PROGRESS,
    STOPPED
}

enum class ZoomState {
    DEFAULT,
    ZOOMED
}

@Composable
fun Zoomable(
    modifier: Modifier = Modifier,
    itemContent: @Composable (scale: Float, translate: Offset) -> Unit
) {
    var zoomCallbackState by remember { mutableStateOf(ZoomCallbackState.STOPPED) }
    var zoomState by remember { mutableStateOf(ZoomState.DEFAULT) }
    var scale by remember { mutableStateOf(1f) }
    var translate by remember { mutableStateOf(Offset(0f, 0f)) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .doubleTapGestureFilter {
                when (zoomState) {
                    ZoomState.DEFAULT -> {
                        zoomState = ZoomState.ZOOMED
                        scale = 3f
                    }
                    else -> {
                        zoomState = ZoomState.DEFAULT
                        scale = 1f
                        translate = Offset(0f, 0f)
                    }
                }
            }
            .zoomable(
                onZoomDelta = { scale *= it },
                onZoomStarted = {
                    zoomCallbackState = ZoomCallbackState.IN_PROGRESS
                },
                onZoomStopped = {
                    if (scale < 1f) {
                        scale = 1f
                        translate = Offset(0f, 0f)
                    }

                    if (scale > 3.5f) {
                        scale = 3.5f
                    }

                    zoomState = when (scale) {
                        1f -> ZoomState.DEFAULT
                        else -> ZoomState.ZOOMED
                    }
                    zoomCallbackState = ZoomCallbackState.STOPPED
                }
            )
            .rawDragGestureFilter(
                canStartDragging = { zoomCallbackState == ZoomCallbackState.IN_PROGRESS || scale > 1f },
                dragObserver = object : DragObserver {
                    override fun onDrag(dragDistance: Offset): Offset {
                        translate = translate.plus(dragDistance)

                        return super.onDrag(dragDistance)
                    }
                }
            )
    ) {
        itemContent(scale, translate)
    }
}