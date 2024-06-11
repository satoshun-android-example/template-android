package io.github.satoshun.pino.feature.account

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class AccountPresenterFactory @Inject constructor(
  private val factory: AccountPresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is AccountScreen -> factory.create(screen = screen, navigator = navigator)
    else -> null
  }
}
