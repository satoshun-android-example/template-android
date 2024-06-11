package io.github.satoshun.pino.feature.detail.imageinfo

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class DetailImageInfoPresenterFactory @Inject constructor(
  private val factory: DetailImageInfoPresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is DetailImageInfoScreen -> factory.create(screen = screen, navigator = navigator)
    else -> null
  }
}
