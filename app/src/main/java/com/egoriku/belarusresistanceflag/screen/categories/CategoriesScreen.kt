package com.egoriku.belarusresistanceflag.screen.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.egoriku.belarusresistanceflag.R
import com.egoriku.belarusresistanceflag.activity.CategoriesState
import com.egoriku.belarusresistanceflag.domain.model.FlagArea

@Composable
fun CategoriesScreen(
    selectArea: (FlagArea) -> Unit,
    categoriesState: CategoriesState,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        when (categoriesState) {
            is CategoriesState.Loading -> CircularProgressIndicator(color = MaterialTheme.colors.error)
            is CategoriesState.Success -> {
                Categories(
                    state = categoriesState.categories,
                    onClick = selectArea
                )
            }
            is CategoriesState.Error -> {
                Text(text = stringResource(R.string.categories_loading_error))
            }
        }
    }
}
