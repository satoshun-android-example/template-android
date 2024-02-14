package io.github.satoshun.example.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
internal fun HomeContent(
  state: HomeScreen.State,
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
    LazyVerticalGrid(
      columns = GridCells.Adaptive(120.dp),
      modifier = Modifier.fillMaxSize(),
      contentPadding = paddingValues
    ) {
      item {
        Button(onClick = {
          state.eventSink(HomeScreen.Event.Next)
        }) {
          Text(text = "Next")
        }
      }
      items((1..500).map { it }) {
        AsyncImage(
          modifier = Modifier.height(120.dp),
          model = "https://p-hold.com/400/300?id=$it",
          contentDescription = null,
        )
      }
    }
  }
}
