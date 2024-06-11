package io.github.satoshun.pino.feature.detail.image

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class DetailImagePresenterFactory @Inject constructor(
  private val factory: DetailImagePresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is DetailImageScreen -> factory.create(screen = screen, navigator = navigator)
    else -> null
  }
}
