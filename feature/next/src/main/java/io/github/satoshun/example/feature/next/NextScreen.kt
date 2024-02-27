package io.github.satoshun.example.feature.next

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NextScreen(
  val count: Int,
) : Screen

internal data class NextState(
  val count: Int,
  val user: NextUser?,
) : CircuitUiState

internal sealed interface NextEvent

internal class NextPresenter(
  private val initialCount: Int,
  private val navigator: Navigator,
) : Presenter<NextState> {
  @Composable
  override fun present(): NextState {
    return NextState(
      count = initialCount,
      user = null,
    )
  }
}

internal class NextPresenterFactory @Inject constructor(
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? {
    return when (screen) {
      is NextScreen -> NextPresenter(
        initialCount = screen.count,
        navigator = navigator,
      )
      else -> null
    }
  }
}

internal class NextUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is NextScreen -> ui<NextState> { state, modifier ->
        NextContent(state, modifier)
      }
      else -> null
    }
  }
}
