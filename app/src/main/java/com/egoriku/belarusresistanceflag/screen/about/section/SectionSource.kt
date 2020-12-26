package com.egoriku.belarusresistanceflag.screen.about.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.common.ui.Badge

@Composable
fun SectionSource(onClick: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.about_screen_data_source))

        val link = stringResource(R.string.data_source_link)
        Badge(
            title = stringResource(R.string.data_source_label),
            vectorImageResId = R.drawable.ic_dze_chat,
            onClick = { onClick(link) }
        )
    }
}
