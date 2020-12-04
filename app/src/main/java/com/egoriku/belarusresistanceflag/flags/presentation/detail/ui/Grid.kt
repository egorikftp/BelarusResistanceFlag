package com.egoriku.belarusresistanceflag.flags.presentation.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.flags.domain.model.FlagModel
import com.google.android.material.composethemeadapter.MdcTheme

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    MdcTheme {
        val items = listOf(
            FlagModel("Title", "", ""),
            FlagModel("Title", "", ""),
            FlagModel("Title", "", ""),
            FlagModel("Title", "", ""),
            FlagModel("Title", "", ""),
            FlagModel("Title", "", ""),
        )

        LazyColumn(Modifier.fillMaxSize()) {
            GridView(
                items = items,
                columns = 2,
                contentPadding = PaddingValues(4.dp),
                verticalItemPadding = 2.dp,
                horizontalItemPadding = 2.dp
            ) {
                Image(
                    imageVector = vectorResource(id = R.drawable.ic_launcher_foreground),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

fun LazyListScope.spacerItem(height: Dp) {
    item {
        Spacer(Modifier.preferredHeight(height).fillParentMaxWidth())
    }
}

fun <T> LazyListScope.GridView(
    items: List<T>,
    columns: Int,
    contentPadding: PaddingValues = PaddingValues(),
    horizontalItemPadding: Dp = 0.dp,
    verticalItemPadding: Dp = 0.dp,
    itemContent: @Composable (T) -> Unit
) {
    val rows = when {
        items.size % columns == 0 -> items.size / columns
        else -> (items.size / columns) + 1
    }

    for (row in 0 until rows) {
        if (row == 0) spacerItem(contentPadding.top)

        item {
            Row(
                Modifier.fillMaxWidth()
                    .padding(start = contentPadding.start, end = contentPadding.end)
            ) {
                for (column in 0 until columns) {
                    Box(modifier = Modifier.weight(1f)) {
                        val index = (row * columns) + column
                        if (index < items.size) {
                            itemContent(items[index])
                        }
                    }
                    if (column < columns - 1) {
                        Spacer(modifier = Modifier.preferredWidth(horizontalItemPadding))
                    }
                }
            }
        }

        if (row < rows - 1) {
            spacerItem(verticalItemPadding)
        } else {
            spacerItem(contentPadding.bottom)
        }
    }
}