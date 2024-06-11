package io.github.satoshun.pino.feature.home.notification

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class NotificationPresenterFactory @Inject constructor(
  private val factory: NotificationPresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is NotificationScreen -> factory.create(navigator = navigator, screen = screen)
    else -> null
  }
}
