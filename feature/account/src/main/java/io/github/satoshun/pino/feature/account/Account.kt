package io.github.satoshun.pino.feature.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.designsystem.SectionTitle

@CircuitInject(AccountScreen::class, SingletonComponent::class)
@Composable
internal fun Account(
  state: AccountState,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      AccountTopBar(
        onBack = {
          state.eventSink(AccountEvent.Back)
        },
        onHelp = {
          state.eventSink(AccountEvent.GoToHelp)
        },
      )
    },
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = paddingValues,
    ) {
      basic()
      item { Spacer(Modifier.height(18.dp)) }
      detail()
    }
  }
}

private fun LazyListScope.basic() {
  item {
    SectionTitle(stringResource(R.string.account_basic_title))
  }

  item { Spacer(Modifier.height(12.dp)) }

  itemsIndexed(AccountBasicType.entries, key = { _, entry -> entry }) { index, entry ->
    Entry(
      text = stringResource(entry.title),
      index = index,
      lastIndex = AccountBasicType.entries.lastIndex,
      onClick = {
        // TODO
      },
    )
  }
}

private fun LazyListScope.detail() {
  item {
    SectionTitle(stringResource(R.string.account_detail_title))
  }

  item { Spacer(Modifier.height(12.dp)) }

  itemsIndexed(AccountDetailType.entries, key = { _, entry -> entry }) { index, entry ->
    Entry(
      text = stringResource(entry.title),
      index = index,
      lastIndex = AccountDetailType.entries.lastIndex,
      onClick = {
        // TODO
      },
    )
  }
}

@Composable
private fun Entry(
  text: String,
  index: Int,
  lastIndex: Int,
  onClick: () -> Unit,
) {
  Box(
    Modifier
      .fillMaxWidth()
      .clickable { onClick() },
  ) {
    Box(
      modifier = Modifier.padding(vertical = 16.dp),
    ) {
      Text(
        modifier = Modifier
          .padding(horizontal = 16.dp)
          .align(Alignment.CenterStart),
        text = text,
      )
    }

    if (index != lastIndex) {
      HorizontalDivider(
        Modifier
          .fillMaxWidth()
          .align(Alignment.BottomStart),
      )
    }
  }
}

@Composable
private fun AccountTopBar(
  onBack: () -> Unit,
  onHelp: () -> Unit,
) {
  TopAppBar(
    title = {
      Text(stringResource(R.string.account_title))
    },
    navigationIcon = {
      IconButton(onClick = onBack) {
        Icon(
          imageVector = Icons.AutoMirrored.Default.ArrowBack,
          contentDescription = null,
        )
      }
    },
    actions = {
      IconButton(onClick = onHelp) {
        Icon(
          // TODO Help icon
          imageVector = Icons.Default.Info,
          contentDescription = null,
        )
      }
    },
  )
}
