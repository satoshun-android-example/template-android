package io.github.satoshun.example.feature.home

import androidx.compose.runtime.Composable
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
import io.github.satoshun.example.share.ui.produceStateSaveable

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
    val images by produceStateSaveable<List<Image>?>(null) {
      value = homeRepository.getImages()
    }
    var currentTab by rememberSaveable { mutableStateOf(HomeTab.Home) }

    val eventSink: (HomeEvent) -> Unit = { event ->
      when (event) {
        is HomeEvent.GoToImageDetail -> {
          homeNavigator.goToNext(navigator, event.image)
        }
        is HomeEvent.ChangeTab -> {
          currentTab = event.tab
        }
      }
    }
    return when (currentTab) {
      HomeTab.Home -> produceMainState(images, eventSink)
      HomeTab.Search -> produceSearchState(eventSink)
    }
  }

  @Composable
  private fun produceMainState(
    images: List<Image>?,
    eventSink: (HomeEvent) -> Unit,
  ): HomeState.MainState =
    if (images == null) {
      HomeState.MainState.Loading(
        eventSink = eventSink,
      )
    } else {
      HomeState.MainState.Success(
        images = images,
        eventSink = eventSink,
      )
    }

  @Composable
  private fun produceSearchState(
    eventSink: (HomeEvent) -> Unit,
  ): HomeState.SearchState =
    HomeState.SearchState.Success(
      eventSink = eventSink,
    )
}
