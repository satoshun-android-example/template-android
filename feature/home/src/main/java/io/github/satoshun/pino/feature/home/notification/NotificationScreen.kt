package io.github.satoshun.pino.feature.home.notification

import androidx.compose.runtime.Stable
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object NotificationScreen : Screen

@Stable
class NotificationState() : CircuitUiState

@Stable
sealed interface NotificationEvent {
}
