package io.github.satoshun.pino.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(HomeScreen::class, SingletonComponent::class)
@Composable
internal fun Home(
  state: HomeState,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(title = {
        Text(text = "Images")
      })
    },
    bottomBar = {
      NavigationBar(
        modifier = Modifier,
      ) {
        NavigationBarItem(
          selected = true,
          onClick = {
            state.eventSink(HomeEvent.ChangeTab(HomeTab.Home))
          },
          icon = {
            Icon(
              imageVector = Icons.Default.Home,
              contentDescription = null,
            )
          },
          label = {
            Text(text = "ホーム")
          },
        )
        NavigationBarItem(
          selected = false,
          onClick = {
            state.eventSink(HomeEvent.ChangeTab(HomeTab.Search))
          },
          icon = {
            Icon(
              imageVector = Icons.Default.Search,
              contentDescription = null,
            )
          },
          label = {
            Text(text = "検索")
          },
        )
      }
    },
  ) { paddingValues ->
    when (state) {
      is HomeState.MainState -> {
        Main(state, paddingValues)
      }
      is HomeState.SearchState -> {
        Search(state, paddingValues)
      }
    }
  }
}
