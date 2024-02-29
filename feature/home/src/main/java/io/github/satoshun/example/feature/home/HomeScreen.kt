package io.github.satoshun.example.feature.home

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeScreen : Screen

data class HomeState(
  val count: Int,
  val images: List<Image>,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState

sealed interface HomeEvent {
  data object GoToNext : HomeEvent
}

interface HomeNavigator {
  fun goToNext(navigator: Navigator, count: Int)
}
