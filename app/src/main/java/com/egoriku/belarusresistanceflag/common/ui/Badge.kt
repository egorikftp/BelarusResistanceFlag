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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Badge(vectorImageResId: Int, title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .clickable(onClick = { onClick() })
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