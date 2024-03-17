package io.github.satoshun.pino.feature.home.notification

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent

class NotificationPresenter @AssistedInject internal constructor(
  @Assisted private val navigator: Navigator,
) : Presenter<NotificationState> {
  @CircuitInject(NotificationScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): NotificationPresenter
  }

  @Composable
  override fun present(): NotificationState {
    return NotificationState()
  }
}
