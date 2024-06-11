package io.github.satoshun.pino.feature.account

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class AccountFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is AccountScreen -> ui<AccountState> { state, modifier -> Account(state = state, modifier = modifier) }
    else -> null
  }
}
