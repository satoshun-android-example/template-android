package io.github.satoshun.example.feature.next

import androidx.compose.runtime.Composable
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
data class NextScreen(
  val count: Int,
) : Screen

data class NextState(
  val count: Int,
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
      count = screen.count,
      user = null,
    )
  }
}
