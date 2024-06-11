package io.github.satoshun.pino.feature.detail

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class DetailFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is DetailScreen -> ui<DetailState> { state, modifier -> Detail(state = state, modifier = modifier) }
    else -> null
  }
}
