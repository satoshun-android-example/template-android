package io.github.satoshun.pino.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
      val pullToRefreshState = rememberPullToRefreshState()
      PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        state = pullToRefreshState,
        isRefreshing = state.isRefreshing,
        onRefresh = {
          parentState.eventSink(HomeEvent.Refresh)
        },
        indicator = {
          PullToRefreshDefaults.Indicator(
            modifier = Modifier
              .align(Alignment.TopCenter)
              .padding(top = 96.dp),
            state = pullToRefreshState,
            isRefreshing = state.isRefreshing,
          )
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
