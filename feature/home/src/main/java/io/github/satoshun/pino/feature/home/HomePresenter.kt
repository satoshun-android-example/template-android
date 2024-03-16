package io.github.satoshun.pino.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.overlay.LocalOverlayHost
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.internal.rememberStableCoroutineScope
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.share.data.HomeRepository
import io.github.satoshun.pino.share.data.Image
import kotlinx.coroutines.launch

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
    var imagesRefreshSeed by rememberSaveable { mutableIntStateOf(0) }

    var isRefreshing by rememberSaveable { mutableStateOf(false) }
    var images by rememberSaveable { mutableStateOf<List<Image>?>(null) }
    LaunchedEffect(Unit) {
      snapshotFlow { imagesRefreshSeed }
        .collect {
          isRefreshing = true
          images = homeRepository.getImages(it)
          isRefreshing = false
        }
    }

    if (searchQuery.isNotEmpty()) {
      LaunchedEffect(searchQuery) {
        searchResult = homeRepository.searchImages(searchQuery)
        searchQuery = ""
      }
    }

    val overlayHost = LocalOverlayHost.current
    val scope = rememberStableCoroutineScope()
    val eventSink: (HomeEvent) -> Unit = { event ->
      when (event) {
        is HomeEvent.GoToImageDetail -> {
          scope.launch {
            homeNavigator.goToNext(overlayHost, event.image)
          }
        }
        is HomeEvent.ChangeTab -> {
          currentTab = event.tab
        }
        is HomeEvent.Search -> {
          searchQuery = event.query
        }
        HomeEvent.Refresh -> {
          imagesRefreshSeed += 1
        }
        HomeEvent.TopBar.AccountClick -> {
          homeNavigator.goToAccount(navigator)
        }
      }
    }
    val tabState = when (currentTab) {
      HomeTab.Home -> produceMainState(images, isRefreshing)
      HomeTab.Search -> produceSearchState(searchResult, searchQuery.isNotEmpty())
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
    isRefreshing: Boolean,
  ): HomeTabState.MainState =
    if (images == null) {
      HomeTabState.MainState.Loading
    } else {
      HomeTabState.MainState.Success(
        images = images,
        isRefreshing = isRefreshing,
      )
    }

  @Composable
  private fun produceSearchState(
    images: List<Image>?,
    isSearching: Boolean,
  ): HomeTabState.SearchState =
    when {
      isSearching -> HomeTabState.SearchState.Loading(
        searchResults = images,
      )
      else -> HomeTabState.SearchState.Success(
        searchResults = images,
      )
    }
}
