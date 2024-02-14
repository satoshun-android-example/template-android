package io.github.satoshun.example.feature.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.presenter.presenterOf
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data object HomeScreen : Screen {
  internal data class State(
    val count: Int,
    val eventSink: (Event) -> Unit,
  ) : CircuitUiState

  internal sealed interface Event {
    data object Next : Event
  }
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
      is HomeScreen -> presenterOf { HomePresenter(navigator, homeNavigator) }
      else -> null
    }
  }
}

@SuppressLint("ComposableNaming")
@Composable
internal fun HomePresenter(
  navigator: Navigator,
  homeNavigator: HomeNavigator,
): HomeScreen.State {
  var count by rememberSaveable { mutableIntStateOf(0) }
  return HomeScreen.State(count = count) { event ->
    when (event) {
      is HomeScreen.Event.Next -> {
        homeNavigator.goToNext(navigator, count)
      }
    }
  }
}

internal class HomeUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is HomeScreen -> ui<HomeScreen.State> { state, modifier ->
        HomeContent(state, modifier)
      }

      else -> null
    }
  }
}
