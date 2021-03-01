package com.egoriku.belarusresistanceflag.component.foundation

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.egoriku.belarusresistanceflag.R
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun NetworkImage(
    data: Any,
    modifier: Modifier = Modifier,
    fadeIn: Boolean = false,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String = stringResource(id = R.string.accessibility_common_network_image),
    loading: @Composable (BoxScope.() -> Unit)? = null
) {
    CoilImage(
        data = data,
        modifier = modifier
    ) { imageState ->
        when (imageState) {
            is ImageLoadState.Success -> {
                MaterialLoadingImage(
                    result = imageState,
                    contentDescription = contentDescription,
                    fadeInEnabled = fadeIn,
                    contentScale = contentScale,
                )
            }
            is ImageLoadState.Loading -> if (loading != null) loading()
            is ImageLoadState.Empty -> Unit
            is ImageLoadState.Error -> Unit
        }
    }
}

