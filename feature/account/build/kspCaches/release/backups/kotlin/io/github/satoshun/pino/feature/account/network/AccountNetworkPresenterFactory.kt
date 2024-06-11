package io.github.satoshun.pino.feature.account.network

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class AccountNetworkPresenterFactory @Inject constructor(
  private val factory: AccountNetworkPresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    is AccountNetworkScreen -> factory.create(navigator = navigator)
    else -> null
  }
}
