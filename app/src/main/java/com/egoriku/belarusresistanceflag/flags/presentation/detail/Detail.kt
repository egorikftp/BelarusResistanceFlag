package com.egoriku.belarusresistanceflag.flags.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun FlagItem(model: FlagModel) {
    Card(elevation = 4.dp) {
        Column(
            modifier = Modifier
                .clickable(onClick = {})
        ) {
            CoilImage(
                data = model.thumbnailUrl,
                modifier = Modifier
                    .aspectRatio(1.6f)
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Text(
                text = model.title,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun FlagItemPreview() {
    FlagItem(
        model = FlagModel(
            title = "Item Title",
            thumbnailUrl = "",
            imageUrl = ""
        )
    )
}