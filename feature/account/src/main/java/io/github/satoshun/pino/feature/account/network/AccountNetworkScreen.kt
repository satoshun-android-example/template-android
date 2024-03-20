package io.github.satoshun.pino.feature.account.network

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import kotlinx.parcelize.Parcelize

@Parcelize
class AccountNetworkScreen : Screen

@Stable
class AccountNetworkState : CircuitUiState

sealed interface AccountNetworkEvent

class AccountNetworkPresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
) : Presenter<AccountNetworkState> {
  @CircuitInject(AccountNetworkScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      navigator: Navigator,
    ): AccountNetworkPresenter
  }

  @Composable
  override fun present(): AccountNetworkState {
    return AccountNetworkState()
  }
}
