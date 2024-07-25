package io.github.satoshun.pino.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun Main(
  parentState: HomeState,
  state: HomeTabState.MainState,
  paddingValues: PaddingValues,
) {
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
      PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = state.isRefreshing,
        onRefresh = {
          parentState.eventSink(HomeEvent.Refresh)
        },
      ) {
        Images(
          images = state.images,
          contentPadding = paddingValues,
          onImageClick = {
            parentState.eventSink(HomeEvent.GoToImageDetail(it))
          },
          onImageLongClick = {
            parentState.eventSink(HomeEvent.GoToImageModalBottom(it))
          },
        )
      }
    }
  }
}
