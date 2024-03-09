package io.github.satoshun.example.feature.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun Search(
  searchState: HomeState.SearchState,
  paddingValues: PaddingValues,
) {
  val transition = updateTransition(searchState, label = "isLoading")
  transition.AnimatedContent { state ->
    when (state) {
      is HomeState.SearchState.Loading -> {
        Box(
          modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
          contentAlignment = Alignment.Center,
        ) {
          CircularProgressIndicator()
        }
      }
      is HomeState.SearchState.Success -> {
        Column(Modifier.padding(paddingValues)) {
          PinoSearchBar()
        }
      }
    }
  }
}

@Composable
private fun PinoSearchBar() {
}
