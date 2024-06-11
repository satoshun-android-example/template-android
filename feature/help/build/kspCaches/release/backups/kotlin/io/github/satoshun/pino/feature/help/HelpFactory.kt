package io.github.satoshun.pino.feature.help

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class HelpFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is HelpScreen -> ui<HelpState> { state, modifier -> Help(state = state, modifier = modifier) }
    else -> null
  }
}
