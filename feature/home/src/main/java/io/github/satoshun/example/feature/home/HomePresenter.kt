package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.example.share.data.HomeRepository
import io.github.satoshun.example.share.data.Image

class HomePresenter @AssistedInject internal constructor(
  @Assisted private val navigator: Navigator,
  private val homeNavigator: HomeNavigator,
  private val homeRepository: HomeRepository,
) : Presenter<HomeState> {
  @CircuitInject(HomeScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): HomePresenter
  }

  @Composable
  override fun present(): HomeState {
    var count by rememberSaveable { mutableIntStateOf(0) }
    val images by produceState(initialValue = emptyList<Image>()) {
      value = homeRepository.getImages()
    }

    return HomeState(
      count = count,
      images = images,
    ) { event ->
      when (event) {
        is HomeEvent.GoToImageDetail -> {
          homeNavigator.goToNext(navigator, event.image)
        }
      }
    }
  }
}
