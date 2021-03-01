package com.egoriku.belarusresistanceflag.screen.about

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.screen.about.section.SectionAddNew
import com.egoriku.belarusresistanceflag.screen.about.section.SectionGithub
import com.egoriku.belarusresistanceflag.screen.about.section.SectionSource

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    onUrlClick: (String) -> Unit
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        item {
            SectionSource(onClick = onUrlClick)
        }
        item {
            SectionAddNew(
                modifier = Modifier.padding(top = 16.dp, bottom = 32.dp),
                onClick = onUrlClick
            )
        }
        item {
            SectionGithub(onClick = onUrlClick)
        }
    }
}

@Preview
@Composable
fun PreviewAboutScreen() {
    AboutScreen {}
}