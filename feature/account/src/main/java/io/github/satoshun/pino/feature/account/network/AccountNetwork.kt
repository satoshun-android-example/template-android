package io.github.satoshun.pino.feature.account.network

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(AccountNetworkScreen::class, SingletonComponent::class)
@Composable
internal fun AccountNetwork(
  state: AccountNetworkState,
  modifier: Modifier = Modifier,
) {
  LazyColumn(modifier = modifier) {
    items(state.items) {
      Text(text = it)
    }
  }
}
