package io.github.satoshun.pino.feature.account

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(AccountNavScreen::class, SingletonComponent::class)
@Composable
internal fun AccountNav(
  state: AccountNavState,
  modifier: Modifier = Modifier,
) {
}
