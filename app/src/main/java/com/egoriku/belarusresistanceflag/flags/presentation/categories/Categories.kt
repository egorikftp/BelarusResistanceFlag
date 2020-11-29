package com.egoriku.belarusresistanceflag.flags.presentation.categories

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel
import com.google.android.material.composethemeadapter.MdcTheme

@Composable
fun Categories(state: Map<Areas, List<FlagModel>>, onClick: (Areas) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        state.forEach { (area, _) ->
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
    val categories = mapOf<Areas, List<FlagModel>>(
        Areas.Minsk to emptyList(),
        Areas.Brest to emptyList(),
        Areas.Vitebsk to emptyList(),
        Areas.Gomel to emptyList(),
        Areas.Grodno to emptyList(),
        Areas.Mogilev to emptyList(),
        Areas.Region to emptyList(),
        Areas.Diaspora to emptyList(),
        Areas.Other to emptyList()
    )

    MdcTheme {
        Categories(categories) {}
    }
}