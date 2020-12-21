package com.egoriku.belarusresistanceflag.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightColors = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Color.Black,
    secondary = Color.Red,
    background = Color.White,
    surface = Color.White,
    onSurface = Color.Black
)

private val darkColors = darkColors(
    primary = Color(0xFFE5E1DD),
    primaryVariant = Color(0xFFE5E1DD),
    onPrimary = Color.Black,
    secondary = Color.Red,
    background = Color(0xFF272D33),
    surface = Color(0xFF272D33),
    onSurface = Color(0xFFE5E1DD),
)

@Composable
fun FlagsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> darkColors
        else -> lightColors
    }

    MaterialTheme(colors = colors, content = content)
}