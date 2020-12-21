package com.egoriku.belarusresistanceflag.screen.about.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.R

@Composable
fun SectionAddNew(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        val addNewFlagUrl = stringResource(R.string.add_new_flag_link)

        OutlinedButton(onClick = { onClick(addNewFlagUrl) }) {
            Text(
                text = stringResource(R.string.about_screen_add_new_flag),
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
        }
    }
}