package io.github.satoshun.pino.feature.home

import androidx.compose.runtime.Stable
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.screen.Screen
import io.github.satoshun.pino.share.data.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeScreen : Screen

@Stable
sealed class HomeState(
  val currentTab: HomeTab,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState {

  sealed class MainState(
    currentTab: HomeTab,
    eventSink: (HomeEvent) -> Unit,
  ) : HomeState(currentTab, eventSink) {
    class Loading(
      currentTab: HomeTab,
      eventSink: (HomeEvent) -> Unit,
    ) : MainState(currentTab, eventSink)

    class Success(
      val images: List<Image>,
      currentTab: HomeTab,
      eventSink: (HomeEvent) -> Unit,
    ) : MainState(currentTab, eventSink)
  }

  sealed class SearchState(
    currentTab: HomeTab,
    eventSink: (HomeEvent) -> Unit,
  ) : HomeState(currentTab, eventSink) {
    class Loading(
      currentTab: HomeTab,
      eventSink: (HomeEvent) -> Unit,
    ) : SearchState(currentTab, eventSink)

    class Success(
      val searchResults: List<Image>?,
      currentTab: HomeTab,
      eventSink: (HomeEvent) -> Unit,
    ) : SearchState(currentTab, eventSink)
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

  data class Search(
    val query: String,
  ) : HomeEvent
}

interface HomeNavigator {
  fun goToNext(navigator: Navigator, image: Image)
}
