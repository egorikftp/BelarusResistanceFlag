package com.egoriku.belarusresistanceflag.common.ui

import androidx.compose.foundation.gestures.zoomable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.gesture.DragObserver
import androidx.compose.ui.gesture.rawDragGestureFilter

enum class ZoomState {
    IN_PROGRESS,
    STOPPED
}

@Composable
fun Zoomable(
    modifier: Modifier = Modifier,
    itemContent: @Composable (scale: Float, translate: Offset) -> Unit
) {
    var zoomState by remember { mutableStateOf(ZoomState.STOPPED) }
    var scale by remember { mutableStateOf(1f) }
    var translate by remember { mutableStateOf(Offset(0f, 0f)) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .zoomable(
                onZoomDelta = { scale *= it },
                onZoomStarted = {
                    zoomState = ZoomState.IN_PROGRESS
                },
                onZoomStopped = {
                    if (scale < 1f) {
                        scale = 1f
                        translate = Offset(0f, 0f)
                    }

                    if (scale > 3.5f) {
                        scale = 3.5f
                    }

                    zoomState = ZoomState.STOPPED
                }
            )
            .rawDragGestureFilter(
                canStartDragging = { zoomState == ZoomState.IN_PROGRESS || scale > 1f },
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