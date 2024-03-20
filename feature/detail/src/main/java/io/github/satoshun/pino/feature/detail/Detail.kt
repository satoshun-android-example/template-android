@file:OptIn(ExperimentalFoundationApi::class)

package io.github.satoshun.pino.feature.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.feature.detail.image.DetailImageScreen
import io.github.satoshun.pino.feature.detail.imageinfo.DetailImageInfoScreen

@CircuitInject(DetailScreen::class, SingletonComponent::class)
@Composable
internal fun Detail(
  state: DetailState,
  modifier: Modifier = Modifier,
) {
  val pagerState = rememberPagerState { 2 }
  Scaffold(modifier) { paddingValues ->
    HorizontalPager(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues),
      state = pagerState,
      beyondBoundsPageCount = 1,
    ) {
      when (it) {
        0 -> CircuitContent(screen = DetailImageScreen(state.image))
        1 -> CircuitContent(screen = DetailImageInfoScreen(state.image))
      }
    }
  }
}
