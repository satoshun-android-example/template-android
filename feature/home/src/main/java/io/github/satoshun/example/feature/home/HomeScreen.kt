package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Stable
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.screen.Screen
import io.github.satoshun.example.share.data.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeScreen : Screen

@Stable
data class HomeState(
  val images: List<Image>,
  val isLoading: Boolean,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState

@Stable
sealed interface HomeEvent {
  data class GoToImageDetail(
    val image: Image
  ) : HomeEvent
}

interface HomeNavigator {
  fun goToNext(navigator: Navigator, image: Image)
}
