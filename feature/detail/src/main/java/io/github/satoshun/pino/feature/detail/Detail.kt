package io.github.satoshun.pino.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(DetailScreen::class, SingletonComponent::class)
@Composable
internal fun Detail(
  state: DetailState,
  modifier: Modifier = Modifier,
) {
  Scaffold(modifier) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues),
      contentAlignment = Alignment.Center,
    ) {
      AsyncImage(
        modifier = Modifier.fillMaxWidth(),
        model = state.image.url,
        contentScale = ContentScale.Crop,
        contentDescription = null,
      )
    }
  }
}
