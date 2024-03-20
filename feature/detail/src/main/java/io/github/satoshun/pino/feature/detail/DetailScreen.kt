package io.github.satoshun.pino.feature.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.share.data.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreen(
  val image: Image,
) : Screen

@Stable
data class DetailState(
  val image: Image,
  val user: DetailUser?,
  val eventSink: (DetailEvent) -> Unit,
) : CircuitUiState

sealed interface DetailEvent

class DetailPresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
  @Assisted private val screen: DetailScreen,
) : Presenter<DetailState> {
  @CircuitInject(DetailScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      screen: DetailScreen,
      navigator: Navigator,
    ): DetailPresenter
  }

  @Composable
  override fun present(): DetailState {
    return DetailState(
      image = screen.image,
      user = null,
    ) { event ->
    }
  }
}
