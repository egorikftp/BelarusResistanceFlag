package com.egoriku.belarusresistanceflag.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
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
                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.surface,
                            title = { Text(text = "Пра нас") }
                        )
                    }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Open source code", fontWeight = FontWeight.Bold)

                        val url = "https://github.com/egorikftp/BelarusResistanceFlag"
                        Text(
                            text = url,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .clickable(onClick = { browseUrl(url) })
                        )
                    }
                }
            }
        }
    }
}