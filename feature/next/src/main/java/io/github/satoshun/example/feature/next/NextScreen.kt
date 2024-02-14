package io.github.satoshun.example.feature.next

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.presenter.presenterOf
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class NextScreen(
  val count: Int,
) : Screen {
  internal data class State(
    val count: Int,
    val user: NextUser?,
  ) : CircuitUiState

  internal sealed interface Event
}

@SuppressLint("ComposableNaming")
@Composable
internal fun NextPresenter(
  initialCount: Int,
  navigator: Navigator,
): NextScreen.State {
  return NextScreen.State(
    count = initialCount,
    user = null,
  )
}

internal class NextPresenterFactory @Inject constructor(
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? {
    return when (screen) {
      is NextScreen -> presenterOf {
        NextPresenter(
          initialCount = screen.count,
          navigator = navigator,
        )
      }

      else -> null
    }
  }
}

internal class NextUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is NextScreen -> ui<NextScreen.State> { state, modifier ->
        NextContent(state, modifier)
      }

      else -> null
    }
  }
}
