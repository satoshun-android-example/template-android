package io.github.satoshun.pino.feature.home

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class HomeFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    HomeScreen -> ui<HomeState> { state, modifier -> Home(state = state, modifier = modifier) }
    else -> null
  }
}
