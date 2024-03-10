package io.github.satoshun.pino.feature.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun Main(
  parentState: HomeState,
  mainState: HomeTabState.MainState,
  paddingValues: PaddingValues,
) {
  val transition = updateTransition(mainState, label = "isLoading")
  transition.AnimatedContent { state ->
    when (state) {
      is HomeTabState.MainState.Loading -> {
        Box(
          modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
          contentAlignment = Alignment.Center,
        ) {
          CircularProgressIndicator()
        }
      }
      is HomeTabState.MainState.Success -> {
        Images(
          images = state.images,
          contentPadding = paddingValues,
          onImageClick = {
            parentState.eventSink(HomeEvent.GoToImageDetail(it))
          },
        )
      }
    }
  }
}
