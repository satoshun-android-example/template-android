package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeScreen : Screen

data class HomeState(
  val count: Int,
  val eventSink: (HomeEvent) -> Unit,
) : CircuitUiState

sealed interface HomeEvent {
  data object Next : HomeEvent
}

interface HomeNavigator {
  fun goToNext(navigator: Navigator, count: Int)
}

class HomePresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
  private val homeNavigator: HomeNavigator,
) : Presenter<HomeState> {
  @CircuitInject(HomeScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): HomePresenter
  }

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
