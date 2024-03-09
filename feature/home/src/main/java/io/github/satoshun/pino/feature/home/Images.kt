package io.github.satoshun.pino.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import io.github.satoshun.pino.share.data.Image

@Composable
internal fun Images(
  images: List<Image>,
  contentPadding: PaddingValues,
  onImageClick: (Image) -> Unit,
) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    modifier = Modifier.fillMaxSize(),
    contentPadding = contentPadding,
  ) {
    items(images, key = { it.url }) {
      AsyncImage(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(1f)
          .clickable { onImageClick(it) },
        model = it.url,
        contentScale = ContentScale.Crop,
        contentDescription = null,
      )
    }
  }
}
