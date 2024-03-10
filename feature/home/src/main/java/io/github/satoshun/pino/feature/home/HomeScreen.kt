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
class HomeState(
  val tabState: HomeTabState,
  val currentTab: HomeTab,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState

@Stable
sealed interface HomeTabState {

  @Stable
  sealed interface MainState : HomeTabState {
    @Stable
    data object Loading : MainState

    @Stable
    data class Success(
      val images: List<Image>,
    ) : MainState
  }

  @Stable
  sealed interface SearchState : HomeTabState {
    @Stable
    data object Loading : SearchState

    @Stable
    data class Success(
      val searchResults: List<Image>?,
    ) : SearchState
  }
}

enum class HomeTab(
  val index: Int,
) {
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

@Stable
interface HomeNavigator {
  fun goToNext(navigator: Navigator, image: Image)
}
