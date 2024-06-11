package io.github.satoshun.pino.feature.home.notification

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

public class NotificationFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? = when (screen) {
    is NotificationScreen -> ui<NotificationState> { state, modifier -> Notification(state = state, modifier = modifier) }
    else -> null
  }
}
