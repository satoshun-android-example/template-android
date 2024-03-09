package io.github.satoshun.pino.feature.next

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
data class NextScreen(
  val image: Image,
) : Screen

@Stable
data class NextState(
  val image: Image,
  val user: NextUser?,
) : CircuitUiState

sealed interface NextEvent

class NextPresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
  @Assisted private val screen: NextScreen,
) : Presenter<NextState> {
  @CircuitInject(NextScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      screen: NextScreen,
      navigator: Navigator,
    ): NextPresenter
  }

  @Composable
  override fun present(): NextState {
    return NextState(
      image = screen.image,
      user = null,
    )
  }
}
