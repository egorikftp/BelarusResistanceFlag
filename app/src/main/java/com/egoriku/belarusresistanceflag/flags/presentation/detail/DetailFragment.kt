package com.egoriku.belarusresistanceflag.flags.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.egoriku.belarusresistanceflag.activity.MainViewModel
import com.egoriku.belarusresistanceflag.common.extraNotNull
import com.egoriku.belarusresistanceflag.flags.domain.model.Areas
import com.google.android.material.composethemeadapter.MdcTheme
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()

    private val currentArea by extraNotNull<Areas>("area")

    @ExperimentalFoundationApi
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
                val flags = viewModel.getByArea(area = currentArea)

                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.surface,
                            title = { Text(text = currentArea.title) }
                        )
                    }
                ) {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        cells = GridCells.Fixed(count = 2),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(flags) {
                            FlagItem(it)
                        }
                    }
                }
            }
        }
    }
}