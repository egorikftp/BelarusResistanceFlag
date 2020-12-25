package com.egoriku.belarusresistanceflag.ext

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.topBottomShadow(colors: List<Color>): Modifier = drawWithContent {
    drawRect(Brush.verticalGradient(colors))
    drawContent()
}

fun Modifier.bottomTopShadow(colors: List<Color>): Modifier = drawWithContent {
    drawRect(
        Brush.verticalGradient(
            colors = colors,
            startY = Float.POSITIVE_INFINITY,
            endY = 0.0f
        )
    )
    drawContent()
}
