package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data object HomeScreen : Screen

internal data class HomeState(
  val count: Int,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState

internal sealed interface HomeEvent {
  data object Next : HomeEvent
}


interface HomeNavigator {
  fun goToNext(navigator: Navigator, count: Int)
}

internal class HomePresenterFactory @Inject constructor(
  private val homeNavigator: HomeNavigator,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? {
    return when (screen) {
      is HomeScreen -> HomePresenter(navigator, homeNavigator)
      else -> null
    }
  }
}

internal class HomePresenter(
  private val navigator: Navigator,
  private val homeNavigator: HomeNavigator,
) : Presenter<HomeState> {
  @Composable
  override fun present(): HomeState {
    var count by rememberSaveable { mutableIntStateOf(0) }
    return HomeState(count = count) { event ->
      when (event) {
        is HomeEvent.Next -> {
          homeNavigator.goToNext(navigator, count)
        }
      }
    }
  }
}

internal class HomeUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is HomeScreen -> ui<HomeState> { state, modifier ->
        HomeContent(state, modifier)
      }
      else -> null
    }
  }
}
