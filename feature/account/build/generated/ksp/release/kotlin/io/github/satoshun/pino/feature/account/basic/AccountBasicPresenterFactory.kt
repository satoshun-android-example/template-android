package io.github.satoshun.pino.feature.account.basic

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class AccountBasicPresenterFactory @Inject constructor(
  private val factory: AccountBasicPresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is AccountBasicScreen -> factory.create(screen = screen, navigator = navigator)
    else -> null
  }
}
