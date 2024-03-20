package io.github.satoshun.pino.feature.detail.imageinfo

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
data class DetailImageInfoScreen(
  val image: Image,
) : Screen

@Stable
data class DetailImageInfoState(
  val image: Image,
  val eventSink: (DetailImageInfoEvent) -> Unit,
) : CircuitUiState

sealed interface DetailImageInfoEvent

class DetailImageInfoPresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
  @Assisted private val screen: DetailImageInfoScreen,
) : Presenter<DetailImageInfoState> {
  @CircuitInject(DetailImageInfoScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      screen: DetailImageInfoScreen,
      navigator: Navigator,
    ): DetailImageInfoPresenter
  }

  @Composable
  override fun present(): DetailImageInfoState {
    return DetailImageInfoState(
      image = screen.image,
    ) { event ->
    }
  }
}
