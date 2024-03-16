package io.github.satoshun.pino.feature.account

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
class AccountScreen : Screen

@Stable
class AccountState(
  val eventSink: (AccountEvent) -> Unit,
) : CircuitUiState

sealed interface AccountEvent

class AccountPresenter @AssistedInject constructor(
  @Assisted private val navigator: Navigator,
  @Assisted private val screen: AccountScreen,
) : Presenter<AccountState> {
  @CircuitInject(AccountScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      screen: AccountScreen,
      navigator: Navigator,
    ): AccountPresenter
  }

  @Composable
  override fun present(): AccountState {
    return AccountState(eventSink = {})
  }
}
