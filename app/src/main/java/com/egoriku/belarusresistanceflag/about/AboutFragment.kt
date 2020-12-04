package com.egoriku.belarusresistanceflag.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.egoriku.belarusresistanceflag.BuildConfig
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.common.browseUrl
import com.google.android.material.composethemeadapter.MdcTheme

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
            val projectUrl = "https://dze.chat/"

            Text(text = "Дадзеныя ўзятыя з праекта")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
                    .clickable(onClick = { click(projectUrl) })
            ) {
                Image(
                    bitmap = imageResource(id = R.drawable.ic_dze_chat),
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "dze.chat",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Composable
    fun SectionAddNew(modifier: Modifier = Modifier, click: (String) -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
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
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Зыходны код:", fontWeight = FontWeight.Bold)
            val githubUrl = "https://github.com/egorikftp/BelarusResistanceFlag"
            Text(
                text = githubUrl,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable(onClick = { click(githubUrl) })
            )
            Row(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = "Версія праграмы:"
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = BuildConfig.VERSION_NAME
                )
            }
        }
    }

    @Preview
    @Composable
    fun PreviewAboutScreen() {
        AboutScreen {}
    }
}