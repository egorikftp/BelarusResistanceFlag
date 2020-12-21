package com.egoriku.belarusresistanceflag.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.ext.EMPTY

@Composable
fun Badge(click: () -> Unit, imageResId: Int, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .clickable(onClick = { click() })
    ) {
        Image(
            bitmap = imageResource(id = imageResId),
            modifier = Modifier.size(50.dp)
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BadgeVector(click: () -> Unit = {}, vectorImageResId: Int, title: String = EMPTY) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .clickable(onClick = { click() })
    ) {
        Image(
            imageVector = vectorResource(id = vectorImageResId),
            modifier = Modifier
                .size(50.dp)
                .padding(4.dp)
        )
        Text(
            modifier = Modifier.padding(4.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}