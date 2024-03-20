package io.github.satoshun.pino.feature.account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import io.github.satoshun.pino.feature.account.basic.AccountBasicScreen
import io.github.satoshun.pino.feature.account.network.AccountNetworkScreen
import kotlinx.parcelize.Parcelize

@Parcelize
class AccountNavScreen(
  val tab: AccountTab,
) : Screen

@Stable
class AccountNavState : CircuitUiState

sealed interface AccountNavEvent

class AccountNavPresenter @AssistedInject constructor(
  @Assisted private val screen: AccountNavScreen,
  @Assisted private val navigator: Navigator,
) : Presenter<AccountNavState> {
  @CircuitInject(AccountNavScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(
      screen: AccountNavScreen,
      navigator: Navigator,
    ): AccountNavPresenter
  }

  @Composable
  override fun present(): AccountNavState {
    LaunchedEffect(screen.tab) {
      when (screen.tab) {
        AccountTab.Basic -> navigator.resetRoot(
          newRoot = AccountBasicScreen(),
          saveState = true,
          restoreState = true,
        )
        AccountTab.Network -> navigator.resetRoot(
          newRoot = AccountNetworkScreen(),
          saveState = true,
          restoreState = true,
        )
      }
    }
    return AccountNavState()
  }
}
