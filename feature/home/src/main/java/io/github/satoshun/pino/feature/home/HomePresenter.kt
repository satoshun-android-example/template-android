package io.github.satoshun.pino.feature.home

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
import io.github.satoshun.pino.share.data.HomeRepository
import io.github.satoshun.pino.share.data.Image
import io.github.satoshun.pino.share.ui.produceStateSaveable

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
    var currentTab by rememberSaveable { mutableStateOf(HomeTab.Home) }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var searchResult by rememberSaveable { mutableStateOf<List<Image>?>(null) }

    val images by produceStateSaveable<List<Image>?>(null) {
      value = homeRepository.getImages()
    }
    if (searchQuery.isNotEmpty()) {
      LaunchedEffect(searchQuery) {
        searchResult = homeRepository.searchImages(searchQuery)
      }
    }

    val eventSink: (HomeEvent) -> Unit = { event ->
      when (event) {
        is HomeEvent.GoToImageDetail -> {
          homeNavigator.goToNext(navigator, event.image)
        }
        is HomeEvent.ChangeTab -> {
          currentTab = event.tab
        }
        is HomeEvent.Search -> {
          searchQuery = event.query
        }
      }
    }
    val tabState = when (currentTab) {
      HomeTab.Home -> produceMainState(images)
      HomeTab.Search -> produceSearchState(searchResult)
    }

    return HomeState(
      tabState = tabState,
      currentTab = currentTab,
      eventSink = eventSink,
    )
  }

  @Composable
  private fun produceMainState(
    images: List<Image>?,
  ): HomeTabState.MainState =
    if (images == null) {
      HomeTabState.MainState.Loading
    } else {
      HomeTabState.MainState.Success(
        images = images,
      )
    }

  @Composable
  private fun produceSearchState(
    images: List<Image>?,
  ): HomeTabState.SearchState =
    HomeTabState.SearchState.Success(
      searchResults = images,
    )
}
