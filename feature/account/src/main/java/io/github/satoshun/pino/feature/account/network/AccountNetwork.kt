package io.github.satoshun.pino.feature.account.network

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.designsystem.SectionTitle
import io.github.satoshun.pino.feature.account.Entry
import io.github.satoshun.pino.feature.account.R

@CircuitInject(AccountNetworkScreen::class, SingletonComponent::class)
@Composable
internal fun AccountNetwork(
  state: AccountNetworkState,
  modifier: Modifier = Modifier,
) {
  LazyColumn(modifier = modifier) {
    item {
      SectionTitle(stringResource(R.string.account_network))
    }
    item { Spacer(Modifier.height(12.dp)) }

    itemsIndexed(state.items, key = { _, entry -> entry }) { index, entry ->
      Entry(
        text = stringResource(entry.title),
        index = index,
        lastIndex = state.items.lastIndex,
        onClick = {
          // TODO
        },
      )
    }
  }
}
