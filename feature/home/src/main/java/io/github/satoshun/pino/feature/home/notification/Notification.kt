package io.github.satoshun.pino.feature.home.notification

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(NotificationScreen::class, SingletonComponent::class)
@Composable
internal fun Notification(
  state: NotificationState,
  modifier: Modifier = Modifier,
) {
  Text("Notification")
}
