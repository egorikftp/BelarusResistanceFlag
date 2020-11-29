package com.egoriku.belarusresistanceflag.flags.presentation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egoriku.belarusresistanceflag.MainViewModel
import com.egoriku.belarusresistanceflag.R
import com.google.android.material.composethemeadapter.MdcTheme
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoriesFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)

        setContent {
            MdcTheme {
                val state = viewModel.flow.collectAsState(emptyMap())

                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.surface,
                            title = { Text(text = "Музей сцягоў") }
                        )
                    }
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Categories(
                            state = state.value,
                            onClick = {
                                val bundle = bundleOf("area" to it)
                                findNavController().navigate(
                                    R.id.flags_by_category,
                                    bundle
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}