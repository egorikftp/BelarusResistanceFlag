package com.egoriku.belarusresistanceflag.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.egoriku.belarusresistanceflag.BuildConfig
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.common.browseUrl
import com.egoriku.belarusresistanceflag.common.ui.Badge
import com.egoriku.belarusresistanceflag.common.ui.Badge2
import com.google.android.material.composethemeadapter.MdcTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        setContent {
            MdcTheme {
                AboutScreen(
                    onUrlClick = {
                        browseUrl(it)
                    }
                )
            }
        }
    }

    @Composable
    fun AboutScreen(onUrlClick: (String) -> Unit) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.surface,
                    title = { Text(text = "Пра нас") }
                )
            }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                SectionSource(click = onUrlClick)
                SectionAddNew(
                    modifier = Modifier.padding(top = 16.dp, bottom = 32.dp),
                    click = onUrlClick
                )
                SectionGithub(click = onUrlClick)
            }
        }
    }

    @Composable
    fun SectionSource(click: (String) -> Unit) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Дадзеныя ўзятыя з праекта")

            Badge(
                click = { click("https://dze.chat/") },
                title = "dze.chat",
                imageResId = R.drawable.ic_dze_chat
            )
        }
    }

    @Composable
    fun SectionAddNew(modifier: Modifier = Modifier, click: (String) -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            val addNewFlagUrl = "https://t.me/dzechat_bot"

            OutlinedButton(onClick = { click(addNewFlagUrl) }) {
                Text(
                    text = "Дадаць новы сцяг",
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }

    @Composable
    fun SectionGithub(click: (String) -> Unit) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Зыходны код:", fontWeight = FontWeight.Bold)
                Badge2(
                    click = { click("https://github.com/egorikftp/BelarusResistanceFlag") },
                    vectorImageResId = R.drawable.ic_github,
                    title = "Follow Github"
                )
            }

            Row {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = "Версія праграмы:"
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
                    .size(150.dp)
                    .shadow(3.dp, shape = CircleShape)
                    .background(color = Color.White, shape = CircleShape)
            )
        }
    }

    @Preview
    @Composable
    fun PreviewAboutScreen() {
        AboutScreen {}
    }
}