package io.github.satoshun.pino.feature.home

import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
        Text(text = stringResource(R.string.home_title))
      })
    },
    bottomBar = {
      PinoNavigationBar(
        currentTab = state.currentTab,
        onHomeClick = {
          state.eventSink(HomeEvent.ChangeTab(HomeTab.Home))
        },
        onSearchClick = {
          state.eventSink(HomeEvent.ChangeTab(HomeTab.Search))
        },
      )
    },
    contentWindowInsets = WindowInsets(0.dp),
  ) { paddingValues ->
    when (state.tabState) {
      is HomeTabState.MainState -> {
        Main(state, state.tabState, paddingValues)
      }
      is HomeTabState.SearchState -> {
        Search(state, state.tabState, paddingValues)
      }
    }
  }
}

@Composable
private fun PinoNavigationBar(
  currentTab: HomeTab,
  onHomeClick: () -> Unit,
  onSearchClick: () -> Unit,
) {
  NavigationBar {
    NavigationBarItem(
      selected = currentTab == HomeTab.Home,
      onClick = onHomeClick,
      icon = {
        Icon(
          imageVector = Icons.Default.Home,
          contentDescription = null,
        )
      },
      label = {
        Text(text = stringResource(R.string.home_main))
      },
    )
    NavigationBarItem(
      selected = currentTab == HomeTab.Search,
      onClick = onSearchClick,
      icon = {
        Icon(
          imageVector = Icons.Default.Search,
          contentDescription = null,
        )
      },
      label = {
        Text(text = stringResource(R.string.home_search))
      },
    )
  }
}
