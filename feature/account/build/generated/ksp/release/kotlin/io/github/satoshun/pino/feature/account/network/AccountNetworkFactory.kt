package io.github.satoshun.pino.feature.account.network

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class AccountNetworkFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is AccountNetworkScreen -> ui<AccountNetworkState> { state, modifier -> AccountNetwork(state = state, modifier = modifier) }
    else -> null
  }
}
