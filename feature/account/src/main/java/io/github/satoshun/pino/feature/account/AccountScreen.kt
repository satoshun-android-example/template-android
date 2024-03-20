package io.github.satoshun.pino.feature.account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
  val currentTab: AccountTab,
  val eventSink: (AccountEvent) -> Unit,
) : CircuitUiState

sealed interface AccountEvent {
  data object Back : AccountEvent
  data object ToBasic : AccountEvent
  data object ToNetwork : AccountEvent
  data object GoToHelp : AccountEvent
}

class AccountPresenter @AssistedInject constructor(
  private val accountNavigator: AccountNavigator,
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
    var currentTab by rememberSaveable {
      mutableStateOf(AccountTab.Basic)
    }

    return AccountState(
      currentTab = currentTab,
    ) {
      when (it) {
        AccountEvent.Back -> {
          navigator.pop()
        }
        AccountEvent.GoToHelp -> {
          accountNavigator.gotoHelp(navigator)
        }
        AccountEvent.ToBasic -> {
          currentTab = AccountTab.Basic
        }
        AccountEvent.ToNetwork -> {
          currentTab = AccountTab.Network
        }
      }
    }
  }
}

enum class AccountTab {
  Basic,
  Network,
}
