package io.github.satoshun.example.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(HomeScreen::class, SingletonComponent::class)
@Composable
internal fun Home(
  state: HomeState,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(title = {
        Text(text = "Sample ${state.count}")
      })
    },
  ) { paddingValues ->
    if (state.images.isEmpty()) {
    } else {
      Images(
        images = state.images,
        contentPadding = paddingValues,
        onImageClick = {
          state.eventSink(HomeEvent.GoToNext)
        },
      )
    }
  }
}

@Composable
private fun Images(
  images: List<Image>,
  contentPadding: PaddingValues,
  onImageClick: (Image) -> Unit,
) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(3),
    modifier = Modifier.fillMaxSize(),
    contentPadding = contentPadding,
  ) {
    items(images, key = { it.url }) {
      AsyncImage(
        modifier = Modifier
          .height(120.dp)
          .clickable { onImageClick(it) },
        model = it.url,
        contentScale = ContentScale.Crop,
        contentDescription = null,
      )
    }
  }
}
