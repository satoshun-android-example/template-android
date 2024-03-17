package io.github.satoshun.pino.feature.account

import androidx.annotation.StringRes
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

sealed interface AccountEvent {
  data object Back : AccountEvent
}

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
    return AccountState(eventSink = {
      when (it) {
        AccountEvent.Back -> {
          navigator.pop()
        }
      }
    })
  }
}

enum class AccountBasicType(
  @StringRes val title: Int,
) {
  Language(title = R.string.account_language),
  Notification(title = R.string.account_notification),
  Theme(title = R.string.account_theme),
  Network(title = R.string.account_network),
}

enum class AccountDetailType(
  @StringRes val title: Int,
) {
  Download(title = R.string.account_download),
  Site(title = R.string.account_site),
  About(title = R.string.account_about),
}
