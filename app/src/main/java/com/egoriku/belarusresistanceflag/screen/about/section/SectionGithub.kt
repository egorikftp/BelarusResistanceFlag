package com.egoriku.belarusresistanceflag.screen.about.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.egoriku.belarusresistanceflag.BuildConfig
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.common.ui.Badge
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun SectionGithub(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.about_screen_source_code),
                fontWeight = FontWeight.Bold
            )
            val link = stringResource(R.string.github_source_link)
            Badge(
                onClick = { onClick(link) },
                vectorImageResId = R.drawable.ic_github,
                title = stringResource(R.string.about_screen_github_label)
            )
        }

        Row {
            Text(
                fontWeight = FontWeight.Bold,
                text = stringResource(R.string.about_screen_app_version)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = BuildConfig.VERSION_NAME
            )
        }

        CoilImage(
            data = R.drawable.ic_logo,
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.CenterHorizontally)
                .size(100.dp)
                .shadow(3.dp, shape = CircleShape)
                .background(color = Color.White, shape = CircleShape)
        )
    }
}