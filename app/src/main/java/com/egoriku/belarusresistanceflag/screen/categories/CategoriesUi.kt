package com.egoriku.belarusresistanceflag.screen.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egoriku.belarusresistanceflag.domain.model.FlagArea
import com.egoriku.belarusresistanceflag.theme.FlagsTheme

@Composable
fun Categories(state: List<FlagArea>, onClick: (FlagArea) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        state.forEach { area ->
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable(onClick = { onClick(area) })
                        .padding(8.dp)
                ) {
                    Text(
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        text = area.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesPreview() {
    val categories = listOf(
        FlagArea.Minsk,
        FlagArea.Brest,
        FlagArea.Vitebsk,
        FlagArea.Gomel,
        FlagArea.Grodno,
        FlagArea.Mogilev,
        FlagArea.Region,
        FlagArea.Diaspora,
        FlagArea.Other
    )

    FlagsTheme {
        Categories(categories) {}
    }
}