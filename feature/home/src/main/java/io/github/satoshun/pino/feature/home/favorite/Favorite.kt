package io.github.satoshun.pino.feature.home.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.satoshun.pino.feature.home.HomeState
import io.github.satoshun.pino.feature.home.HomeTabState

@Composable
internal fun Favorite(
  parentState: HomeState,
  state: HomeTabState.FavoriteState,
  paddingValues: PaddingValues,
) {
  Box(modifier = Modifier.padding(paddingValues)) {
    Text(text = "Favorite")
  }
}
