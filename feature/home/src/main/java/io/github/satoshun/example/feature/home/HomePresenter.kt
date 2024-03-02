package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
    // TODO: produceState is not working? cuz rememberSaveable is not used
    var images by rememberSaveable {
      mutableStateOf<List<Image>?>(null)
    }
    LaunchedEffect(Unit) {
      images = homeRepository.getImages()
    }

    return HomeState(
      images = images.orEmpty(),
      isLoading = images == null,
    ) { event ->
      when (event) {
        is HomeEvent.GoToImageDetail -> {
          homeNavigator.goToNext(navigator, event.image)
        }
      }
    }
  }
}
