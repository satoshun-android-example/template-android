package io.github.satoshun.pino.feature.detail.imageinfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(DetailImageInfoScreen::class, SingletonComponent::class)
@Composable
internal fun DetailImageInfo(
  state: DetailImageInfoState,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = state.image.url,
    )
  }
}
