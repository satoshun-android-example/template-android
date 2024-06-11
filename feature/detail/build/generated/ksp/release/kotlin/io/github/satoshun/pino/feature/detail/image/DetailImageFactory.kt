package io.github.satoshun.pino.feature.detail.image

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class DetailImageFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is DetailImageScreen -> ui<DetailImageState> { state, modifier -> DetailImage(state = state, modifier = modifier) }
    else -> null
  }
}
