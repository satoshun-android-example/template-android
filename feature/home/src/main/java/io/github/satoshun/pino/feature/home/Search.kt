package io.github.satoshun.pino.feature.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp

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
        PinoSearchBar(
          state = state,
          paddingValues = paddingValues,
          onSearch = { query ->
            searchState.eventSink(HomeEvent.Search(query))
          },
        )
      }
    }
  }
}

@Composable
private fun PinoSearchBar(
  state: HomeState.SearchState.Success,
  paddingValues: PaddingValues,
  onSearch: (String) -> Unit,
) {
  var text by rememberSaveable { mutableStateOf("") }
  var active by rememberSaveable { mutableStateOf(false) }

  Box(
    Modifier
      // TODO
//      .padding(paddingValues)
      .padding(top = 64.dp)
      .fillMaxSize()
      .semantics { isTraversalGroup = true },
  ) {
    SearchBar(
      modifier = Modifier
        .align(Alignment.TopCenter)
        .semantics { traversalIndex = -1f },
      query = text,
      onQueryChange = { text = it },
      onSearch = {
        active = false
        onSearch(text)
      },
      active = active,
      onActiveChange = {
        active = it
      },
      placeholder = { Text("Input Image Name") },
      leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
      trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
    ) {
      repeat(4) { idx ->
        val resultText = when (idx) {
          0 -> "りんご"
          1 -> "みかん"
          2 -> "いちご"
          else -> "すいか"
        }
        ListItem(
          modifier = Modifier
            .clickable {
              text = resultText
              active = false
            }
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
          headlineContent = { Text(resultText) },
          leadingContent = { Icon(Icons.Filled.Star, contentDescription = null) },
        )
      }
    }

    if (state.searchResults != null) {
      Images(
        images = state.searchResults,
        contentPadding = PaddingValues(top = 136.dp, bottom = 16.dp),
        onImageClick = {
          state.eventSink(HomeEvent.GoToImageDetail(it))
        },
      )
    }
  }
}
