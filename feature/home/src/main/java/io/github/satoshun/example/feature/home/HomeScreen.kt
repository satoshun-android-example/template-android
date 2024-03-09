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
sealed class HomeState(
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState {

  sealed class MainState(
    eventSink: (HomeEvent) -> Unit,
  ) : HomeState(eventSink) {
    class Loading(
      eventSink: (HomeEvent) -> Unit,
    ) : MainState(eventSink)

    class Success(
      val images: List<Image>,
      eventSink: (HomeEvent) -> Unit,
    ) : MainState(eventSink)
  }

  sealed class SearchState(
    eventSink: (HomeEvent) -> Unit,
  ) : HomeState(eventSink) {
    class Loading(
      eventSink: (HomeEvent) -> Unit,
    ) : SearchState(eventSink)

    class Success(
      eventSink: (HomeEvent) -> Unit,
    ) : SearchState(eventSink)
  }
}

enum class HomeTab(val index: Int) {
  Home(0),
  Search(1),
}

@Stable
sealed interface HomeEvent {
  data class GoToImageDetail(
    val image: Image
  ) : HomeEvent

  data class ChangeTab(
    val tab: HomeTab,
  ) : HomeEvent
}

interface HomeNavigator {
  fun goToNext(navigator: Navigator, image: Image)
}
